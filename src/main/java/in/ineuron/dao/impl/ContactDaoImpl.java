package in.ineuron.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.ineuron.dao.ContactDao;
import in.ineuron.dao.factory.ConnectionFactory;

public class ContactDaoImpl implements ContactDao{

	@Override
	public String saveContactMessageToDB(String name, String email, String subject, String message) {
		
		String query = "INSERT INTO contact_messages(name, email, subject, message) VALUES(?, ?, ?, ?)";
		
		try {
			Connection connection = ConnectionFactory.getConnection();
			
			if(connection!=null) {
				PreparedStatement stm = connection.prepareStatement(query);
				stm.setString(1, name);
				stm.setString(2, email);
				stm.setString(3, subject);
				stm.setString(4, message);
				
				stm.executeUpdate();
				return "SAVED";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "FAILED";
		}
		
		return "FAILED";
	}

}
