package Stand;

import java.util.ArrayList;

import Individu.Equipe;
import Item.Produit;
import Item.Service;

public class Restaurant extends Stand{
	public Restaurant(String nom_stand, String type_stand, String localisation, Equipe equipes) {
		super(nom_stand, type_stand, localisation, equipes);

	}

	public Restaurant(String nom_stand, String type_stand, String localisation, Equipe equipes, String type_restaurant, ArrayList<Produit> plats) {
		super(nom_stand, type_stand, localisation, equipes);
		this.type_restaurant = type_restaurant;
		this.produits = plats;
	}

	public ArrayList<Produit> getProduits() {
		return produits;
	}

	public void setProduits(ArrayList<Produit> produits) {
		this.produits = produits;
	}

	public String getType_restaurant() {
		return type_restaurant;
	}

	public void setType_restaurant(String type_restaurant) {
		this.type_restaurant = type_restaurant;
	}

	String type_restaurant;
	
	private ArrayList<Produit> produits;
}