/**
 * 
 */
package br.com.rpires;

import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.rpires.dao.ClienteDAO;
import br.com.rpires.dao.IClienteDAO;
import br.com.rpires.domain.Cliente;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.MaisDeUmRegistroException;
import br.com.rpires.exceptions.TableException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

import static org.junit.Assert.*;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteDAOTest {
	private IClienteDAO clienteDao;
	public ClienteDAOTest() {
		clienteDao = new ClienteDAO();
	}
	
	@After
	public void end() throws DAOException {
		Collection<Cliente> list = clienteDao.buscarTodos();
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli.getCpf());
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	@Test
	public void pesquisarCliente() throws MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Harrison");
        cliente.setSobrenome("Oliveira");
		cliente.setCidade("Acre");
		cliente.setEnd("End");
		cliente.setEstado("AC");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		clienteDao.cadastrar(cliente);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente.getCpf());
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Harrison");
        cliente.setSobrenome("Oliveira");
        cliente.setCidade("Acre");
        cliente.setEnd("End");
        cliente.setEstado("AC");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente.getCpf());
	}

	@Test
	public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Harrison");
        cliente.setSobrenome("Oliveira");
        cliente.setCidade("Acre");
        cliente.setEnd("End");
        cliente.setEstado("AC");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente.getCpf());
		clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNull(clienteConsultado);
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Harrison");
        cliente.setSobrenome("Oliveira");
        cliente.setCidade("Acre");
        cliente.setEnd("End");
        cliente.setEstado("AC");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
		
		clienteConsultado.setNome("Rodrigo Pires");
		clienteDao.alterar(clienteConsultado);
		
		Cliente clienteAlterado = clienteDao.consultar(clienteConsultado.getCpf());
		Assert.assertNotNull(clienteAlterado);
		Assert.assertEquals("Rodrigo Pires", clienteAlterado.getNome());
		
		clienteDao.excluir(cliente.getCpf());
		clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNull(clienteConsultado);
	}
	
	@Test
	public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
		Cliente cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Harrison");
        cliente.setSobrenome("Oliveira");
        cliente.setCidade("Acre");
        cliente.setEnd("End");
        cliente.setEstado("AC");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);
		
		Cliente cliente1 = new Cliente();
        cliente.setCpf(12312312399L);
        cliente.setNome("Joao");
        cliente.setSobrenome("Silva");
        cliente.setCidade("Acre");
        cliente.setEnd("End");
        cliente.setEstado("AC");
        cliente.setNumero(10);
        cliente.setTel(1199999998L);
		Boolean retorno1 = clienteDao.cadastrar(cliente1);
		Assert.assertTrue(retorno1);
		
		Collection<Cliente> list = clienteDao.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());
		
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli.getCpf());
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Collection<Cliente> list1 = clienteDao.buscarTodos();
        assertNotNull(list1);
        assertEquals(0, list1.size());
	}
}
