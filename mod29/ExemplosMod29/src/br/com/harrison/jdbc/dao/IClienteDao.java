package br.com.harrison.jdbc.dao;

import br.com.harrison.cliente.Cliente;

import java.util.List;

public interface IClienteDao {
    public Integer cadastrarCliente(Cliente cliente) throws Exception;
    public Integer atualizarCliente(Cliente cliente) throws Exception;
    public Cliente consultarCliente(String codigo) throws Exception;
    public List<Cliente> consultarTodosClientes() throws Exception;
    public Integer excluirCliente(Cliente cliente) throws Exception;

}
