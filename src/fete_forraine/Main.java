package fete_forraine;

import Individu.Employe;
import Individu.Equipe;
import Individu.Visiteur;
import Item.Cadeau;
import Item.Produit;
import Item.Service;
import Stand.Attraction;
import Stand.Boutique;
import Stand.Restaurant;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Produit> produits = new ArrayList<Produit>();
		ArrayList<Produit> plats = new ArrayList<Produit>();
		ArrayList<Employe> employes = new ArrayList<Employe>();
		ArrayList<Cadeau> cadeaux = new ArrayList<Cadeau>();
		for(int i = 0; i<3; i++){
			employes.add(new Employe("Karl", "Smith"+i, "manege", 1250f));
			produits.add(new Produit("peluche"+i, 7.5f, "jouet"));
			cadeaux.add(new Cadeau("PS5", 0f));
			plats.add(new Produit("pate carbo", 7.5f, "pasta"));
		}
		Equipe equipe = new Equipe("Delta", employes.get(0), "Accueil", true, employes);
		Attraction attraction = new Attraction("Smash", "", "nord-est", equipe, 10, 130f, 40, 3, cadeaux);
		Visiteur visiteur = new Visiteur(8, 160.0f, 40f, true, true, "Messaci", "Nacim");
		System.out.println(visiteur.toString());

		Boutique boutique = new Boutique("Goodies", "", "nord-ouest", equipe, produits);
		Restaurant restaurant = new Restaurant("Mcdo","", "sud-est", equipe, "fast-food", plats);

		visiteur.acheter(produits.get(0), equipe, boutique);

		System.out.println(boutique.getHistorique().toString());

		if(!attraction.authorisation(visiteur)) System.out.println("Le visiteur n'est pas autorisé");
		else System.out.println("Le visiteur est autorisé");

		Employe meilleurEmploye =  new Employe();

		for(Employe employe : employes)

	}
}