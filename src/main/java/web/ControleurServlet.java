package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import beans.ContactDaoImpl;
import beans.IContactDoa;
import beans.Contact;

public class ControleurServlet  extends HttpServlet{

	private static final long serialVersionUID = 1L;
		private IContactDoa metier;
         
         @Override
        public void init() throws ServletException {
       metier = new ContactDaoImpl();
        }
         
         @Override
        protected void doGet(HttpServletRequest request, 
        		HttpServletResponse response) throws ServletException, IOException {
        	 
        	String path=request.getServletPath();
        	if(path.equals("/index.do")) {
        		 request.getRequestDispatcher("contacts.jsp").forward(request, response);
        	}
        	else if(path.equals("/chercher.do")) {
        		String motCle=request.getParameter("motCle");
        		ContactModel model=new ContactModel();
        		model.setMotCle(motCle);
        		List<Contact> contacts= metier.contactsParMC("%"+motCle+"%");
        		model.setContacts(contacts);
        		request.setAttribute("model", model);
        		request.getRequestDispatcher("contacts.jsp").forward(request, response);
        	}
        	else if(path.equals("/Saisie.do")) {
        	request.getRequestDispatcher("SaisieContact.jsp").forward(request, response);
        	}
        	else if(path.equals("/SaveContact.do")&&(request.getMethod().equals("POST"))) {
               String nom=request.getParameter("nom");
               String prenom=request.getParameter("prenom");
               String numeroTele=request.getParameter("numeroTele");
        	   Contact c=metier.save(new Contact(nom, prenom, numeroTele));
        	   request.setAttribute("contact", c);
        	   request.getRequestDispatcher("Confirmation.jsp").forward(request, response);
        	}
        	
        	else if(path.equals("/Supprime.do")) {
        		Long id=Long.parseLong(request.getParameter("id"));
        		metier.deleteContact(id);
        		response.sendRedirect("chercher.do?motCle=");
        	}
        	else if(path.equals("/Edit.do")) {
        		Long id=Long.parseLong(request.getParameter("id"));
        		Contact c=metier.getContact(id);
        		request.setAttribute("contact", c);
        		request.getRequestDispatcher("EditContact.jsp").forward(request, response);
        	}
        	
        }
         
         @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
        }
}
