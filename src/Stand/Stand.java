package Stand;

import Individu.Equipe;

public class Stand {
	public String nom_stand;
	public String type_stand;
	public String localisation;
	private Equipe equipes;
	
	public Stand(String nom_stand, String type_stand, String localisation, Equipe equipes) {
		super();
		this.nom_stand = nom_stand;
		this.type_stand = type_stand;
		this.localisation = localisation;
		this.equipes = equipes;
	}

	public Stand() {
		super();
	}
}