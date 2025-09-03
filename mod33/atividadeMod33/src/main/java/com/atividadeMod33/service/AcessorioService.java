package com.atividadeMod33.service;

import com.atividadeMod33.entity.Acessorio;
import com.atividadeMod33.entity.Carro;
import com.atividadeMod33.entity.Marca;
import com.atividadeMod33.repository.AcessorioRepository;

public class AcessorioService implements IAcessorioService{

    AcessorioRepository acessorioRepository = new AcessorioRepository();
    MarcaService marcaService = new MarcaService();
    CarroService carroService = new CarroService();

    @Override
    public void cadastrarAcessorio(String codigoAcessorio, String descricaoAcessorio, String codigoMarca, String codigoCarro) {
        if (codigoAcessorio == null || descricaoAcessorio == null || codigoMarca == null || codigoCarro == null){
            throw new RuntimeException("Os campos não podem ser nulos");
        }
        if (codigoAcessorio.isEmpty() || descricaoAcessorio.isEmpty() || codigoMarca.isEmpty() || codigoCarro.isEmpty()){
            throw new RuntimeException("Todos os campos precisam ser preenchidos.");
        }

        Marca marca = marcaService.buscarMarcaPeloCodigo(codigoMarca);
        Carro carro = carroService.bucarCarroPeloCodigo(codigoCarro);
        Acessorio acessorio = new Acessorio();
        acessorio.setCodigo(codigoAcessorio);
        acessorio.setDescricao(descricaoAcessorio);
        acessorio.setMarca(marca);
        acessorio.setCarros(carro);

        acessorioRepository.cadastrarAcessorio(acessorio);
    }

    @Override
    public Acessorio buscarAcessorioPeloCodigo(String codigoAcessorio) {
        if (codigoAcessorio == null || codigoAcessorio.isEmpty()){
            throw new RuntimeException("[Service] - Nenhum Acessório foi encontrado com o código informado.");
        }
        return acessorioRepository.buscarAcessorioPeloCodigo(codigoAcessorio);
    }


}
