package in.ineuron.dao.factory;

import in.ineuron.dao.AdminLoginDao;
import in.ineuron.dao.impl.AdminLoginDaoImpl;

public class AdminLoginDaoFactory {
	
	private static AdminLoginDao adminLoginDao;

	private AdminLoginDaoFactory() {
		
	}
	
	public static AdminLoginDao getContactDao() {
		if(adminLoginDao==null) {
			adminLoginDao = new AdminLoginDaoImpl();
		}
		
		return adminLoginDao;
	}

}
