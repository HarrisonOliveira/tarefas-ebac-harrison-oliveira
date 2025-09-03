package com.atividadeMod33.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_carro")
public class Carro {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro_seq")
    @SequenceGenerator(name = "carro_seq", sequenceName = "carro_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "codigo", nullable = false, length = 50, unique = true)
    private String codigo;

    @Column(name = "modelo", nullable = false, length = 50, unique = true)
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "codigo_marca",
            foreignKey = @ForeignKey(name = "fk_carro_marca"),
            referencedColumnName = "codigo")
    private Marca marca;

    @OneToMany(mappedBy = "codigo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Acessorio> acessorios;


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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca=" + marca +
                ", acessorio=" + acessorios +
                '}';
    }
}

