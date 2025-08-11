package br.com.harrison;

import br.com.harrison.Dao.ClienteDao;
import br.com.harrison.cliente.Cliente;
import br.com.harrison.service.ClienteService;
import br.com.harrison.service.IClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    private IClienteService clienteService;

    public ClienteTest(){
        clienteService = new ClienteService(new ClienteDao());
    }
    @Test
    public void pesquisarCliente () {

        Long cpf = 12345678902L;
        Cliente cliente = new Cliente("Harrison",
                12345678904L,
                999999999L,
                "Rua Acre",
                10,
                "Acre",
                "Acre");

        clienteService.salvarCliente(12345678904L ,cliente);
        Cliente clienteConsultado = clienteService.consultarClienteCpf(cpf);
        Assertions.assertNotEquals(cliente, clienteConsultado);

        clienteService.alterarNomeCliente(cpf, "João");
        Assertions.assertNotEquals(cliente, clienteService.consultarClienteCpf(cpf));
    }


}
