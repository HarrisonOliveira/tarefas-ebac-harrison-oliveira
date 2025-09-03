package com.atividadeMod33.repository;

import com.atividadeMod33.connection.ConnectionFactory;
import com.atividadeMod33.entity.Acessorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.hibernate.HibernateException;

public class AcessorioRepository implements IAcessorioRepository{
    EntityManager entityManager = ConnectionFactory.getEntityManager();

    @Override
    public void cadastrarAcessorio(Acessorio acessorio) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(acessorio);
            entityManager.getTransaction().commit();
        } catch (HibernateException e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new HibernateException("Não possível cadastrar o acessório. Erro: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Acessorio buscarAcessorioPeloCodigo(String codigoAcessorio) {
        Acessorio acessorio;
        try {
            acessorio = entityManager.createQuery("from Acessorio where codigo = :codigoAcessorio", Acessorio.class)
                    .setParameter("codigoAcessorio", codigoAcessorio)
                    .getSingleResult();
            return acessorio;
        } catch (HibernateException e){
            throw new NoResultException("Não foi encontrado nenhuma Acessório com este código. " + e.getMessage());
        }
    }


}
