package br.com.harrison.Dao;

import br.com.harrison.cliente.Cliente;

import java.util.function.Consumer;

public interface IClienteDao {
     void salvarNovoCliente(Long cpf, Cliente cliente);
     Cliente consultarCliente(Long cpf);
     void alterarNomeCliente(Long id, Consumer<Cliente> atualizador);
}
