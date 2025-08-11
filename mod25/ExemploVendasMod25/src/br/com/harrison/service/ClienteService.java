package br.com.harrison.service;

import br.com.harrison.Dao.ClienteDao;
import br.com.harrison.Dao.IClienteDao;
import br.com.harrison.cliente.Cliente;

public class ClienteService implements IClienteService{

    IClienteDao clienteDao;

    public ClienteService (IClienteDao clienteDao){
        this.clienteDao = clienteDao;
    }

    @Override
    public void salvarCliente(Long cpf, Cliente cliente) {
        clienteDao.salvarNovoCliente(cpf, cliente);
    }

    @Override
    public Cliente consultarClienteCpf(Long cpf) {
           return clienteDao.consultarCliente(cpf);
    }
}
