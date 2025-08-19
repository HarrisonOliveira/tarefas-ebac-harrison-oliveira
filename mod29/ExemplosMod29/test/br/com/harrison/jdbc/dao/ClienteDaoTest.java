package br.com.harrison.jdbc.dao;

import br.com.harrison.cliente.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

public class ClienteDaoTest {

    @Test
    void cadastrarCliente() throws Exception {
        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = new Cliente();

        cliente.setCodigo("1003");
        cliente.setNome("Iracema");

        Integer contadorCadastro = clienteDao.cadastrarCliente(cliente);
        Assertions.assertTrue(contadorCadastro == 1);

    }

    @Test
    void atualizarCliente() throws Exception {
        ClienteDao clienteDao = new ClienteDao();

        clienteDao.consultarCliente("1001");

        Cliente novoCliente = new Cliente();
        novoCliente.setCodigo("1001");
        novoCliente.setNome("Harrison");
        clienteDao.atualizarCliente(novoCliente);

        clienteDao.consultarCliente("1002");

        Assertions.assertEquals("Harrison", novoCliente.getNome());

    }

    @Test
    void excluirCliente() throws SQLException {
        ClienteDao clienteDao = new ClienteDao();

        Cliente clienteConsultado = clienteDao.consultarCliente("1002");
        Assertions.assertNotNull(clienteConsultado);

        clienteDao.excluirCliente(clienteConsultado);
    }

    @Test
    void buscarTodosClientes() throws SQLException {
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> consultarCLiente = clienteDao.consultarTodosClientes();
        consultarCLiente.forEach(System.out::println);
    }

    @Test
    void consultarCliente() throws SQLException {

        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = new Cliente();

        cliente.setCodigo("1003");

        Cliente consultarCliente = clienteDao.consultarCliente("1003");
        Assertions.assertEquals(consultarCliente.getCodigo(), cliente.getCodigo());

    }
}
