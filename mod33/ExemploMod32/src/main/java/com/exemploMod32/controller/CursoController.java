package com.exemploMod32.controller;

import com.exemploMod32.entity.Curso;
import com.exemploMod32.service.CursoService;
import com.exemploMod32.service.ICursoService;

import java.util.List;

public class CursoController {
    private final ICursoService cursoService = new CursoService();

    public Curso cadastrarCurso(String codigoCurso, String nomeCurso, String descricaoCurso){
        Curso curso = null;
        try {
            curso = cursoService.cadastrarCurso(codigoCurso, nomeCurso, descricaoCurso);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar curso: " + e.getMessage());
        }
        return curso;
    }

    public List<Curso> listarTodosCurso(){
        List<Curso> result = null;
        try {
            result = cursoService.listarTodosCursos();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar todos os cursos: " + e.getMessage());
        }
        return result;
    }
}
