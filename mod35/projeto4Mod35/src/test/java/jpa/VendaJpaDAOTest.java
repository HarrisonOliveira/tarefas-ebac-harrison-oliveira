package jpa;

import dao.VendaExclusaoJpaDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.projeto4Mod35.dao.*;
import org.projeto4Mod35.domain.ClienteJpa;
import org.projeto4Mod35.domain.ProdutoJpa;
import org.projeto4Mod35.domain.VendaJpa;
import org.projeto4Mod35.exceptions.DAOException;
import org.projeto4Mod35.exceptions.MaisDeUmRegistroException;
import org.projeto4Mod35.exceptions.TableException;
import org.projeto4Mod35.exceptions.TipoChaveNaoEncontradaException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.Collection;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import org.projeto4Mod35.domain.VendaJpa.Status;

public class VendaJpaDAOTest {
	
	private final IVendaJpaDAO vendaDao;
	
	private final IVendaJpaDAO vendaExclusaoDao;

	private final IClienteJpaDAO clienteDao;
	
	private final IProdutoJpaDAO produtoDao;
	
	private final Random rd;
	
	private ClienteJpa cliente;
	
	private ProdutoJpa produto;
	
	public VendaJpaDAOTest() {
		this.vendaDao = new VendaJpaDAO();
		vendaExclusaoDao = new VendaExclusaoJpaDAO();
		this.clienteDao = new ClienteJpaDAO();
		this.produtoDao = new ProdutoJpaDAO();
		rd = new Random();
	}
	
