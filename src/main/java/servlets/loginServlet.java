package servlets;


import beans.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;


@WebServlet("/loginServlet" )
public class loginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String uemail= request.getParameter("email");
    String upwd = request.getParameter("password");
    HttpSession session = request.getSession();
    RequestDispatcher dispatcher =null;

    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/house_location","root","");
        PreparedStatement pst = con.prepareStatement("select * from users where email= ? and password =?");
        pst.setString(1, uemail);
        pst.setString(2, upwd);
       ResultSet rs = pst.executeQuery();
       if(rs.next()){
          session.setAttribute("email",rs.getString("email"));
           session.setAttribute("user_id",rs.getInt("user_id"));
           System.out.println("userrrr" + session.getAttribute("user_id") );
           response.sendRedirect(request.getContextPath()+"/index.jsp");
           User user= new User();
           user.setUsername(rs.getString("username"));
           user.setEmail(rs.getString("email"));


       }
       else {
           request.setAttribute("status","failed");
           dispatcher = request.getRequestDispatcher("login.jsp");
           dispatcher.forward(request, response);

       }

    }catch (Exception e){
        e.printStackTrace();
    }



    }
}