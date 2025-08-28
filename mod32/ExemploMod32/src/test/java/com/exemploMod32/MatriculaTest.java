package com.exemploMod32;

import com.exemploMod32.entity.Matricula;
import com.exemploMod32.entity.StatusMatricula;
import com.exemploMod32.repository.IMatriculaRepository;
import com.exemploMod32.repository.MatriculaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;

public class MatriculaTest {

    @Test
    public void cadastrarMatricula(){
        IMatriculaRepository matriculaRepository = new MatriculaRepository();
        Matricula matricula = new Matricula();

        matricula.setCodigo("COD-06");
        matricula.setDataMatricula(Instant.now());
        matricula.setValor(new BigDecimal("100.00"));
        matricula.setStatus(StatusMatricula.ATIVA);

        matriculaRepository.cadastrarMatricula(matricula);

        Assertions.assertNotNull(matricula);
        Assertions.assertNotNull(matricula.getId());

        System.out.println(matricula);
    }

    @Test
    public void consultarMatricula(){
        IMatriculaRepository matriculaRepository = new MatriculaRepository();
        Matricula matricula = matriculaRepository.consultarMatricula("COD-02");

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
