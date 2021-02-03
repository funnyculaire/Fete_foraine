package Stand;

import Individu.Employe;
import Individu.Equipe;
import Individu.Visiteur;
import Item.Produit;
import Item.Service;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Stand {
	public String nom_stand;
	public String type_stand;
	public String localisation;
	private Equipe equipes;
	protected ArrayList<String> historique;

	public ArrayList<String> getHistorique() {
		return historique;
	}

	public void setHistorique(ArrayList<String> historique) {
		this.historique = historique;
	}

	public Stand(String nom_stand, String type_stand, String localisation, Equipe equipes) {
		super();
		this.nom_stand = nom_stand;
		this.type_stand = type_stand;
		this.localisation = localisation;
		this.equipes = equipes;
		this.historique = new ArrayList<String>();
	}

	public Equipe getEquipes() {
		return equipes;
	}

	public Stand() {
		super();
	}

	public void majHistorique(Employe employe, Visiteur visiteur, Service service){
		historique.add("L'employe : "+employe.getNom()+" "+employe.getPrenom()+" a vendu "+service.getNom()+
				" au prix de"+service.getPrix());
	}
}
