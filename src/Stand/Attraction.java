package Stand;

import java.util.ArrayList;

import Individu.Equipe;
import Individu.Visiteur;
import Item.Cadeau;

public class Attraction extends Stand{
	
	int age;
	float taille;
	float poids;
	int niveau;
	
	
	public Attraction(String nom_stand, String type_stand, String localisation, Equipe equipes, int age, float taille, float poids, int niveau) {
		super(nom_stand, type_stand, localisation, equipes);
		// TODO Auto-generated constructor stub
		this.age = age;
		this.taille = taille;
		this.poids = poids;
		this.niveau = niveau;
	}

	public Attraction() {
		// TODO Auto-generated constructor stub
	}

	public boolean authorisation(Visiteur visiteur){
		return age == visiteur.getAge() && taille == visiteur.getTaille() && poids == visiteur.getPoids();
	}
	
	private ArrayList<Cadeau> cadeaux;
}