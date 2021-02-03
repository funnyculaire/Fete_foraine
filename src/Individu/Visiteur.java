package Individu;

import java.util.ArrayList;
import Item.Produit;
import Item.Service;
import Stand.Stand;
import fete_forraine.IAction;

import java.util.Date;
import java.util.Random;

public class Visiteur extends Individu implements IAction{ 
	private int age;
	private ArrayList<Service> services;

	public Visiteur(int age, String nom, String prenom) {
		super(nom, prenom);
		this.age = age;
		this.services = new ArrayList<Service>();
	}
	
	public Visiteur() {
		this.services = new ArrayList<Service>();
	}

	public void setVisiteur(int age, float taille, float poids, boolean invalide, boolean vip) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Visiteur [age=" + age
				+ ", services=" + services + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<Service> getServices() {
		return services;
	}

	public void setServices(ArrayList<Service> services) {
		this.services = services;
	}

	@Override
	public void acheter(Service service, Equipe equipe, Stand stand) {
		ArrayList<Employe> employes = equipe.getEmploye();
		int nombreEmploye = employes.size();
		Random random = new Random();
		int chiffreEmploye = random.nextInt(nombreEmploye);

		int nombreDeVenteEmploye = employes.get(chiffreEmploye).getNombreVente();
		employes.get(chiffreEmploye).setNombreVente(nombreDeVenteEmploye+1);
		stand.majHistorique(employes.get(chiffreEmploye), this, service);
		System.out.println(service.toString());
		this.services.add(service);
		System.out.println("Vous avez acheté : "+service.getNom());

	}
}
