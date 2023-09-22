package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Contact;

public class DB {
    public DB() {
    }

    private Connection connection = null;

    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_contact", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public void close() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertContact(Contact contact) {
        connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO CONTACTS (NOM, PRENOM, NUMEROTELE) VALUES(?,?,?)");
            preparedStatement.setString(1, contact.getNom());
            preparedStatement.setString(2, contact.getPrenom());
            preparedStatement.setString(3, contact.getNumeroTele());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public List<Contact> displayContacts() {
        connect();
        List<Contact> contacts = new ArrayList<Contact>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM contacts");
            while (resultSet.next()) {
                Contact contact = new Contact();
                contact.setId(resultSet.getInt("id"));
                contact.setNom(resultSet.getString("nom"));
                contact.setPrenom(resultSet.getString("prenom"));
                contact.setNumeroTele(resultSet.getString("numeroTele"));
                contacts.add(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return contacts;
    }

    public void updateNumTel(String ID_contact, String num) {
        connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE contacts SET numeroTele=? WHERE id =?");
            preparedStatement.setString(1, num);
            preparedStatement.setString(2, ID_contact); 
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void removeContact(int ID_contact) {
        connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM contacts WHERE id=?");
            preparedStatement.setInt(1, ID_contact);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
}