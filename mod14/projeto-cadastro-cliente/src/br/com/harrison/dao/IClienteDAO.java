package br.com.harrison.dao;

import br.com.harrison.domain.Cliente;

import java.util.Collection;
import java.util.Collections;

public interface IClienteDAO {
    public Boolean cadastrar(Cliente cliente);
    public void excluir(Long cpf);
    public void alterar(Cliente cliente);
    public Cliente consultar (Long cpf);
    public Collection<Cliente> consultarTodos();
}
