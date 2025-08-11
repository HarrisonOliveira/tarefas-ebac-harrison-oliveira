package br.com.harrison.Dao;

import br.com.harrison.cliente.Cliente;

public interface IClienteDao {
     void salvarNovoCliente(Long cpf, Cliente cliente);
     Cliente consultarCliente(Long cpf);
}
