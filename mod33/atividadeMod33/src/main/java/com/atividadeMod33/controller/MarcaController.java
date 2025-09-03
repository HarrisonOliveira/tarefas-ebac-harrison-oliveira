package com.atividadeMod33.controller;

import com.atividadeMod33.entity.Marca;
import com.atividadeMod33.service.MarcaService;

public class MarcaController {
    MarcaService marcaService = new MarcaService();

    public void cadastarMarca(String codigoMarca, String nomeMarca){
        marcaService.cadastarMarca(codigoMarca, nomeMarca);
    }

    public Marca buscarMarcaPeloCodigo(String codigoMarca){
        return marcaService.buscarMarcaPeloCodigo(codigoMarca);
    }
}
