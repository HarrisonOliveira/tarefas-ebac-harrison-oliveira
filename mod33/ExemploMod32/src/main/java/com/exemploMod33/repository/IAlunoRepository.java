package com.exemploMod33.repository;

import com.exemploMod33.entity.Aluno;

public interface IAlunoRepository {
    public Aluno cadastrarAluno(Aluno aluno);
    public Aluno consultarAlunoPorCodigo(String codigoAluno);
}
