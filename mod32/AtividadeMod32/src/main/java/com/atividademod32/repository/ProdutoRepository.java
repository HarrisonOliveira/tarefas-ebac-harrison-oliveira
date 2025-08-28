package com.atividademod32.repository;

import com.atividademod32.connectionFatory.ConnectionFactory;
import com.atividademod32.entity.ProdutoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PostRemove;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository implements IProdutoReposiory {

    @Override
    public ProdutoEntity cadastroProduto(ProdutoEntity produto) {
        EntityManager entityManager = ConnectionFactory.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(produto);
            entityManager.getTransaction().commit();
            return produto;
        } catch (RuntimeException e) {
            System.out.println("Erro ao cadastrar produto!" + e.getMessage());
            throw e;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public ProdutoEntity buscaProdutoPorCodigo(String codigoInterno) {
        EntityManager entityManager = ConnectionFactory.getEntityManager();
        ProdutoEntity produto;
        try {
            produto = entityManager.createQuery("SELECT p FROM ProdutoEntity p WHERE p.codigoInterno = :codigo", ProdutoEntity.class)
                    .setParameter("codigo", codigoInterno)
                    .getSingleResult();
        }catch (NoResultException e) {
            System.out.println("Produto não encontrato. Erro: " + e.getMessage() );
            throw e;
        }
        return produto;
    }

    @Override
    public List<ProdutoEntity> buscarTodosProdutos() {
        EntityManager entityManager = ConnectionFactory.getEntityManager();
        List<ProdutoEntity> produtos;

        try {

            produtos = entityManager.createQuery("SELECT p FROM ProdutoEntity p", ProdutoEntity.class)
                    .getResultList();
        } catch (HibernateException e) {
            System.out.println("Erro ao buscar todos os produtos!" + e.getMessage());
            throw e;
        }
        return produtos;
    }

    @Override
    public void atiluzarNomeDoProduto(String nomeProduto, String codigoInterno) {

        try (EntityManager entityManager = ConnectionFactory.getEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.createQuery(
                            "update ProdutoEntity p set p.nome = :nomeProduto where p.codigoInterno = :codigoInterno")
                    .setParameter("nomeProduto", nomeProduto)
                    .setParameter("codigoInterno", codigoInterno)
                    .executeUpdate();
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("Erro ao atualizar nome do produto!" + e.getMessage());
            throw e;
        }
    }

    @Override
    public void excluirProduto(String codigoInterno) {
        try (EntityManager entityManager = ConnectionFactory.getEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.createQuery("DELETE FROM ProdutoEntity p WHERE p.codigoInterno = :codigo")
                    .setParameter("codigo", codigoInterno)
                    .executeUpdate();
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            System.out.println("Erro ao excluir produto!" + e.getMessage());
            throw e;
        }
    }
}
