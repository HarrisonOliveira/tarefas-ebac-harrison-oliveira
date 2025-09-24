package com.exemploProjetoSpring.domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "TB_CLIENTE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_generator")
    @SequenceGenerator(name = "cliente_seq", sequenceName = "seq_cliente")
    private Long id;

    @Column(name = "nome_cliente", nullable = false)
    private String nome;

    @Column(name = "sobrenome_cliente", nullable = false)
    private String sobrenome;
}
