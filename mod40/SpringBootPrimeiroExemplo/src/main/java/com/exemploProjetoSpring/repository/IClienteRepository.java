package com.exemploProjetoSpring.repository;

import com.exemploProjetoSpring.domain.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Integer> {

}
