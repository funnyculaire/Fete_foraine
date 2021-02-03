package Stand;

import java.util.ArrayList;

import Individu.Equipe;
import Item.Goodies;
import Item.Produit;

public class Boutique extends Stand{
	
	public Boutique(String nom_stand, String type_stand, String localisation, Equipe equipes, ArrayList<Produit> produits) {
		super(nom_stand, type_stand, localisation, equipes);
		this.produits = produits;
		initProduct();
	}

	public ArrayList<Produit> getProduits() {
		return produits;
	}

	public void setProduits(ArrayList<Produit> produits) {
		this.produits = produits;
	}

	private ArrayList<Produit> produits;

	public void initProduct (){
		for (Goodies goodie : Goodies.values()){
			Produit produit = new Produit(goodie.name(), 5f, "", goodie );
			this.produits.add(produit);
 		}
	}
}
