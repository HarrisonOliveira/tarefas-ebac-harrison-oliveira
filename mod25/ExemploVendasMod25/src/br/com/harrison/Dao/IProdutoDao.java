package br.com.harrison.Dao;

import br.com.harrison.produto.Produto;

public interface IProdutoDao {
    void salvarProduto(int codigointerno, Produto produto);
    Produto consultarProdutoCodigoInterno(Integer codigoInterno);
}
