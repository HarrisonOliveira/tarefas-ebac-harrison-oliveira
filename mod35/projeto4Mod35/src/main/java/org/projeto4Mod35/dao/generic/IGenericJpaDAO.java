package org.projeto4Mod35.dao.generic;

import org.projeto4Mod35.dao.Persistente;
import org.projeto4Mod35.exceptions.DAOException;
import org.projeto4Mod35.exceptions.MaisDeUmRegistroException;
import org.projeto4Mod35.exceptions.TableException;
import org.projeto4Mod35.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

/**
 * Interface genérica para métodos de CRUD(Create, Read, Update and Delete)
 */
public interface IGenericJpaDAO<T extends Persistente, E extends Serializable> {

    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
    public void excluir(T entity) throws DAOException;
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
    public T consultar(E id) throws MaisDeUmRegistroException, TableException, DAOException;
    public Collection<T> buscarTodos() throws DAOException;
}
