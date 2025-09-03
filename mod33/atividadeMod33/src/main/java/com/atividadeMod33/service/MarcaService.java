package com.atividadeMod33.service;

import com.atividadeMod33.entity.Marca;
import com.atividadeMod33.repository.MarcaRepository;

public class MarcaService implements IMarcaService{
    MarcaRepository marcaRepository = new MarcaRepository();

    @Override
    public void cadastarMarca(String codigoMarca, String nomeMarca) {
        if (codigoMarca == null || nomeMarca == null || codigoMarca.isEmpty() || nomeMarca.isEmpty()){
            throw new RuntimeException("[Service] - Os campos não podem ser nulos ou vazios");
        }

        Marca marca = new Marca();
        marca.setCodigo(codigoMarca);
        marca.setNome(nomeMarca);
        marcaRepository.cadastarMarca(marca);
    }

    @Override
    public Marca buscarMarcaPeloCodigo(String codigoMarca) {
        if (codigoMarca == null || codigoMarca.isEmpty()){
            throw new RuntimeException("[Service] - Os campos não podem ser nulos ou vazios");
        }
        Marca marca = marcaRepository.buscarMarcaPeloCodigo(codigoMarca);

        System.out.println("Código da Marca: " + marca.getCodigo());
        System.out.println("Nome da Marca: " + marca.getNome());
        return marca;
    }
}
