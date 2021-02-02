package Stand;

import java.util.ArrayList;
import java.util.Date;

import Individu.Employe;
import Individu.Equipe;
import Individu.Visiteur;
import Item.Cadeau;
import Item.Produit;
import Item.Service;

public class Attraction extends Stand{
	
	int age;
	float taille;
	float poids;
	int niveau;
	
	
	public Attraction(String nom_stand, String type_stand, String localisation, Equipe equipes, int age, float taille, float poids, int niveau, ArrayList<Cadeau> cadeaux) {
		super(nom_stand, type_stand, localisation, equipes);
		// TODO Auto-generated constructor stub
		this.age = age;
		this.taille = taille;
		this.poids = poids;
		this.niveau = niveau;
		this.cadeaux = cadeaux;
	}

	public Attraction() {
		this.cadeaux = new ArrayList<Cadeau>();
	}

	public boolean authorisation(Visiteur visiteur){
		return age == visiteur.getAge() && taille == visiteur.getTaille() && poids == visiteur.getPoids();
	}
	
	private ArrayList<Cadeau> cadeaux;

	@Override
	public void majHistorique(Employe employe, Visiteur visiteur, Service service) {


		historique.add("L'employe : "+employe.getNom()+" "+employe.getPrenom()+" a offert"+service.getNom());
	}
}