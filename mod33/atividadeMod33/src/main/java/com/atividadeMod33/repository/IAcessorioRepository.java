package com.atividadeMod33.repository;

import com.atividadeMod33.entity.Acessorio;

public interface IAcessorioRepository {
    public void cadastrarAcessorio(Acessorio acessorio);
    public Acessorio buscarAcessorioPeloCodigo(String codigoAcessorio);
}
