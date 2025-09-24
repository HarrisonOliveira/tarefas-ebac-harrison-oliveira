package com.atividademod40.atividademod40;

import com.atividademod40.entity.Produto;
import com.atividademod40.repository.IProdutoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "com.atividademod40.repository")
@EntityScan(basePackages = "com.atividademod40.*")
@ComponentScan(basePackages = "com.atividademod40")
public class AtividadeMod40Application implements CommandLineRunner {

    @Autowired
    IProdutoRepository produtoRepository;
    private static final Logger log = LoggerFactory.getLogger(AtividadeMod40Application.class);

    public static void main(String[] args) {
        SpringApplication.run(AtividadeMod40Application.class, args);
    }

    @Override
    public void run(String... args){
        Produto produto = produtoCriado();

        log.info("Iniciando produto");
        produtoRepository.save(produto);
        log.info("Produto salvo com sucesso");
    }

    private Produto produtoCriado(){
        return Produto.builder()
                .nomeProduto("Laranja")
                .precoProduto(new BigDecimal("5.99"))
                .build();
    }

}
