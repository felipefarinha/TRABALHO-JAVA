package br.com.ConexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

	private static ConexaoMySQL conexaoMySQL;
	
	public static ConexaoMySQL getInstance() {
		if (conexaoMySQL == null) {
			conexaoMySQL = new ConexaoMySQL();
		}
		return conexaoMySQL;
	}
	
	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/sisvendas", "kelvin", "Kelvin_28");
	    return connection;
    }
}
