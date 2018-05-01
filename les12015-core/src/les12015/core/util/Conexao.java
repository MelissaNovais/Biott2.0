
package les12015.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost/biott";
		
		String user = "root";	
		String password = "root";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;

	}

}
