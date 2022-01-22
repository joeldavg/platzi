package amazonviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import static amazonviewer.db.DataBase.*;

public interface IDBConnection {
	
	default Connection connectToDB() {
		Connection connection = null;
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			Class.forName(driver);
			connection = DriverManager.getConnection(URL+DB, USER, PASSWORD);
			if (connection != null) {
				System.out.println("Se establecio la conexion :)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return connection;
		}
	}
	
}
