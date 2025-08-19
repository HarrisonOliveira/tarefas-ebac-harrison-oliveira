package br.com.harrison.jdbc.dao;

import br.com.harrison.cliente.Cliente;
import br.com.harrison.jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ClienteDao implements IClienteDao{
    final Logger LOGGER = Logger.getLogger(String.valueOf(ClienteDao.class));

    @Override
    public Integer cadastrarCliente(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement statementPrepared = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlClienteInsert();
            statementPrepared = connection.prepareStatement(sql);
            adicionarParametrosInsert(statementPrepared, cliente);
            return statementPrepared.executeUpdate();
        } catch (Exception e){
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
            throw e;
        } finally {
            closeConnection(connection, statementPrepared, null);
        }
    }

    private void adicionarParametrosInsert(PreparedStatement preparedStatement, Cliente cliente) throws SQLException {
        preparedStatement.setString(1, cliente.getCodigo());
        preparedStatement.setString(2, cliente.getNome());
    }

    private String getSqlClienteInsert() {
        return "INSERT INTO tb_cliente (codigo, nome) VALUES (?, ?)";
    }

    @Override
    public Integer atualizarCliente(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlClienteUpdate();
            statement = connection.prepareStatement(sql);
            adicionarParametrosUpdate(statement, cliente);
            return statement.executeUpdate();
        } catch (Exception e){
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
            throw e;
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    private void adicionarParametrosUpdate(PreparedStatement statementPrepared, Cliente cliente) throws SQLException {
        statementPrepared.setString(1, cliente.getNome());
        statementPrepared.setString(2, cliente.getCodigo());
    }

    private String getSqlClienteUpdate() {
        return "UPDATE tb_cliente SET nome = ? WHERE codigo = ?";
    }

    @Override
    public Integer excluirCliente(Cliente cliente) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlExcluirCliente();
            statement = connection.prepareStatement(sql);
            adicionarParametroExcluirCliente(statement, cliente);
            return statement.executeUpdate();
        } catch (Exception e){
            System.out.println("Não foi possivel encontrar o Cliente: " + e.getMessage());
            throw e;
        }finally {
            closeConnection(connection, statement, null );
        }
    }

    private void adicionarParametroExcluirCliente(PreparedStatement statement, Cliente cliente) throws SQLException{
        statement.setString(1, cliente.getCodigo());
    }

    private String getSqlExcluirCliente() {
        return "DELETE FROM tb_cliente WHERE codigo = ?";
    }

    @Override
    public Cliente consultarCliente(String codigo) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Cliente cliente = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlClienteSelect();
            statement = connection.prepareStatement(sql);
            adicionarParametroSelect(statement, codigo);
            resultSet = statement.executeQuery();

            if (resultSet.next()){
                cliente = new Cliente();
                Long id = resultSet.getLong("ID");
                String cod = resultSet.getString("CODIGO");
                String nome = resultSet.getString("NOME");

                cliente.setId(id);
                cliente.setCodigo(cod);
                cliente.setNome(nome);
            }
        } catch (Exception e){
            System.out.println("[Erro ao buscar cliente] - Cliente não encontrado: " + e.getMessage() );
            throw e;
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return cliente;

    }

    private void adicionarParametroSelect(PreparedStatement statement, String codigo) throws SQLException{
        statement.setString(1, codigo);
    }

    private String getSqlClienteSelect() {
        return "SELECT * FROM tb_cliente WHERE codigo = ?";
    }

    @Override
    public List<Cliente> consultarTodosClientes() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Cliente> listaCliente = new ArrayList<>();
        Cliente cliente;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlSelectAll();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()){
                cliente = new Cliente();
                Long id = resultSet.getLong("ID");
                String cod = resultSet.getString("CODIGO");
                String nome = resultSet.getString("NOME");

                cliente.setId(id);
                cliente.setCodigo(cod);
                cliente.setNome(nome);
                listaCliente.add(cliente);
            }
        } catch (Exception e){
            LOGGER.config("Usuários não encontrado na tabela: " + e.getMessage());
            throw e;
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return listaCliente;
    }

    private String getSqlSelectAll() {
        return "SELECT * FROM tb_cliente";
    }

    private void closeConnection(Connection connection, PreparedStatement statementPrepared, ResultSet result) {
        try {
//          Se a conexão não for nula e nem estiver fechado, eu fecho a conexão.
            if(connection != null && !connection.isClosed()) connection.close();
            if(statementPrepared != null && !statementPrepared.isClosed()) statementPrepared.close();
            if(result != null && !result.isClosed()) result.close();
        } catch (SQLException e) {
            LOGGER.config("Ocorreu um erro ao processar a requisição: " + e.getMessage());
        }
    }
}
