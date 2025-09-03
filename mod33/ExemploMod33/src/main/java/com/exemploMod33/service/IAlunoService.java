package com.exemploMod33.service;

import com.exemploMod33.entity.Aluno;
import com.exemploMod33.entity.Matricula;

public interface IAlunoService {
    public Aluno cadastrarAluno(String codigoAluno, String nomeAluno);
    public Aluno consultarAlunoPorCodigo(String codigoAluno);
}
