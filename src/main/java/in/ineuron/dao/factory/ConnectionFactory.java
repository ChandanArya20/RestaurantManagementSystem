package in.ineuron.dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static String url = "jdbc:mysql://localhost:3306/restaurant_db";
	private static String user = "root";
	private static String password = "2002ckc+";
	private static  Connection conn;
	
	private ConnectionFactory() {
		
	}
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn =  DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return conn;
	}
}
