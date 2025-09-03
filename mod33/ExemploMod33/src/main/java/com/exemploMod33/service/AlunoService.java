package com.exemploMod33.service;

import com.exemploMod33.entity.Aluno;
import com.exemploMod33.repository.AlunoRepository;

public class AlunoService implements IAlunoService{
    AlunoRepository alunoRepository = new AlunoRepository();

    @Override
    public Aluno cadastrarAluno(String codigoAluno, String nomeAluno) {
        Aluno aluno = new Aluno();

        if (codigoAluno == null || nomeAluno == null)
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos");
        if (codigoAluno.isEmpty() || nomeAluno.isEmpty())
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos");

        aluno.setCodigo(codigoAluno);
        aluno.setNome(nomeAluno);
        return alunoRepository.cadastrarAluno(aluno);
    }

    @Override
    public Aluno consultarAlunoPorCodigo(String codigoAluno) {
        if (codigoAluno == null || codigoAluno.isEmpty())
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos");
        return alunoRepository.consultarAlunoPorCodigo(codigoAluno);
    }
}
