package com.vendas.service;

import java.util.List;

import com.vendas.domain.Produto;
import com.vendas.service.generic.IGenericService;

public interface IProdutoService extends IGenericService<Produto, String> {

	List<Produto> filtrarProdutos(String query);

}
