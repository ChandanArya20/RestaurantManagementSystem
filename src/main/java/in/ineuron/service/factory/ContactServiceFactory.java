package in.ineuron.service.factory;

import in.ineuron.service.ContactService;
import in.ineuron.service.impl.ContactServiceImpl;

public class ContactServiceFactory {
	
	private static ContactService contactService;

	private ContactServiceFactory() {
		
	}
	
	public static ContactService getContactService() {
		if(contactService==null) {
			contactService = new ContactServiceImpl();
		}
		
		return contactService;
	}
	
	

}
