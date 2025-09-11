
package org.projeto4Mod35.services;

import org.projeto4Mod35.domain.ClienteJpa;
import org.projeto4Mod35.exceptions.DAOException;
import org.projeto4Mod35.services.generic.IGenericJpaService;

public interface IClienteService extends IGenericJpaService<ClienteJpa, Long> {

	ClienteJpa buscarPorCPF(Long cpf) throws DAOException;

}
