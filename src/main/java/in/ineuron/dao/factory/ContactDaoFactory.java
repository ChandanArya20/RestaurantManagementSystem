package in.ineuron.dao.factory;

import in.ineuron.dao.ContactDao;
import in.ineuron.dao.impl.ContactDaoImpl;

public class ContactDaoFactory {

	private static ContactDao contactDao;

	private ContactDaoFactory() {
		
	}
	
	public static ContactDao getContactDao() {
		if(contactDao==null) {
			contactDao = new ContactDaoImpl();
		}
		
		return contactDao;
	}
	
}
