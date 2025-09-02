package com.exemploMod33.repository;

import com.exemploMod33.entity.Matricula;
import com.exemploMod33.enums.StatusMatricula;

public interface IMatriculaRepository {
    public Matricula cadastrarMatricula(Matricula matricula);
    public Matricula consultarMatricula(String codigoMatricula);
    public void atualizarStatusMatricula(String codigoMatricula, StatusMatricula statusMatricula);
    public void excluirMatricula(String codigoMatricula);
}
