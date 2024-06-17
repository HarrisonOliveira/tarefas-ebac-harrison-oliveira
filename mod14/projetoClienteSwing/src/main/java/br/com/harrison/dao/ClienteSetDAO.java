package br.com.harrison.dao;

import br.com.harrison.domain.Cliente;

import java.util.*;

public class ClienteSetDAO implements IClienteDAO{

    private Set<Cliente> set;

    public ClienteSetDAO(){
        this.set = new HashSet<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if(this.set.equals(cliente)) return false;
        return this.set.add(cliente);
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteEncontrado = null;
        for(Cliente cliente : this.set){
            if (cliente.getCpf().equals(cpf)){
                clienteEncontrado = cliente;
                break;
            }
        }

        if (clienteEncontrado != null){
            this.set.remove(clienteEncontrado);
        }

    }

    @Override
    public void alterar(Cliente cliente) {
        if (this.set.contains(cliente)) {
            for (Cliente clienteEscontrado : this.set){
                if (clienteEscontrado.equals(cliente)){
                    clienteEscontrado.setNome(cliente.getNome());
                    clienteEscontrado.setSobrenome(cliente.getSobrenome());
                    clienteEscontrado.setCpf(cliente.getCpf());
                    break;
                }
            }
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        for (Cliente clienteEncotrado : this.set){
            if  (clienteEncotrado.getCpf().equals(cpf)){
                return clienteEncotrado;
            }
        }
        return null;
    }

    @Override
    public Collection<Cliente> consultarTodos() {
        return this.set;
    }
}
