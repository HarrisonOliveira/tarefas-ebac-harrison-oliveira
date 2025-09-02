package com.exemploMod32.service;

import com.exemploMod32.entity.Curso;

import java.awt.*;
import java.util.List;

public interface ICursoService {
    public Curso cadastrarCurso(String codigoCurso, String nomeCurso, String descricaoCurso);
    public List<Curso> listarTodosCursos();
}
