package com.exemploMod32.repository;

import com.exemploMod32.connectionFactory.ConnectionFactory;
import com.exemploMod32.entity.Curso;
import com.exemploMod32.entity.Matricula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

import java.util.List;

import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class CursoRepository implements ICursoRepository {

    @Override
    public Curso cadastrarCurso(Curso curso) {
        EntityManager entityManager = ConnectionFactory.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(curso);
            entityManager.getTransaction().commit();
            return curso;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Erro ao cadastrar curso: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Curso> listarTodosCursos() {
        List<Curso> listaCursos = null;
        EntityManager entityManager = ConnectionFactory.getEntityManager();

        listaCursos = entityManager.createQuery("from Curso", Curso.class).getResultList();
        return listaCursos;
    }

    @Override
    public Curso consultarCurso(String codigoCurso) {
        Curso curso = null;
        EntityManager entityManager = ConnectionFactory.getEntityManager();
        try {
            curso = entityManager.createQuery("from Curso where codigo = :codigo", Curso.class)
                    .setParameter("codigo", codigoCurso)
                    .getSingleResult();
            return curso;
        } catch (NoResultException e) {
            System.out.println("Nenhum curso encontrado com o código: " + codigoCurso);
        } catch (Exception e) {
            System.out.println("Erro ao consultar curso: " + e.getMessage());
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public void atualizarCurso(Curso curso) {
        EntityManager entityManager = ConnectionFactory.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(curso);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void excluirCurso(String codigoCurso) {
        EntityManager entityManager = ConnectionFactory.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Curso where codigo = :codigoCurso").
                setParameter("codigoCurso", codigoCurso).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Matricula> listarMatriculasPorCurso(String codigoCurso) {
        List<Matricula> listaMatriculas = null;

        try (EntityManager entityManager = ConnectionFactory.getEntityManager()) {
            listaMatriculas = entityManager.createQuery(
                    "from Matricula where curso.codigo = :codigoCurso", Matricula.class)
                    .setParameter("codigoCurso", codigoCurso)
                    .getResultList();
            return listaMatriculas;
        } catch (NoResultException e) {
            System.out.println("Nenhuma matricula encontrada para o curso: " + codigoCurso);
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao listar matriculas por curso: " + e.getMessage());
            return null;
        }
    }


}
