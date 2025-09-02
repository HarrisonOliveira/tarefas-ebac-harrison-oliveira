package com.exemploMod32.repository;

import com.exemploMod32.entity.Matricula;
import com.exemploMod32.entity.StatusMatricula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class MatriculaRepository implements IMatriculaRepository{
    @Override
    public Matricula cadastrarMatricula(Matricula matricula) {
        EntityManagerFactory entityManagerFactory = createEntityManagerFactory("meuPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(matricula);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return matricula;
    }

    @Override
    public Matricula consultarMatricula(String codigoMatricula) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("meuPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("from Matricula where codigo = :codigoMatricula", Matricula.class)
                .setParameter("codigoMatricula", codigoMatricula)
                .getSingleResult();


    }

    @Override
    public void atualizarStatusMatricula(String codigoMatricula, StatusMatricula statusMatricula) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("meuPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.createQuery("update Matricula m set m.status = :statusMatricula where m.codigo = :codigoMatricula")
                .setParameter("codigoMatricula", codigoMatricula)
                .setParameter("statusMatricula", statusMatricula)
                .executeUpdate();
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void excluirMatricula(String codigoMatricula) {
        EntityManagerFactory entityManagerFactory = createEntityManagerFactory("meuPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Matricula where codigo = :codigoMatricula")
                .setParameter("codigoMatricula", codigoMatricula)
                .executeUpdate();
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
