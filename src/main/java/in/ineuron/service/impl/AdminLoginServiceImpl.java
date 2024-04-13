package in.ineuron.service.impl;

import in.ineuron.dao.AdminLoginDao;
import in.ineuron.dao.factory.AdminLoginDaoFactory;
import in.ineuron.returnstatus.AdminLoginStatus;
import in.ineuron.service.AdminLoginService;
import in.ineuron.validation.AdminLoginValidation;

public class AdminLoginServiceImpl implements AdminLoginService {

	@Override
	public String loginAdmin(String username, String password) {
		
		String result;
		
		try {
			AdminLoginValidation validation = new AdminLoginValidation();
			result = validation.validate(username, password);
			
			if(result.equals("VALID")) {
				AdminLoginDao adminLoginDao = AdminLoginDaoFactory.getContactDao();
				AdminLoginStatus status = adminLoginDao.checkAdminLoginData(username, password);
				
				if(status == AdminLoginStatus.OK) {
					result = "SUCCESS";
				}else if(status==AdminLoginStatus.USERNAME_NOT_EXIST) {
					result = "Username not exist";
				}else if(status==AdminLoginStatus.PASSWORD_INCORRECT) {
					result = "Password is wrong";
				}else{
					result = AdminLoginStatus.FAILED.toString();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "FAILED";
		}
		
		return result; 
	}
}
