package br.com.harrison;

import java.sql.*;
import java.util.logging.Logger;

public class ConnectionFactory {
    static Connection connection;

    private ConnectionFactory(Connection connection) {
        ConnectionFactory.connection = connection;
    }


    public static Connection getConnection() throws SQLException {

        if (connection == null){
            return initConnection();
        } else if (connection.isClosed()) {
            return initConnection();
        }
        return connection;
    }

    private static Connection initConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:15432/exemplo_mod29",
                    "postgres",
                    "admin"
            );
        } catch (Exception e){
           throw new RuntimeException("Erro ao tentar conectar com o bando de dados: " + e.getMessage());
        }
    }
    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) throws SQLException {
        try {

            if (connection != null && !connection.isClosed()) connection.close();
            if (statement != null && !statement.isClosed()) statement.close();
            if (resultSet != null && !statement.isClosed()) statement.close();
        } catch (SQLException e){
            Logger.getLogger("Erro ao fechar conexão: " + e.getMessage());
        }
    }
}
