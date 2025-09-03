package com.atividadeMod33.controller;

import com.atividadeMod33.entity.Carro;
import com.atividadeMod33.service.CarroService;

public class CarroController {
    CarroService carroService = new CarroService();

    public void cadastrarCarro(String codigoCarro, String modelo, String codigoMarca){
        carroService.cadastrarCarro(codigoCarro, modelo, codigoMarca);
    }

    public Carro bucarCarroPeloCodigo(String codigoCarro){
        return carroService.bucarCarroPeloCodigo(codigoCarro);
    }

}
