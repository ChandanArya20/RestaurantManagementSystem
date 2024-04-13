package in.ineuron.validation;

public class AdminLoginValidation {

	public String validate(String username, String password) {
		
		String result;
		
		if (username == null || username.isBlank()) { // username validation
			result = "Username is required";

		} else if (username.length() < 3 || username.length() > 30) {
			result = "Username should be between 3 and 20 characters in length";

		} else if (password == null || password.isBlank()) { // password validation
			result = "Password is required";

		} else if (password.length() < 8 || username.length() > 30) {
			result = "Password should be between 8 and 30 characters in length";
			
		}else {
			result="VALID";
		}
		
		return result;
	}
}
