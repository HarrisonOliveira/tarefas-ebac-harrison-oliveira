package com.atividadeMod33.repository;

import com.atividadeMod33.entity.Carro;

public interface ICarroRepository {
    public void cadastrarCarro(Carro carro);
    public Carro buscarCarroPeloCodigo(String codigoCarro);
}
