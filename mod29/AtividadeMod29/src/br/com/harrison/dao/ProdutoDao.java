package br.com.harrison.dao;

import br.com.harrison.ConnectionFactory;
import br.com.harrison.produto.Produto;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao implements IProdutoDao{
    @Override
    public java.lang.Integer cadastrarProduto(Produto produto) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlCadastrarNovoProduto();
            statement = connection.prepareStatement(sql);
            adicionarParametroCreate(statement, produto);
            return statement.executeUpdate();

        } catch (Exception e){
            System.out.println("[Erro ao cadastrar novo Produto] - " + e.getMessage());
            throw e;
        } finally {
            ConnectionFactory.closeConnection(connection, statement, null);
        }
    }

    private void adicionarParametroCreate(PreparedStatement statement, Produto produto) throws SQLException {
        statement.setString(1, produto.getNomeProduto());
        statement.setString(2, produto.getEanProduto());
        statement.setBigDecimal(3, produto.getValor());
    }

    private String getSqlCadastrarNovoProduto() {
        return "INSERT INTO produto (nome_produto, ean_produto, valor) values (?, ?, ?)";
    }

    @Override
    public List<Produto> buscarTodosProdutos() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Produto> listaProdutos = new ArrayList<>();
        Produto produto;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlBuscaTodosProdutos();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                produto = new Produto();
                Integer id = resultSet.getInt("id");
                String nomeProduto = resultSet.getString("nome_produto");
                String ean = resultSet.getString("ean_produto");
                BigDecimal valor = resultSet.getBigDecimal("valor");

                produto.setId(id);
                produto.setNomeProduto(nomeProduto);
                produto.setEanProduto(ean);
                produto.setValor(valor);

                listaProdutos.add(produto);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar Produto: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        return listaProdutos;
    }

    private String getSqlBuscaTodosProdutos() {
        return "SELECT * FROM produto";
    }

    @Override
    public Produto buscarProduto(String eanProduto) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Produto produto = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlBuscarProduto();
            statement = connection.prepareStatement(sql);
            aplicarParametroSelect(statement, eanProduto);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                produto = new Produto();
                Integer id = resultSet.getInt("id");
                String nomeProduto = resultSet.getString("nome_produto");
                String ean = resultSet.getString("ean_produto");
                BigDecimal valor = resultSet.getBigDecimal("valor");

                produto.setId(id);
                produto.setNomeProduto(nomeProduto);
                produto.setEanProduto(ean);
                produto.setValor(valor);
            }
        } catch (Exception e){
            throw new SQLException("Erro ao buscar produto: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        return produto;
    }

    private void aplicarParametroSelect(PreparedStatement statement, String eanProduto) throws SQLException {
        statement.setString(1, eanProduto);
    }

    private String getSqlBuscarProduto() {
        return "SELECT * FROM produto where ean_produto = ?";
    }

    @Override
    public java.lang.Integer atulizarProduto(Produto produto) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        Produto produtoAtualizado = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlAtualizarProduto();
            statement = connection.prepareStatement(sql);
            aplicarParametroAtualizar(statement, produto);
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Produto: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, statement, null);
        }

    }

    private void aplicarParametroAtualizar(PreparedStatement statement, Produto produto) throws SQLException {
        statement.setString(1, produto.getNomeProduto());
        statement.setBigDecimal(2, produto.getValor());
        statement.setString(3, produto.getEanProduto());
    }

    private String getSqlAtualizarProduto() {
        return "UPDATE produto SET nome_produto = ?, VALOR = ? WHERE ean_produto = ?";
    }

    @Override
    public void excluirProduto(String eanProdtuo) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlExcluirProduto();
            statement = connection.prepareStatement(sql);
            aplicarParametroExcluirProduto(statement, eanProdtuo);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, null);
        }
    }

    private void aplicarParametroExcluirProduto(PreparedStatement statement, String eanProdtuo) throws SQLException {
        statement.setString(1, eanProdtuo);
    }

    private String getSqlExcluirProduto() {
        return "DELETE FROM produto WHERE ean_produto = ?";
    }


}
