package com.exemploMod33.controller;

import com.exemploMod33.entity.Aluno;
import com.exemploMod33.service.AlunoService;

public class AlunoController {
    AlunoService alunoService = new AlunoService();

    public Aluno cadastrarAluno(String codigoAluno, String nomeAluno){
        Aluno aluno = null;
        try {
            aluno = alunoService.cadastrarAluno(codigoAluno, nomeAluno);
            return aluno;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar aluno: " + e.getMessage());
        }
    }

    public Aluno consultarAlunoPorCodigo(String codigoAluno){
        Aluno aluno = null;
        try {
            aluno = alunoService.consultarAlunoPorCodigo(codigoAluno);
            return aluno;
        }catch (Exception e) {
            throw new RuntimeException("Erro ao consultar aluno por codigo: " + e.getMessage());
        }
    }

}
