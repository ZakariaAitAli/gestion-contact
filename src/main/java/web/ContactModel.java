package web;

import java.util.ArrayList;
import java.util.List;

import beans.Contact;

public class ContactModel {

	private String motCle;
	private List<Contact> contacts=new ArrayList<Contact>();
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	public ContactModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContactModel(String motCle, List<Contact> contacts) {
		super();
		this.motCle = motCle;
		this.contacts = contacts;
	}
	
	
}
