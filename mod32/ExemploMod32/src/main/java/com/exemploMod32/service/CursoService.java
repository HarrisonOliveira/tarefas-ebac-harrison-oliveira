package com.exemploMod32.service;


import com.exemploMod32.entity.Curso;
import com.exemploMod32.repository.CursoRepository;

import java.util.List;


public class CursoService implements ICursoService {
    CursoRepository cursoRepository = new CursoRepository();

    @Override
    public Curso cadastrarCurso(String codigoCurso, String nomeCurso, String descricaoCurso) {
        Curso curso = new Curso();

        if (codigoCurso == null || nomeCurso == null || descricaoCurso == null) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos");
        }
        if (codigoCurso.isEmpty() || nomeCurso.isEmpty() || descricaoCurso.isEmpty()) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos");
        }
        curso.setCodigo(codigoCurso);
        curso.setNomeCurso(nomeCurso);
        curso.setDescricao(descricaoCurso);
        return cursoRepository.cadastrarCurso(curso);
    }

    @Override
    public List<Curso> listarTodosCursos() {
        List<Curso> listarTodosCursos = cursoRepository.listarTodosCursos();
        if (listarTodosCursos == null){
            throw new IllegalArgumentException("Nenhum curso foi encontrado ou não há cursos cadastrodos. ");
        }
        listarTodosCursos.forEach(System.out::println);
        return listarTodosCursos;
    }
}
