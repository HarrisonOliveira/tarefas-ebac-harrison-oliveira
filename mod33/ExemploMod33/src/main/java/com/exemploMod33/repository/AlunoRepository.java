package com.exemploMod33.repository;

import com.exemploMod33.connectionFactory.ConnectionFactory;
import com.exemploMod33.entity.Aluno;
import jakarta.persistence.EntityManager;

public class AlunoRepository implements IAlunoRepository{

    @Override
    public Aluno cadastrarAluno(Aluno aluno) {
        EntityManager entityManager = ConnectionFactory.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(aluno);
            entityManager.getTransaction().commit();
            return aluno;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Erro ao cadastrar aluno: " + e.getMessage());
        }
    }

    @Override
    public Aluno consultarAlunoPorCodigo(String codigoAluno) {
        Aluno aluno = null;
        EntityManager entityManager = ConnectionFactory.getEntityManager();

        try {
            aluno = entityManager.createQuery("from Aluno where codigo = :codigoAluno", Aluno.class)
                    .setParameter("codigoAluno", codigoAluno)
                    .getSingleResult();
            return aluno;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao consultar aluno: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }
}
