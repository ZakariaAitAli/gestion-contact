package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.IContactDoa;
import beans.SingletonConnection;
import beans.Contact;

public class ContactDaoImpl implements IContactDoa {

	@Override
	public Contact save(Contact c) {
	     Connection connection=SingletonConnection.getConnection();
	     try {
			PreparedStatement ps=connection.prepareStatement
					 ("INSERT INTO CONTACTS (NOM, PRENOM, NUMEROTELE) VALUES(?,?,?)");
			
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getNumeroTele());
			ps.executeUpdate();
			PreparedStatement ps2=connection.prepareStatement
					("SELECT MAX(ID) AS MAX_ID FROM CONTACTS");
			ResultSet rs=ps2.executeQuery();
			if(rs.next()) {
				c.setId(rs.getLong("MAX_ID"));
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     return c;
	}

	@Override
	public List<Contact> contactsParMC(String mc) {
		List <Contact> contacts=new ArrayList<Contact>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("SELECT * FROM CONTACTS WHERE NOM LIKE ?");
			ps.setString(1, mc);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Contact c=new Contact();
				c.setId(rs.getLong("ID"));
				c.setNom(rs.getString("NOM"));
				c.setPrenom(rs.getString("PRENOM"));
				c.setNumeroTele(rs.getString("NUMEROTELE"));
				contacts.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contacts;
	}

	@Override
	public Contact getContact(Long id) {
		Contact c=null;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("SELECT * FROM CONTACTS WHERE ID LIKE ?");
			ps.setLong(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				 c=new Contact();
				c.setId(rs.getLong("ID"));
				c.setNom(rs.getString("NOM"));
				c.setPrenom(rs.getString("PRENOM"));
				c.setNumeroTele(rs.getString("NUMEROTELE"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	

	@Override
	public Contact update(Contact c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteContact(Long id) {
		Connection connection=SingletonConnection.getConnection();
	     try {
			PreparedStatement ps=connection.prepareStatement
					 ("DELETE FROM CONTACTS WHERE ID=?");
			
			ps.setLong(1, id);

			ps.executeUpdate();
			ps.close();
	     }catch (SQLException e) {
	    	 e.printStackTrace();
	     }
	}

}

