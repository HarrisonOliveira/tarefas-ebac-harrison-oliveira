package com.vendas.service;

import java.util.List;

import javax.inject.Inject;

import com.vendas.dao.IClienteDAO;
import com.vendas.domain.Cliente;
import com.vendas.exceptions.DAOException;
import com.vendas.exceptions.MaisDeUmRegistroException;
import com.vendas.exceptions.TableException;
import com.vendas.service.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

	private IClienteDAO clienteDAO;

	@Inject
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
		this.clienteDAO = clienteDAO;
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Cliente> filtrarClientes(String query) {
		return clienteDAO.filtrarClientes(query);
	}

}
