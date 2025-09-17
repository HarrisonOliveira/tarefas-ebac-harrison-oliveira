package com.vendas.dao;

import java.util.List;

import com.vendas.dao.generic.IGenericDAO;
import com.vendas.domain.Produto;

public interface IProdutoDAO extends IGenericDAO<Produto, String> {

	List<Produto> filtrarProdutos(String query);

}
