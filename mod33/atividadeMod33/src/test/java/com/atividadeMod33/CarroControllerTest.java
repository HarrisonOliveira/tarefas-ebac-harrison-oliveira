package com.atividadeMod33;

import com.atividadeMod33.controller.CarroController;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;

public class CarroControllerTest {
    CarroController carroController = new CarroController();

    @Test
    public void cadastrarCarro(){
        carroController.cadastrarCarro("C-01", "SUV", "M-01");
    }

    @Test
    public void buscarCarroPeloCodigo(){
        carroController.bucarCarroPeloCodigo("C-01");
    }


}
