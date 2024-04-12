package in.ineuron.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
	
	private static String url = "jdbc:mysql://localhost:3306/restaurant_db";
	private static String username = "root";
	private static String password = "2002ckc+";
	private static  Connection conn;

	private JdbcUtils() {
	}

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	public static Connection getJdbcConnection() throws SQLException, IOException {

		return DriverManager.getConnection(url, username, password);
	}

}
