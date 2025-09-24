package com.exemploProjetoSpring.SpringBootPrimeiroExemplo;

import com.exemploProjetoSpring.domain.Cliente;
import com.exemploProjetoSpring.repository.IClienteRepository;
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

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "com.exemploProjetoSpring.repository")
@EntityScan(basePackages = "com.exemploProjetoSpring.*")
@ComponentScan(basePackages = "com.exemploProjetoSpring")
public class SpringBootPrimeiroExemploApplication implements CommandLineRunner {

    @Autowired
    IClienteRepository clienteRepository;

    private static final Logger log = LoggerFactory.getLogger(SpringBootPrimeiroExemploApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPrimeiroExemploApplication.class, args);
	}

    @Override
    public void run(String... args) {
        Cliente cliente = criarCliente();
        log.info("Inicializando criação de um novo Cliente");
        clienteRepository.save(cliente);
        log.info("Cliente criado com sucesso: {}", cliente);
    }

    private Cliente criarCliente() {
        return Cliente.builder()
                .nome("Harrison")
                .sobrenome("Oliveira")
                .build();
    }


}
