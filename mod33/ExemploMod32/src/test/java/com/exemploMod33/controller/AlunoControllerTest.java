package com.exemploMod33.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlunoControllerTest {
    AlunoController alunoController = new AlunoController();

    @Test
    public void cadastrarAluno(){
        alunoController.cadastrarAluno("A-02", "Aluno 02");
    }

    @Test
    public void consultarAlunoPorCodigo(){
        alunoController.consultarAlunoPorCodigo("A-01");
        Assertions.assertNotNull(alunoController.consultarAlunoPorCodigo("A-01"));
    }


}
