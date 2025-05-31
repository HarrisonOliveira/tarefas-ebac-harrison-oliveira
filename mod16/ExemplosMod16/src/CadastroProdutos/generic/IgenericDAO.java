package CadastroProdutos.generic;

import CadastroProdutos.Persistence;

import java.util.Collection;

public interface IgenericDAO <T extends Persistence> {
    public Boolean cadastrar(T entity);
    public void excluir(Long valor);
    public void alterar(T entity);
    public T pesquisar(Long valor);
    public Collection<T> pesquisarTodos();

}
