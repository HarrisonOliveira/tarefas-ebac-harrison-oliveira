
package org.projeto4Mod35.services;

import org.projeto4Mod35.dao.IClienteJpaDAO;
import org.projeto4Mod35.domain.ClienteJpa;
import org.projeto4Mod35.exceptions.DAOException;
import org.projeto4Mod35.exceptions.MaisDeUmRegistroException;
import org.projeto4Mod35.exceptions.TableException;
import org.projeto4Mod35.services.generic.GenericJpaService;

public class ClienteService extends GenericJpaService<ClienteJpa, Long> implements IClienteService {

        public ClienteService(IClienteJpaDAO clienteDAO) {
		super(clienteDAO);
	}

	@Override
	public ClienteJpa buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
