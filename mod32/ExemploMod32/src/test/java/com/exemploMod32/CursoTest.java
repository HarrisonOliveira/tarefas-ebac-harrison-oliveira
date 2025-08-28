package com.exemploMod32;

import com.exemploMod32.entity.Curso;
import com.exemploMod32.repository.CursoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CursoTest {

    @Test
    public void cadastrar(){
        CursoRepository cursoRepository = new CursoRepository();
        Curso curso = new Curso();
        curso.setCodigo("COD-06");
        curso.setNomeCurso("Curso de Java");
        curso.setDescricao("Curso de Java para iniciantes");

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

}
