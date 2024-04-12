package in.ineuron.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ineuron.service.ContactService;
import in.ineuron.service.factory.ContactServiceFactory;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
		ContactService contactService = ContactServiceFactory.getContactService();
		String result = contactService.saveContactMessage(name, email, subject, message);
		
		
		HttpSession session = request.getSession();
		if(result.equals("SUCCESS")) {
			session.setAttribute("message", "SUCCESS");
		}else {
			session.setAttribute("message", result);
		}

		response.sendRedirect("contact.jsp");
	}


}
