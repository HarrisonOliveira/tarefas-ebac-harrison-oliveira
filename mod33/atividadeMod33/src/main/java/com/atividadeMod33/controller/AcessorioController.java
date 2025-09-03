package com.atividadeMod33.controller;

import com.atividadeMod33.entity.Acessorio;
import com.atividadeMod33.repository.AcessorioRepository;
import com.atividadeMod33.service.AcessorioService;

public class AcessorioController {
    AcessorioService acessorioService = new AcessorioService();

    public void cadastrarAcessorio(String codigoAcessorio, String descricaoAcessorio, String codigoMarca,String codigoCarro){
        acessorioService.cadastrarAcessorio(codigoAcessorio, descricaoAcessorio, codigoMarca, codigoCarro);
    }

    public Acessorio buscarAcessorioPeloCodigo(String codigoAcessorio){
        return acessorioService.buscarAcessorioPeloCodigo(codigoAcessorio);
    }

}
