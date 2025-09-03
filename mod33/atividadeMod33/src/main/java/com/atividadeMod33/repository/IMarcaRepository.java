package com.atividadeMod33.repository;

import com.atividadeMod33.entity.Marca;

public interface IMarcaRepository {
    public void cadastarMarca(Marca marca);
    public Marca buscarMarcaPeloCodigo(String codigoMarca);
}
