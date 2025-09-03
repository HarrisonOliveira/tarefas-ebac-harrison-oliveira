package com.atividadeMod33;

import com.atividadeMod33.controller.MarcaController;
import com.atividadeMod33.entity.Marca;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MarcaControllerTest {
    MarcaController marcaController = new MarcaController();
    @Test
    public void cadastarMarca(){
        marcaController.cadastarMarca("M-01", "BMW");
    }

    @Test
    public void buscarMarcaPeloCodigo(){
        Marca marca = marcaController.buscarMarcaPeloCodigo("M-01");
        Assertions.assertNotNull(marca);
    }

}
