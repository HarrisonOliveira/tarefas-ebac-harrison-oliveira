package com.exemploMod32.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "tb_matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matricula_seq")
    @SequenceGenerator(name = "matricula_seq", sequenceName = "seq_matricula", allocationSize = 1)
    private Long id;

    @Column(name = "codigo", nullable = false, unique = true, length = 10)
    private String codigo;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "data_matricula", nullable = false)
    private Instant dataMatricula;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusMatricula status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Instant getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Instant dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public StatusMatricula getStatus() {
        return status;
    }

    public void setStatus(StatusMatricula status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", valor=" + valor +
                ", dataMatricula=" + dataMatricula +
                ", status=" + status +
                '}';
    }
}
