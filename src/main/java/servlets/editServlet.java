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

/**
 * Servlet implementation class indexServlet
 */
@WebServlet("/editServlet")
public class editServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 DB db = new DB() ;
//		 List<Contact> contacts= db.displayContacts();
//		 request.setAttribute("contacts", contacts);
// 		 request.getRequestDispatcher("contacts.jsp").forward(request, response);
// 		 
// 		 response.getWriter().append("Served at: " + contacts);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DB db = new DB() ;
		String numeroTele = request.getParameter("numeroTele");
		String id = request.getParameter("id");
		db.updateNumTel(id, numeroTele);
		response.sendRedirect("indexServlet");
		
	}

}
