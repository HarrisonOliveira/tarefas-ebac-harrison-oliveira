package br.com.harrison.Dao;

import br.com.harrison.produto.Produto;

import java.util.HashMap;
import java.util.Map;

public class ProdutoDao implements IProdutoDao{

    Map<Integer, Produto> listaProdutos = new HashMap<>();

    @Override
    public void salvarProduto(int codigoInterno, Produto produto) {
        listaProdutos.put(codigoInterno, produto);
    }

    @Override
    public Produto consultarProdutoCodigoInterno(Integer codigoInterno) {
        return listaProdutos.get(codigoInterno);
    }
}
