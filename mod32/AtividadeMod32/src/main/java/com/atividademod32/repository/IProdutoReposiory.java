package com.atividademod32.repository;

import com.atividademod32.entity.ProdutoEntity;

import java.util.List;

public interface IProdutoReposiory {

    ProdutoEntity cadastroProduto(ProdutoEntity produto);
    ProdutoEntity buscaProdutoPorCodigo(String codigoInterno);
    List<ProdutoEntity> buscarTodosProdutos();
    void atiluzarNomeDoProduto(String produto, String codigoInterno);
    void excluirProduto(String codigoInterno);
}
