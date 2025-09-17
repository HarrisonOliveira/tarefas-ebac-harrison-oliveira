package com.vendas.dao;

import java.util.List;

import com.vendas.dao.generic.IGenericDAO;
import com.vendas.domain.Cliente;

public interface IClienteDAO extends IGenericDAO<Cliente, Long> {

	List<Cliente> filtrarClientes(String query);

}
