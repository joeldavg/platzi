package mensajes.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	
	public Connection getConnection() {
		
		String user = "root";
		String password = "root";
		//String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mensajes_app";
		
		Connection conection = null;
		
		try {
			conection = DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return conection;
	}
	
}
