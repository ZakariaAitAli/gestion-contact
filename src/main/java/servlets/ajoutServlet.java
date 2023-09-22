package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Contact;
import db.DB;

@WebServlet("/ajoutServlet")
public class ajoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: " );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 DB db = new DB() ;
		 String nom = request.getParameter("nom");
		 String prenom = request.getParameter("prenom");
		 String numeroTele = request.getParameter("numeroTele");
		 Contact c = new Contact();
		 c.setNom(nom);
		 c.setPrenom(prenom);
		 c.setNumeroTele(numeroTele);
		 db.insertContact(c);
		 
		 response.sendRedirect("indexServlet");
	}
}
