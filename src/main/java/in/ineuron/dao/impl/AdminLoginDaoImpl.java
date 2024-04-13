package in.ineuron.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.ineuron.dao.AdminLoginDao;
import in.ineuron.returnstatus.AdminLoginStatus;
import in.ineuron.utils.JdbcUtils;

public class AdminLoginDaoImpl implements AdminLoginDao {

    @Override
    public AdminLoginStatus checkAdminLoginData(String username, String password) {
    	
        String query = "SELECT password FROM admin WHERE username=?";
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtils.getConnection();

            if (connection != null) {
                stm = connection.prepareStatement(query);
                stm.setString(1, username);

                resultSet = stm.executeQuery();

                if (resultSet.next()) {
                    String pass = resultSet.getString("password");

                    if (pass.equals(password)) {
                        return AdminLoginStatus.OK;
                    } else {
                        return AdminLoginStatus.PASSWORD_INCORRECT;
                    }
                } else {
                    return AdminLoginStatus.USERNAME_NOT_EXIST;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return AdminLoginStatus.FAILED;
        } finally {
        	JdbcUtils.closeResources(connection, stm, resultSet);
        }

        return AdminLoginStatus.FAILED;
    }
}
