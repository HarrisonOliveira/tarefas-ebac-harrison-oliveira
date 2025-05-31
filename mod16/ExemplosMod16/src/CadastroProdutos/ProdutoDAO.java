package CadastroProdutos;

import java.util.*;

public class ProdutoDAO implements IprodutoDAO{

    @Override
    public Boolean cadastrarProduto(Produto produto) {
        return null;
    }

    @Override
    public void excluirProduto(Long codigoBarrasProduto) {

    }

    @Override
    public void alterarProduto(Produto produto) {

    }

    @Override
    public Produto pesquisarProduto(Long codigoBarrasProduto) {
        return null;
    }

    @Override
    public Collection<Produto> pesquisarTodosOsProdutos() {
        return List.of();
    }
}
