package br.com.harrison.dao;

import br.com.harrison.produto.Produto;

import java.sql.SQLException;
import java.util.List;

public interface IProdutoDao {
    public java.lang.Integer cadastrarProduto(Produto produto) throws SQLException;
    public List<Produto> buscarTodosProdutos() throws SQLException;
    public Produto buscarProduto(String eanProduto) throws SQLException;
    public java.lang.Integer atulizarProduto(Produto produto) throws SQLException;
    public void excluirProduto(String eanProdtuo) throws SQLException;
}
