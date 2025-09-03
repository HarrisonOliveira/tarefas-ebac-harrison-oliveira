package com.atividadeMod33.repository;

import com.atividadeMod33.connection.ConnectionFactory;
import com.atividadeMod33.entity.Marca;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import org.hibernate.HibernateException;

public class MarcaRepository implements IMarcaRepository{
    EntityManager entityManager = ConnectionFactory.getEntityManager();

    @Override
    public void cadastarMarca(Marca marca) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(marca);
            entityManager.getTransaction().commit();
        }catch (HibernateException e){
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            throw new HibernateException("[Repository]Não foi possivel cadastar a Marca. " + e.getMessage());
        }finally {
            entityManager.close();
        }
    }

    @Override
    public Marca buscarMarcaPeloCodigo(String codigoMarca) {
        Marca marca = null;
        try {
            marca = entityManager.createQuery("from Marca where codigo = :codigoMarca", Marca.class)
                    .setParameter("codigoMarca", codigoMarca)
                    .getSingleResult();
            return marca;
        }catch (HibernateException | NoResultException e ){
            throw new PersistenceException("[Repository] - Não foi possível encontrar a Marca com código informado."
            + e.getMessage());
        } finally {
            entityManager.close();
        }
    }
}
