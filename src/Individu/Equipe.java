package Individu;

import java.util.ArrayList;

public class Equipe {
	String nom_equipe;
	Employe chef_equipe;
	String missions;
	Boolean jour;
	private ArrayList<Employe> employe;

	public Equipe(String nom_equipe, Employe chef_equipe, String missions, Boolean jour, ArrayList<Employe> employe) {
		this.nom_equipe = nom_equipe;
		this.chef_equipe = chef_equipe;
		this.missions = missions;
		this.jour = jour;
		this.employe = employe;
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
		return employe;
	}

	public void setEmploye(ArrayList<Employe> employe) {
		this.employe = employe;
	}


}