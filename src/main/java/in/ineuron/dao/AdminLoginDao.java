package in.ineuron.dao;

import in.ineuron.returnstatus.AdminLoginStatus;

public interface AdminLoginDao {
	
	public AdminLoginStatus checkAdminLoginData(String username, String password);

}
