package com.atividademod40.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Entity
@Table(name = "tb_produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
    @SequenceGenerator(name = "produto_seq", sequenceName = "seq_produto")
    private int id;

    @Column(name = "nome_produto", nullable = false)
    private String nomeProduto;

    @Column(name = "preco_procudoto", nullable = false)
    private BigDecimal precoProduto;
}
