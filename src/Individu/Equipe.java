package Individu;

import Item.Cadeau;
import Item.Goodies;
import Item.Produit;
import Item.Snacks;
import Stand.Attraction;
import Stand.Boutique;
import Stand.Restaurant;

import java.util.ArrayList;

public class Equipe {
	String nom_equipe;
	Employe chef_equipe;
	String missions;
	Boolean jour;
	private ArrayList<Employe> employes;

	public Equipe(String nom_equipe, Employe chef_equipe, String missions, Boolean jour, ArrayList<Employe> employe) {
		this.nom_equipe = nom_equipe;
		this.chef_equipe = chef_equipe;
		this.missions = missions;
		this.jour = jour;
		this.employes = employe;
	}

    public Equipe() {

    }

    public Employe meilleurEmploye(){


		Employe meilleurEmploye =  new Employe();

		for(Employe employe : employes){
			int max1 = meilleurEmploye.getNombreVente();
			int max2 = employe.getNombreVente();
			int value = Math.max(max1, max2);
			if(value == max2) meilleurEmploye = employe;
		}

		return meilleurEmploye;
	}



	public String getNom_equipe() {
		return nom_equipe;
	}

	public void setNom_equipe(String nom_equipe) {
		this.nom_equipe = nom_equipe;
	}

	public Employe getChef_equipe() {
		return chef_equipe;
	}

	public void setChef_equipe(Employe chef_equipe) {
		this.chef_equipe = chef_equipe;
	}

	public String getMissions() {
		return missions;
	}

	public void setMissions(String missions) {
		this.missions = missions;
	}

	public Boolean getJour() {
		return jour;
	}

	public void setJour(Boolean jour) {
		this.jour = jour;
	}

	public ArrayList<Employe> getEmploye() {
		return employes;
	}

	public void setEmploye(ArrayList<Employe> employes) {
		this.employes = employes;
	}


}
