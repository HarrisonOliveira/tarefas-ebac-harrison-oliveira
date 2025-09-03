package com.atividadeMod33.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_acessorio")
public class Acessorio {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acessorio_seq")
    @SequenceGenerator(name = "acessorio_seq", sequenceName = "acessorio_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "codigo", nullable = false, length = 10)
    private String codigo;

    @Column(name = "descricao", nullable = false, length = 50)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "codigo_marca",
            foreignKey = @ForeignKey(name = "fk_acessorio_marca"),
            referencedColumnName = "codigo")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "codigo_carro",
            foreignKey = @ForeignKey(name = "fk_acessorio_carro"),
            referencedColumnName = "codigo")
    private Carro carros;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Carro getCarros() {
        return carros;
    }

    public void setCarros(Carro carros) {
        this.carros = carros;
    }
}
