package beans;

import java.util.List;

import beans.Contact;

public interface IContactDoa {
	public Contact save(Contact c);/* */
	public List<Contact> contactsParMC(String mc);/* */
	public Contact getContact(Long id);
	public Contact update(Contact c);
	public void deleteContact(Long id);/* */
	

}
