package Stand;

import java.util.ArrayList;

import Individu.Equipe;
import Item.Produit;

public class Boutique extends Stand{
	
	public Boutique(String nom_stand, String type_stand, String localisation, Equipe equipes) {
		super(nom_stand, type_stand, localisation, equipes);
		// TODO Auto-generated constructor stub
	}

	private ArrayList<Produit> produits;
}