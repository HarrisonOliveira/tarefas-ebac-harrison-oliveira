package com.atividadeMod33.service;

import com.atividadeMod33.entity.Carro;
import com.atividadeMod33.entity.Marca;

public interface ICarroService {
    public void cadastrarCarro(String codigoCarro, String modelo, String codigoMarca);
    public Carro bucarCarroPeloCodigo(String codigoCarro);
}
