package org.projeto4Mod35.dao;

import org.projeto4Mod35.dao.generic.IGenericJpaDAO;
import org.projeto4Mod35.domain.VendaJpa;
import org.projeto4Mod35.exceptions.DAOException;
import org.projeto4Mod35.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaJpaDAO extends IGenericJpaDAO<VendaJpa, Long> {

	public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException;

	public VendaJpa consultarComCollection(Long id);
}
