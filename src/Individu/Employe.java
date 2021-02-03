package Individu;

import java.util.ArrayList;

public class Employe extends Individu{
	private String poste;
	private float salaire;
	private int nombreVente = 0;

	public Employe(String nom, String prenom, String poste, float salaire) {
		super(nom, prenom);
		this.poste = poste;
		this.salaire = salaire;

	}

	public Employe(String poste, float salaire) {
		this.poste = poste;
		this.salaire = salaire;
	}

	@Override
	public String toString() {
		return "Employe{" +
				"poste='" + poste + '\'' +
				", salaire=" + salaire +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				'}';
	}

	public Employe() {
		ArrayList<Employe> employes = new ArrayList<Employe>();

		employes.add(new Employe("Karl", "Smith", "manege", 1250f));
		employes.add(new Employe("John", "Rachid", "cuisine", 1250f));
		employes.add(new Employe("Thomas", "Muller", "caisse", 1250f));
		employes.add(new Employe("Will", "Cameron", "maintenance", 1250f));
		employes.add(new Employe("Axelis", "Keller", "manager", 1250f));
		employes.add(new Employe("Mouna", "Litchi", "cuisine", 1250f));
		employes.add(new Employe("Conquérant", "Marc", "maintenance", 1250f));
		employes.add(new Employe("Chariqmatique", "John", "reservation", 1250f));
		employes.add(new Employe("Guerrier", "Kevin", "reservation", 1250f));
		employes.add(new Employe("Michael", "Jordan", "cuisine", 1250f));
		employes.add(new Employe("Domingues", "Cedric", "manege", 1250f));
		employes.add(new Employe("Da-Silva", "Silvana", "manege", 1250f));
		employes.add(new Employe("Oups", "Samantha", "manege", 1250f));
		employes.add(new Employe("Debbouz", "Jamel", "manege", 1250f));
		employes.add(new Employe("El Maleh", "Gad", "manege", 1250f));
		employes.add(new Employe("Charlie", "Damido", "reservation", 1149f));
		employes.add(new Employe("Doug", "Ezperanza", "cuisine", 1290f));
		employes.add(new Employe("Pascal", "Dupont", "manege", 1550f));
		employes.add(new Employe("Thierry", "L'hermitte", "reservation", 1250f));
		employes.add(new Employe("Matéo", "Ducoin", "caisse", 1280f));
		employes.add(new Employe("Pricillia", "Brille", "caisse", 1450f));
		employes.add(new Employe("Sean", "Nord", "caisse", 1180f));
		employes.add(new Employe("Naruto", "Uzumaki", "manager", 2090f));
		employes.add(new Employe("Sasuke", "Uchiha", "manager", 2001f));
		employes.add(new Employe("Sakura", "Haruno", "accueil", 1890f));
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	public int getNombreVente() {
		return nombreVente;
	}

	public void setNombreVente(int nombreVente) {
		this.nombreVente = nombreVente;
	}
}
