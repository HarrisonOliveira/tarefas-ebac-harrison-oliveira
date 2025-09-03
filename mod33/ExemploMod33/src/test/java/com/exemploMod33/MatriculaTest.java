package com.exemploMod33;

import com.exemploMod33.controller.AlunoController;
import com.exemploMod33.entity.Aluno;
import com.exemploMod33.entity.Matricula;
import com.exemploMod33.enums.StatusMatricula;
import com.exemploMod33.repository.AlunoRepository;
import com.exemploMod33.repository.CursoRepository;
import com.exemploMod33.repository.IMatriculaRepository;
import com.exemploMod33.repository.MatriculaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;

public class MatriculaTest {

    @Test
    public void cadastrarMatricula(){
        IMatriculaRepository matriculaRepository = new MatriculaRepository();
        AlunoController alunoController = new AlunoController();
        CursoRepository cursoRepository = new CursoRepository();

        Aluno aluno = alunoController.consultarAlunoPorCodigo("A-01");

        Matricula matricula = new Matricula();
        matricula.setCodigo("M-01");
        matricula.setDataMatricula(Instant.now());
        matricula.setValor(new BigDecimal("200.00"));
        matricula.setStatus(StatusMatricula.ATIVA);
        matricula.setCurso(cursoRepository.consultarCurso("CURSO-02"));
        matricula.setAluno(aluno);
        aluno.setMatricula(matricula);

        matriculaRepository.cadastrarMatricula(matricula);

        Assertions.assertNotNull(matricula);
        Assertions.assertNotNull(matricula.getId());
    }

    @Test
    public void consultarMatricula(){
        IMatriculaRepository matriculaRepository = new MatriculaRepository();
        Matricula matricula = matriculaRepository.consultarMatricula("COD-01");

        Assertions.assertNotNull(matricula);

        System.out.println(matricula);
    }

    @Test
    public void atualizarMatricula(){
        IMatriculaRepository matriculaRepository = new MatriculaRepository();
        Matricula matricula = matriculaRepository.consultarMatricula("COD-04");

        matricula.setStatus(StatusMatricula.CANCELADA);

        matriculaRepository.atualizarStatusMatricula(matricula.getCodigo(), matricula.getStatus());
        Matricula matriculaAtualizada = matriculaRepository.consultarMatricula("COD-03");
        Assertions.assertNotNull(matricula);

        System.out.println(matriculaAtualizada);
    }


    @Test
    public void excluirMatricula(){
        MatriculaRepository matriculaRepository = new MatriculaRepository();
        matriculaRepository.excluirMatricula("COD-05");
    }
}
