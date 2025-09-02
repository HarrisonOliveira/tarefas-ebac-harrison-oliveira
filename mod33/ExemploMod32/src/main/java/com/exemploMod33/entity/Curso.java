package com.exemploMod33.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_curso")
public class Curso {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_seq")
    @SequenceGenerator(name = "curso_seq", sequenceName = "seq_curso", allocationSize = 1)
    private Long Id;

    @Column(name = "codigo", nullable = false, unique = true, length = 10)
    private String codigo;

    @Column(name = "nome_curso", nullable = false, length = 100)
    private String NomeCurso;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "lista_matriculas")
    @OneToMany(mappedBy = "curso")
    private List<Matricula> listaMatriculas;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeCurso() {
        return NomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        NomeCurso = nomeCurso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Matricula> getListaMatriculas() {
        return listaMatriculas;
    }

    public void setListaMatriculas(List<Matricula> listaMatriculas) {
        this.listaMatriculas = listaMatriculas;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "Id=" + Id +
                ", codigo='" + codigo + '\'' +
                ", NomeCurso='" + NomeCurso + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
