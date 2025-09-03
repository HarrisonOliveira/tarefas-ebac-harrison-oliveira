package com.exemploMod33.repository;

import com.exemploMod33.entity.Curso;
import com.exemploMod33.entity.Matricula;

import java.util.List;

public interface ICursoRepository {

    public Curso cadastrarCurso(Curso curso);
    public List<Curso> listarTodosCursos();
    public Curso consultarCurso(String codigoCurso);
    public void atualizarCurso(Curso curso);
    public void excluirCurso(String codigoCurso);
    public List<Matricula> listarMatriculasPorCurso(String codigoCurso);
}
