package CadastroProdutos.generic;

import CadastroProdutos.Persistence;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class GenericDAO<T extends Persistence> implements IgenericDAO<T> {

    private Map<Class, Map<Long, T>> map;

    public GenericDAO(){
        this.map = new HashMap<>();
    }

    @Override
    public Boolean cadastrar(T entity) {
        return null;
    }

    @Override
    public void excluir(Long valor) {

    }

    @Override
    public void alterar(T entity) {

    }

    @Override
    public T pesquisar(Long valor) {
        return null;
    }

    @Override
    public Collection<T> pesquisarTodos() {
        return List.of();
    }
}
