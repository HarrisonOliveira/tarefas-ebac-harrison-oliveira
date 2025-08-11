package br.com.harrison.service;

import br.com.harrison.Dao.IProdutoDao;
import br.com.harrison.produto.Produto;

public class ProdutoService implements IProdutoService{

    IProdutoDao produtoDao;

    public ProdutoService(IProdutoDao produtoDao){
        this.produtoDao = produtoDao;
    }

    @Override
    public void salvarProduto(int codigoInterno, Produto produto) {
        produtoDao.salvarProduto(codigoInterno, produto);
    }

    @Override
    public Produto consultarProdutoCodigoInterno(Integer codigoInterno) {
        return produtoDao.consultarProdutoCodigoInterno(codigoInterno);
    }
}
