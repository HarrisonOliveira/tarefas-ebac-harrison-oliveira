/**
 * 
 */
package br.com.rpires.dao.generic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author rodrigo.pires
 *
 */
public class ConnectionFactory {
	
	private static Connection connection;
	
	private ConnectionFactory(Connection connection) {
		ConnectionFactory.connection = connection;
	}
	
	public static Connection getConnection() throws SQLException {
		if (connection == null) {
			connection = initConnection();
		} else if (connection.isClosed()) {
			connection = initConnection();
		}
        return connection;
	}
	
	private static Connection initConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:15432/atividade_mod_30",
                    "postgres",
                    "admin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
}
