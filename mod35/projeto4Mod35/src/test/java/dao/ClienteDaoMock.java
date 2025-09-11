package dao;

import org.projeto4Mod35.dao.IClienteJpaDAO;
import org.projeto4Mod35.domain.ClienteJpa;
import org.projeto4Mod35.exceptions.DAOException;
import org.projeto4Mod35.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;

public class ClienteDaoMock implements IClienteJpaDAO {

	@Override
	public ClienteJpa cadastrar(ClienteJpa entity) throws TipoChaveNaoEncontradaException {
		// TODO Auto-generated method stub
		return entity;
	}

    @Override
    public void excluir(ClienteJpa entity) throws DAOException {
        // TODO Auto-generated method stub
    }

    @Override
    public void excluir(Long valor) {
		// TODO Auto-generated method stub
	}

	@Override
	public ClienteJpa alterar(ClienteJpa entity) throws TipoChaveNaoEncontradaException {
		// TODO Auto-generated method stub
        return entity;
    }

	@Override
	public ClienteJpa consultar(Long valor) {
        ClienteJpa cliente = new ClienteJpa();
		cliente.setCpf(valor);
		return cliente;
	}

	@Override
	public Collection<ClienteJpa> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}


}
