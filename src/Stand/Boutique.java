package Stand;

import java.util.ArrayList;

import Individu.Equipe;
import Item.Produit;

public class Boutique extends Stand{
	
	public Boutique(String nom_stand, String type_stand, String localisation, Equipe equipes, ArrayList<Produit> produits) {
		super(nom_stand, type_stand, localisation, equipes);
		this.produits = produits;
	}

	public ArrayList<Produit> getProduits() {
		return produits;
	}

	public void setProduits(ArrayList<Produit> produits) {
		this.produits = produits;
	}

	private ArrayList<Produit> produits;

}