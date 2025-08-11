package br.com.harrison.service;

import br.com.harrison.produto.Produto;

public interface IProdutoService {

    void salvarProduto(int codigoInterno, Produto produto);
    Produto consultarProdutoCodigoInterno(Integer codigoInterno);

}
