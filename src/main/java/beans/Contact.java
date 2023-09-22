package beans;

public class Contact {

		private int id;
		private String nom;
		private String prenom;
		private String NumeroTele;
		public Contact() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Contact(int id, String nom, String prenom, String numeroTele) {
			super();
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
			NumeroTele = numeroTele;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public String getNumeroTele() {
			return NumeroTele;
		}
		public void setNumeroTele(String numeroTele) {
			NumeroTele = numeroTele;
		}
		

}
