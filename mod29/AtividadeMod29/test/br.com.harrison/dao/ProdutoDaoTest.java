package br.com.harrison.dao;

import br.com.harrison.produto.Produto;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class ProdutoDaoTest {

    @Test
    void cadastrarNovoProduto() throws SQLException {
        ProdutoDao produtoDao = new ProdutoDao();
        Produto produto = new Produto();

        produto.setNomeProduto("Feijão");
        produto.setEanProduto("1002");
        produto.setValor(new BigDecimal("1002"));

        produtoDao.cadastrarProduto(produto);
    }

    @Test
    void buscaTodosProdutos() throws SQLException {
        ProdutoDao produtoDao = new ProdutoDao();
        List<Produto> produtos = produtoDao.buscarTodosProdutos();

        produtos.forEach(System.out::println);
    }

    @Test
    void buscarProduto() throws SQLException {
        ProdutoDao produtoDao = new ProdutoDao();
        Produto produto = new Produto();

        produto.setEanProduto("1002");

        Produto produdoEncontrado = produtoDao.buscarProduto("1002");
        System.out.println(produdoEncontrado);
    }

    @Test
    void atualizarProduto() throws SQLException {
        ProdutoDao produtoDao = new ProdutoDao();
        Produto produto = new Produto();

        produtoDao.buscarProduto("1002");

        produto.setNomeProduto("Feijão");
        produto.setEanProduto("1002");
        produto.setValor(new BigDecimal("55.23"));

        produtoDao.atulizarProduto(produto);

    }

    @Test
    void excluirProduto() throws SQLException {
         ProdutoDao produtoDao = new ProdutoDao();

         produtoDao.excluirProduto("1002");
    }


}
