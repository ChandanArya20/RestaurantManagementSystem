package in.ineuron.test;

import java.sql.Connection;

import in.ineuron.dao.factory.ConnectionFactory;

public class Test {
	
	public static void main(String[] args) {
		
		Connection connection = ConnectionFactory.getConnection();
		System.out.println(connection);
		
		
	}

}
