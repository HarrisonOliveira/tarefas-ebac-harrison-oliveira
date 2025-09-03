package com.atividadeMod33;

import com.atividadeMod33.controller.AcessorioController;
import org.junit.jupiter.api.Test;

public class AcessorioControllerTest {
    AcessorioController acessorioController = new AcessorioController();

    @Test
    public void cadastrarAcessorio(){
        acessorioController.cadastrarAcessorio("A-01"
                , "Acessório para volante"
                , "M-01"
                ,"C-01"
                );
    }

    @Test
    public void buscarAcessorioPeloCodigo(){
        acessorioController.buscarAcessorioPeloCodigo("A-01");
    }
}
