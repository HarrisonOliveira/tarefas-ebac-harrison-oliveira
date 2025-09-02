package com.exemploMod32.repository;

import com.exemploMod32.entity.Curso;
import com.exemploMod32.entity.Matricula;

import java.util.List;

public interface ICursoRepository {

    public Curso cadastrarCurso(Curso curso);
    public List<Curso> listarTodosCursos();
    public Curso consultarCurso(String codigoCurso);
    public void atualizarCurso(Curso curso);
    public void excluirCurso(String codigoCurso);
    public List<Matricula> listarMatriculasPorCurso(String codigoCurso);
}
