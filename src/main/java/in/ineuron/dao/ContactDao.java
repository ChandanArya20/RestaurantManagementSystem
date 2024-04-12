package in.ineuron.dao;

public interface ContactDao {
	
	public String saveContactMessageToDB(String name, String email, String subject, String message);

}
