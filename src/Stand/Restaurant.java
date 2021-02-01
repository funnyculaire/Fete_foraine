package Stand;

import java.util.ArrayList;

import Individu.Equipe;
import Item.Produit;
import Item.Service;

public class Restaurant extends Stand{
	public Restaurant(String nom_stand, String type_stand, String localisation, Equipe equipes) {
		super(nom_stand, type_stand, localisation, equipes);
		// TODO Auto-generated constructor stub
	}

	String type_restaurant;
	
	private ArrayList<Produit> produits;
}