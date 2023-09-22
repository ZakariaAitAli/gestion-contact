package servlets;

import beans.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



@WebServlet("/signupServlet")

public class signupServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = request.getParameter("username");
        String uemail= request.getParameter("email");
        String upass = request.getParameter("password");
        RequestDispatcher dispatcher =null ;
        Connection con = null;
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/house_location","root","");
            PreparedStatement pst = con.prepareStatement("insert into users ( username, email, password) values (?,?,?);");
            pst.setString(1,username);
            pst.setString(2,uemail);
            pst.setString(3,upass);
            int rowCount = pst.executeUpdate();
            if(rowCount>0){
                request.setAttribute("status","success");
                response.sendRedirect(request.getContextPath() + "/index.jsp");

            }
            else {
                request.setAttribute("status","failed");
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
