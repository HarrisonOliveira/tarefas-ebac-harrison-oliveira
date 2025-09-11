package org.projeto4Mod35.services;

import org.projeto4Mod35.dao.generic.IGenericJpaDAO;
import org.projeto4Mod35.domain.ProdutoJpa;
import org.projeto4Mod35.services.generic.GenericJpaService;

public class ProdutoService extends GenericJpaService<ProdutoJpa, String> implements IProdutoService {

	public ProdutoService(IGenericJpaDAO produtoDAO) {
		super(produtoDAO);
	}
}
