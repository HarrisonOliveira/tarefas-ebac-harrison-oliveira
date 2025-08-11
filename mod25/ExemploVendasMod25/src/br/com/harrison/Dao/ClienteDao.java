package br.com.harrison.Dao;

import br.com.harrison.cliente.Cliente;

import java.util.HashMap;
import java.util.Map;

public class ClienteDao implements IClienteDao{

    Cliente cliente;

    Map<Long, Cliente> clientes = new HashMap<>();

    @Override
    public void salvarNovoCliente(Long cpf, Cliente cliente) {
        clientes.put(cpf, cliente);
    }

    @Override
    public Cliente consultarCliente(Long cpf) {
        return clientes.get(cpf);
    }
}
