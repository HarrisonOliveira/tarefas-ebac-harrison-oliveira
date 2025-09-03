package com.atividadeMod33.service;

import com.atividadeMod33.entity.Marca;

public interface IMarcaService {
    public void cadastarMarca(String codigoMarca, String nomeMarca);
    public Marca buscarMarcaPeloCodigo(String codigoMarca);
}
