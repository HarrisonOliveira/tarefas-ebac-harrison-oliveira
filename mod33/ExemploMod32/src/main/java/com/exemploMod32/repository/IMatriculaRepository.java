package com.exemploMod32.repository;

import com.exemploMod32.entity.Matricula;
import com.exemploMod32.entity.StatusMatricula;

public interface IMatriculaRepository {
    public Matricula cadastrarMatricula(Matricula matricula);
    public Matricula consultarMatricula(String codigoMatricula);
    public void atualizarStatusMatricula(String codigoMatricula, StatusMatricula statusMatricula);
    public void excluirMatricula(String codigoMatricula);
}
