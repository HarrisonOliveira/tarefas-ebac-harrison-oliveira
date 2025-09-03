package com.atividadeMod33.repository;

import com.atividadeMod33.connection.ConnectionFactory;
import com.atividadeMod33.entity.Carro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.hibernate.HibernateException;

public class CarroRepository implements ICarroRepository {

    @Override
    public void cadastrarCarro(Carro carro) {
        EntityManager entityManager = ConnectionFactory.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(carro);
            entityManager.getTransaction().commit();
        }catch (HibernateException e){
            if (entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new HibernateException("Não foi possivel cadastrar o carro. " + e.getMessage());
        }finally {
            entityManager.close();
        }
    }

    @Override
    public Carro buscarCarroPeloCodigo(String codigoCarro) {
        EntityManager entityManager = ConnectionFactory.getEntityManager();
        Carro carro = null;
        try {
            carro = entityManager.createQuery("from Carro where codigo = :codigoCarro", Carro.class)
                    .setParameter("codigoCarro", codigoCarro)
                    .getSingleResult();
            return carro;
        } catch (NoResultException e){
            throw new NoResultException("Não encontrado nenhuma Carro com o código informado" + e.getMessage());
        } catch (Exception e){
            System.out.println("Não encontrado nenhuma Carro com o código informado" + e.getMessage());
        }
        return null;
    }


}
