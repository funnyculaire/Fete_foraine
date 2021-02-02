package Individu;

public class Employe extends Individu{
	private String poste;
	private float salaire;
	private static int nombreVente = 0;

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