	@BeforeEach
	public void init() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		this.cliente = cadastrarCliente();
		this.produto = cadastrarProduto("A1", BigDecimal.TEN);
	}
	
	@AfterEach
	public void end() throws DAOException {
		excluirVendas();
		excluirProdutos();
		clienteDao.excluir(this.cliente);
	}
	
	@Test
	public void pesquisar() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		VendaJpa venda = criarVenda("A1");
		VendaJpa retorno = vendaDao.cadastrar(venda);
        assertNotNull(retorno);
		VendaJpa vendaConsultada = vendaDao.consultar(venda.getId());
        assertNotNull(vendaConsultada);
        assertNotNull(venda.getCodigo(), vendaConsultada.getCodigo());
	}
	
	@Test
	public void salvar() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		VendaJpa venda = criarVenda("A2");
		VendaJpa retorno = vendaDao.cadastrar(venda);
        assertNotNull(retorno);
        

        assertEquals(0, venda.getValorTotal().compareTo(BigDecimal.valueOf(20)));
        assertEquals(VendaJpa.Status.INICIADA, venda.getStatus());

        VendaJpa vendaConsultada = vendaDao.consultar(venda.getId());
        assertEquals(vendaConsultada.getId(), venda.getId());
        assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
	} 
	
	@Test
	public void cancelarVenda() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A3";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		retorno.setStatus(VendaJpa.Status.CANCELADA);
		vendaDao.cancelarVenda(venda);
		
		VendaJpa vendaConsultada = vendaDao.consultar(venda.getId());
		assertEquals(codigoVenda, vendaConsultada.getCodigo());
		assertEquals(VendaJpa.Status.CANCELADA, vendaConsultada.getStatus());
	}
	
	@Test
	public void adicionarMaisProdutosDoMesmo() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A4";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		vendaConsultada.adicionarProduto(produto, 1);

        assertEquals(3, (int) vendaConsultada.getQuantidadeTotalProdutos());
		BigDecimal valorTotal = BigDecimal.valueOf(30).setScale(2, RoundingMode.HALF_DOWN);
        assertEquals(vendaConsultada.getValorTotal(), valorTotal);
        assertEquals(Status.INICIADA, vendaConsultada.getStatus());
	} 
	
	@Test
	public void adicionarMaisProdutosDiferentes() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A5";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		ProdutoJpa prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());
		
		//TODO Usando este método para evitar a exception org.hibernate.LazyInitializationException
		// Ele busca todos os dados da lista pois a mesma por default é lazy
		VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		vendaConsultada.adicionarProduto(prod, 1);

        assertEquals(3, (int) vendaConsultada.getQuantidadeTotalProdutos());
		BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
        assertEquals(vendaConsultada.getValorTotal(), valorTotal);
        assertEquals(Status.INICIADA, vendaConsultada.getStatus());
	} 
	
	@Test
	public void salvarVendaMesmoCodigoExistente() throws TipoChaveNaoEncontradaException, DAOException {
		VendaJpa venda = criarVenda("A6");
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
	
		VendaJpa venda1 = criarVenda("A6");
		VendaJpa retorno1 = vendaDao.cadastrar(venda1);
		assertNull(retorno1);
        assertEquals(Status.INICIADA, venda.getStatus());
	} 
	
	@Test
	public void removerProduto() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A7";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		ProdutoJpa prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());
		
		VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		vendaConsultada.adicionarProduto(prod, 1);
        assertEquals(3, (int) vendaConsultada.getQuantidadeTotalProdutos());
		BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
        assertEquals(vendaConsultada.getValorTotal(), valorTotal);
		
		
		vendaConsultada.removerProduto(prod, 1);
        assertEquals(2, (int) vendaConsultada.getQuantidadeTotalProdutos());
		valorTotal = BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_DOWN);
        assertEquals(vendaConsultada.getValorTotal(), valorTotal);
        assertEquals(Status.INICIADA, vendaConsultada.getStatus());
	} 
	
	@Test
	public void removerApenasUmProduto() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A8";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		ProdutoJpa prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());
		
		VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		vendaConsultada.adicionarProduto(prod, 1);
        assertEquals(3, (int) vendaConsultada.getQuantidadeTotalProdutos());
		BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
        assertEquals(vendaConsultada.getValorTotal(), valorTotal);
		
		
		vendaConsultada.removerProduto(prod, 1);
        assertEquals(2, (int) vendaConsultada.getQuantidadeTotalProdutos());
		valorTotal = BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_DOWN);
        assertEquals(vendaConsultada.getValorTotal(), valorTotal);
        assertEquals(Status.INICIADA, vendaConsultada.getStatus());
	} 
	
	@Test
	public void removerTodosProdutos() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A9";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		ProdutoJpa prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
		assertNotNull(prod);
		assertEquals(codigoVenda, prod.getCodigo());
		
		VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		vendaConsultada.adicionarProduto(prod, 1);
        assertEquals(3, (int) vendaConsultada.getQuantidadeTotalProdutos());
		BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
        assertEquals(vendaConsultada.getValorTotal(), valorTotal);
		
		
		vendaConsultada.removerTodosProdutos();
        assertEquals(0, (int) vendaConsultada.getQuantidadeTotalProdutos());
        assertEquals(vendaConsultada.getValorTotal(), BigDecimal.valueOf(0));
        assertEquals(Status.INICIADA, vendaConsultada.getStatus());
	} 
	
	@Test
	public void finalizarVenda() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A10";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		venda.setStatus(VendaJpa.Status.CONCLUIDA);
		vendaDao.finalizarVenda(venda);
		
		VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
		assertEquals(VendaJpa.Status.CONCLUIDA, vendaConsultada.getStatus());
	}
	
	@Test
	public void tentarAdicionarProdutosVendaFinalizada() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		String codigoVenda = "A11";
		VendaJpa venda = criarVenda(codigoVenda);
		VendaJpa retorno = vendaDao.cadastrar(venda);
		assertNotNull(retorno);
		assertNotNull(venda);
		assertEquals(codigoVenda, venda.getCodigo());
		
		venda.setStatus(VendaJpa.Status.CONCLUIDA);
		vendaDao.finalizarVenda(venda);
		
		VendaJpa vendaConsultada = vendaDao.consultarComCollection(venda.getId());
		assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
		assertEquals(VendaJpa.Status.CONCLUIDA, vendaConsultada.getStatus());
		
		vendaConsultada.adicionarProduto(this.produto, 1);
		
	}
	
	
	private void excluirProdutos() throws DAOException {
		Collection<ProdutoJpa> list = this.produtoDao.buscarTodos();
		list.forEach(prod -> {
			try {
				this.produtoDao.excluir(prod);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	private void excluirVendas() throws DAOException {
		Collection<VendaJpa> list = this.vendaExclusaoDao.buscarTodos();
		list.forEach(prod -> {
			try {
				this.vendaExclusaoDao.excluir(prod);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	private ProdutoJpa cadastrarProduto(String codigo, BigDecimal valor) throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ProdutoJpa produto = new ProdutoJpa();
		produto.setCodigo(codigo);
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(valor);
		produtoDao.cadastrar(produto);
		return produto;
	}

	private ClienteJpa cadastrarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		ClienteJpa cliente = new ClienteJpa();
		cliente.setCpf(rd.nextLong());
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		clienteDao.cadastrar(cliente);
		return cliente;
	}
	
	private VendaJpa criarVenda(String codigo) {
		VendaJpa venda = new VendaJpa();
		venda.setCodigo(codigo);
		venda.setDataVenda(Instant.now());
		venda.setCliente(this.cliente);
		venda.setStatus(Status.INICIADA);
		venda.adicionarProduto(this.produto, 2);
		return venda;
	}
}
