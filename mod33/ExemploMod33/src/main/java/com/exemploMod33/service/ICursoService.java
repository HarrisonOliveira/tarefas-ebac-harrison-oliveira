package com.exemploMod33.service;

import com.exemploMod33.entity.Curso;

import java.util.List;

public interface ICursoService {
    public Curso cadastrarCurso(String codigoCurso, String nomeCurso, String descricaoCurso);
    public List<Curso> listarTodosCursos();
}
