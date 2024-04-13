package in.ineuron.service.factory;

import in.ineuron.service.AdminLoginService;
import in.ineuron.service.impl.AdminLoginServiceImpl;

public class AdminLoginServiceFactory {

	private static AdminLoginService adminLoginService;

	private AdminLoginServiceFactory() {
		
	}
	
	public static AdminLoginService getAdminLoginService() {
		if(adminLoginService==null) {
			adminLoginService = new AdminLoginServiceImpl();
		}
		
		return adminLoginService;
	}
	
	

}
