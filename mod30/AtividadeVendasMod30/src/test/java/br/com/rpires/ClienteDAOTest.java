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
    public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
        Cliente cliente = new Cliente();
        cliente.setCpf(12312312398L);
        cliente.setNome("Harrison");
        cliente.setSobrenome("Oliveira");
        cliente.setCidade("Acre");
        cliente.setEnd("End");
        cliente.setEstado("AC");
        cliente.setNumero(10);
        cliente.setTel(1199999998L);
        Boolean retorno = clienteDao.cadastrar(cliente);
        Assert.assertTrue(retorno);

        Cliente cliente1 = new Cliente();
        cliente1.setCpf(12312312399L);
        cliente1.setNome("Joao");
        cliente1.setSobrenome("Silva");
        cliente1.setCidade("Acre");
        cliente1.setEnd("End");
        cliente1.setEstado("AC");
        cliente1.setNumero(10);
        cliente1.setTel(1199999998L);
        Boolean retorno1 = clienteDao.cadastrar(cliente1);
        Assert.assertTrue(retorno1);

        Collection<Cliente> list = clienteDao.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli.getCpf());
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });

        Collection<Cliente> list1 = clienteDao.buscarTodos();
        assertNotNull(list1);
        assertEquals(0, list1.size());
    }
}
