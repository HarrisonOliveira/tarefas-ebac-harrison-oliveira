package com.atividadeMod33.service;

import com.atividadeMod33.entity.Acessorio;
import com.atividadeMod33.entity.Carro;
import com.atividadeMod33.entity.Marca;

public interface IAcessorioService {
    public void cadastrarAcessorio(String codigoAcessorio, String descricaoAcessorio, String codigoMarca, String codigoCarro);
    public Acessorio buscarAcessorioPeloCodigo(String codigoAcessorio);

}
