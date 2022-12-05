package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
	
	public Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lp2a4", "root", "110401");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	

}
