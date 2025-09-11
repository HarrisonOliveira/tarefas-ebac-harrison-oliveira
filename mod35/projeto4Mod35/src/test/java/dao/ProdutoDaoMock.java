/**
 * 
 */
package dao;

import org.projeto4Mod35.dao.IProdutoJpaDAO;
import org.projeto4Mod35.domain.ProdutoJpa;
import org.projeto4Mod35.exceptions.DAOException;
import org.projeto4Mod35.exceptions.MaisDeUmRegistroException;
import org.projeto4Mod35.exceptions.TableException;
import org.projeto4Mod35.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;

public class ProdutoDaoMock implements IProdutoJpaDAO {

	@Override
	public ProdutoJpa cadastrar(ProdutoJpa entity) throws TipoChaveNaoEncontradaException {
		// TODO Auto-generated method stub
		return entity;
	}

    @Override
    public void excluir(ProdutoJpa entity) throws DAOException {

    }

    @Override
    public void excluir(String valor) {
		// TODO Auto-generated method stub
	}

	@Override
	public ProdutoJpa alterar(ProdutoJpa entity) throws TipoChaveNaoEncontradaException {
		// TODO Auto-generated method stub
        return entity;
    }

    @Override
    public ProdutoJpa consultar(Long id) throws MaisDeUmRegistroException, TableException, DAOException {
        return null;
    }

    @Override
    public ProdutoJpa consultar(String valor) {
        ProdutoJpa produto = new ProdutoJpa();
		produto.setCodigo(valor);
		return produto;
	}

	@Override
	public Collection<ProdutoJpa> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
