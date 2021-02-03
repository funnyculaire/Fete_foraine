package Stand;

import java.util.ArrayList;
import java.util.Date;

import Individu.Employe;
import Individu.Equipe;
import Individu.Visiteur;
import Item.*;

public class Attraction extends Stand{
	
	int age;

	private ArrayList<Cadeau> cadeaux;


	
	
	public Attraction(String nom_stand, String type_stand, String localisation, Equipe equipes, int age, ArrayList<Cadeau> cadeaux) {
		super(nom_stand, type_stand, localisation, equipes);
		// TODO Auto-generated constructor stub
		this.age = age;
		this.cadeaux = cadeaux;

		initProduct();

	}

	public ArrayList<Cadeau> getCadeaux() {
		return cadeaux;
	}

	public Attraction() {
		this.cadeaux = new ArrayList<Cadeau>();
		initProduct();
	}

	public boolean authorisation(Visiteur visiteur){
		return age < visiteur.getAge();
	}


	public void initProduct (){
		for (ListeDeCadeaux item: ListeDeCadeaux.values()){
			Cadeau cadeau = new Cadeau( item.name(), 5f );
			this.cadeaux.add(cadeau);
		}
	}

	@Override
	public void majHistorique(Employe employe, Visiteur visiteur, Service service) {
		historique.add("L'employe : "+employe.getNom()+" "+employe.getPrenom()+" a offert"+service.getNom());
	}
}
