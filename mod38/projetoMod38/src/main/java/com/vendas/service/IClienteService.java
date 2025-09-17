package com.vendas.service;

import java.util.List;

import com.vendas.domain.Cliente;
import com.vendas.exceptions.DAOException;
import com.vendas.service.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;

	List<Cliente> filtrarClientes(String query);

}
