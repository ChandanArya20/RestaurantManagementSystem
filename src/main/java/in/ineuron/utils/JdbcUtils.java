package in.ineuron.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	public static Connection getConnection() throws SQLException, IOException {

		return DriverManager.getConnection(url, username, password);
	}
	
	public static void closeResources(Connection connection, PreparedStatement stm, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
