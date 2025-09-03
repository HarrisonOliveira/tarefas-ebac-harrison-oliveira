package com.atividadeMod33.service;

import com.atividadeMod33.connection.ConnectionFactory;
import com.atividadeMod33.entity.Carro;
import com.atividadeMod33.entity.Marca;
import com.atividadeMod33.repository.CarroRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Table;

import java.security.Provider;

public class CarroService implements ICarroService{
    CarroRepository carroRepository = new CarroRepository();
    MarcaService marcaService = new MarcaService();

    @Override
    public void cadastrarCarro(String codigoCarro, String modelo, String codigoMarca) {
        if(codigoCarro == null || modelo == null || codigoMarca == null){
            throw new RuntimeException("[Service] - Não foi possível cadastrar o carro");
        }
        if (codigoCarro.isEmpty() || modelo.isEmpty() || codigoMarca.isEmpty()){
            throw new UnsupportedOperationException("[Service] - Todos os campos devem ser preenchidos.");
        }

        Marca marca = marcaService.buscarMarcaPeloCodigo(codigoMarca);
        Carro carro = new Carro();
        carro.setCodigo(codigoCarro);
        carro.setModelo(modelo);
        carro.setMarca(marca);
        carroRepository.cadastrarCarro(carro);
    }

    @Override
    public Carro bucarCarroPeloCodigo(String codigoCarro) {
        if (codigoCarro == null || codigoCarro.isEmpty()){
            throw new RuntimeException("[Service] - Não foi possível encontrar o carro com o código informado");
        }

        Carro carro = carroRepository.buscarCarroPeloCodigo(codigoCarro);
        System.out.println("Codigo do carro: " + carro.getCodigo()
                + " Modelo do carro: " + carro.getModelo()
        );
        return carro;
    }
}
