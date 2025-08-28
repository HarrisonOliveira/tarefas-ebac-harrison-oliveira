package com.exemploMod32.repository;

import com.exemploMod32.entity.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class CursoRepository implements ICursoRepository {


    @Override
    public Curso cadastrarCurso(Curso curso) {
        EntityManagerFactory entityManagerFactory = createEntityManagerFactory("meuPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {

            entityManager.getTransaction().begin();
            entityManager.persist(curso);
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();

            return curso;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar curso: " + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return null;
    }

    @Override
    public List<Curso> listarTodosCursos() {
        List<Curso> listaCursos = null;
        EntityManagerFactory entityManagerFactory = createEntityManagerFactory("meuPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        listaCursos = entityManager.createQuery("from Curso", Curso.class).getResultList();

        return listaCursos;

    }

    @Override
    public Curso consultarCurso(String codigoCurso) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("meuPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {

            Curso curso = entityManager.createQuery("from Curso where codigo = :codigo", Curso.class)
                    .setParameter("codigo", codigoCurso)
                    .getSingleResult();

            return curso;
        } catch (jakarta.persistence.NoResultException e) {
            System.out.println("Nenhum curso encontrado com o código: " + codigoCurso);
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao consultar curso: " + e.getMessage());
            return null;
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }

    @Override
    public void atualizarCurso(Curso curso) {
        EntityManagerFactory entityManagerFactory = createEntityManagerFactory("meuPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(curso);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }

    @Override
    public void excluirCurso(String codigoCurso) {
        EntityManagerFactory entityManagerFactory = createEntityManagerFactory("meuPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Curso where codigo = :codigoCurso").
                setParameter("codigoCurso", codigoCurso).executeUpdate();
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
