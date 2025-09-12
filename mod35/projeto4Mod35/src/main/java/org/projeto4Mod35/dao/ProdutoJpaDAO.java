package org.projeto4Mod35.dao;

import org.projeto4Mod35.dao.generic.GenericJpaDAO;
import org.projeto4Mod35.domain.ProdutoJpa;

public class ProdutoJpaDAO extends GenericJpaDAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

    public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}
}
