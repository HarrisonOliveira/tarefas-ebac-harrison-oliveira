package org.projeto4Mod35.dao;

import org.projeto4Mod35.dao.generic.GenericJpaDAO;
import org.projeto4Mod35.domain.ProdutoJpa;

public class ProdutoJpaDAO extends GenericJpaDAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

    public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}

    @Override
    public void excluir(String valor) {
        openConnection();
        entityManager.remove(entityManager.find(ProdutoJpa.class, valor));
    }

    @Override
    public ProdutoJpa consultar(String valor) {
        openConnection();
        ProdutoJpa produto = entityManager.find(ProdutoJpa.class, valor);
        entityManager.getTransaction().commit();
        closeConnection();
        return produto;
    }
}
