package org.projeto4Mod35.dao;

import org.projeto4Mod35.dao.generic.GenericJpaDAO;
import org.projeto4Mod35.domain.ClienteJpa;

public class ClienteJpaDAO extends GenericJpaDAO<ClienteJpa, Long> implements IClienteJpaDAO {
	public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}

    @Override
    public void excluir(Long valor) {
        openConnection();
        valor = entityManager.merge(valor);
        entityManager.remove(valor);
        entityManager.getTransaction().commit();
        closeConnection();
    }
}
