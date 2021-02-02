package Individu;

public class Individu {
	protected String nom;
	protected String prenom;
	
	public Individu(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public Individu() {
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return this.nom;
    }
}