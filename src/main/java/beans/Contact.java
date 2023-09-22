package beans;

public class Contact {

		private Long id;
		private String nom;
		private String prenom;
		private String NumeroTele;
		public Contact() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Contact(String nom, String prenom, String numeroTele) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			NumeroTele = numeroTele;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
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
