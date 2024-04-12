package in.ineuron.service.impl;

import in.ineuron.dao.ContactDao;
import in.ineuron.dao.factory.ContactDaoFactory;
import in.ineuron.service.ContactService;
import in.ineuron.validation.ContactValidation;

public class ContactServiceImpl implements ContactService {

	@Override
	public String saveContactMessage(String name, String email, String subject, String message) {
		
		String result;
		try {
			ContactValidation validation = new ContactValidation();
			result = validation.validate(name, email, subject, message);
			
			if(result.equals("VALID")) {
				ContactDao contactDao = ContactDaoFactory.getContactDao();
				result = contactDao.saveContactMessageToDB(name, email, subject, message);
				
				if(result.equals("SAVED")) {
					result="SUCCESS";
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "FAILED";
		}
		
		return result; 
	}


}
