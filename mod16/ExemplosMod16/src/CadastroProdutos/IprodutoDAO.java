package CadastroProdutos;

import java.util.Collection;

public interface IprodutoDAO {

    public Boolean cadastrarProduto(Produto produto);
    public void excluirProduto(Long codigoBarrasProduto);
    public void alterarProduto(Produto produto);
    public Produto pesquisarProduto(Long codigoBarrasProduto);
    public Collection<Produto> pesquisarTodosOsProdutos();
}
