package com.exemploMod33.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CursoControllerTest {
    CursoController cursoController = new CursoController();

    @Test
    public void cadastrarCurso(){
     cursoController.cadastrarCurso(
             "CURSO-02",
             "Curso de Java",
             "Curso de Java para iniciantes");
    }

    @Test
    public void listarTodosOsProdutosTest (){
        cursoController.listarTodosCurso();
        Assertions.assertNotNull(cursoController.listarTodosCurso());
    }

    @Test
    public void consultarCursoTest (){

    }


}
