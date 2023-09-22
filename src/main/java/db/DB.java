package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.User;

public class DB {
	public DB() {
		
	}
	
	Connection connexion = null;
	
	public  void insert( User user) {
		String username =user.getUsername() ;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}

		try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion-contact", "root", "");
			System.out.println("Connexion reussite ") ;
			PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO user (username) VALUES (?)");
			preparedStatement.setString(1, username);
			preparedStatement.executeUpdate();

		}catch (SQLException e) {
			System.out.println(e);
		}

	}
}

