package com.exemploMod33;

import com.exemploMod33.entity.Curso;
import com.exemploMod33.repository.CursoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CursoTest {

    @Test
    public void cadastrar(){
        CursoRepository cursoRepository = new CursoRepository();

        Curso curso = new Curso();
        curso.setCodigo("CURSO-01");
        curso.setNomeCurso("Curso Backend Java");
        curso.setDescricao("Curso Backend Java para iniciantes");

        cursoRepository.cadastrarCurso(curso);

        Assertions.assertNotNull(curso);
        Assertions.assertNotNull(curso.getId());
    }

    @Test
    public void listarTodosOsCursos(){
        CursoRepository cursoRepository = new CursoRepository();
        cursoRepository.listarTodosCursos().forEach(System.out::println);
    }

    @Test
    public void consultarCurso(){
        CursoRepository cursoRepository = new CursoRepository();
        System.out.println(cursoRepository.consultarCurso("COD-02"));
    }

    @Test
    public void atualizarCurso() {
        CursoRepository cursoRepository = new CursoRepository();
        Curso curso = cursoRepository.consultarCurso("COD-03");
        curso.setNomeCurso("Curso de Java 2");
        cursoRepository.atualizarCurso(curso);

        System.out.println(cursoRepository.consultarCurso("COD-03"));
    }

    @Test
    public void excluirCurso() {
        CursoRepository cursoRepository = new CursoRepository();
        cursoRepository.excluirCurso("COD-02");
    }

    @Test
    public void listaDeMatriculaPorCurso(){
        CursoRepository cursoRepository = new CursoRepository();
        cursoRepository.listarMatriculasPorCurso("CURSO-01").forEach(System.out::println);
    }
}
