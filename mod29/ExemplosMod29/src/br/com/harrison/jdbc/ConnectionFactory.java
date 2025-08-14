package br.com.harrison.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static Connection connection;

    private ConnectionFactory(Connection connection) {
        ConnectionFactory.connection = connection;
    }

    public static Connection getConnection() {
        if (connection == null) {
            connection = initConnection();
        }
        return connection;
    }

    private static Connection initConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:15432/exemplo_mod29", "postgres", "admin");
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
