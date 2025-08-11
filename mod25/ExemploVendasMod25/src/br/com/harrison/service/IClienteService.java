package br.com.harrison.service;

import br.com.harrison.cliente.Cliente;

public interface IClienteService {
    void salvarCliente(Long cpf, Cliente cliente);

    Cliente consultarClienteCpf(Long cpf);
}
