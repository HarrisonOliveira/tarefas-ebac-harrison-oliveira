package br.com.harrison.Dao;

import br.com.harrison.cliente.Cliente;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ClienteDao implements IClienteDao{

    Map<Long, Cliente> clientes = new HashMap<>(){{
        put(12345678901L, new Cliente("Paulo", 12345678901L, 999999991L, "Rua Acre", 7, "Acre", "Acre" ));
        put(12345678902L, new Cliente("Maria", 12345678902L, 999999992L, "Rua Acre", 8, "Acre", "Acre" ));
        put(12345678903L, new Cliente("Pedro", 12345678903L, 999999993L, "Rua Acre", 9, "Acre", "Acre" ));
    }};

    @Override
    public void salvarNovoCliente(Long cpf, Cliente cliente) {
        clientes.put(cpf, cliente);
    }

    @Override
    public Cliente consultarCliente(Long cpf) {
        return clientes.get(cpf);
    }

    public void alterarNomeCliente(Long id, Consumer<Cliente> atualizador) {
            clientes.computeIfPresent(id, (chave, cliente) -> {
                atualizador.accept(cliente);
                return cliente;
            });
    }
}
