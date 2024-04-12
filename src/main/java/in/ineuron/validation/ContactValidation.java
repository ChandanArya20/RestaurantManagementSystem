package in.ineuron.validation;

public class ContactValidation {

	private String result;

	public String validate(String name, String email, String subject, String message) {

		if (name == null || name.isBlank()) { // name validation
			result = "Name is required";

		} else if (name.length() < 3 || name.length() > 30) {
			result = "Name should be between 3 and 30 characters in length";

		} else if (email == null || email.isBlank()) { // email validation
			result = "Email is required";

		} else if (!EmailValidator.isValidEmail(email)) {
			result = "Invalid email";
		} else if (subject == null || subject.isBlank()) { // subject validation
			result = "Subject is required";

		} else if (subject.length() < 3 || subject.length() > 30) {
			result = "Subject should be between 3 and 30 characters in length";
		} else if (message == null || message.isBlank()) { // message validation
			result = "Message is required";

		} else if (message.length() < 3) {
			result = "Message length should be greater than 3";
		} else {
			result="VALID";
		}

		return result;
	}

}
