package Individu;

import java.util.ArrayList;
import Item.Produit;
import Item.Service;
import fete_forraine.IAction;

public class Visiteur extends Individu implements IAction{ 
	private int age;
	private float taille;
	private float poids;
	private boolean invalide;
	private boolean vip;
	
	private ArrayList<Service> services;

	public Visiteur(int age, float taille, float poids, boolean invalide, boolean vip) {
		super();
		this.age = age;
		this.taille = taille;
		this.poids = poids;
		this.invalide = invalide;
		this.vip = vip;
		this.services = new ArrayList<Service>();
	}
	
	public Visiteur() {

	}

	public void setVisiteur(int age, float taille, float poids, boolean invalide, boolean vip) {
		this.age = age;
		this.taille = taille; 
		this.poids = poids;
		this.invalide = invalide;
		this.vip = vip;
	}

	@Override
	public String toString() {
		return "Visiteur [age=" + age + ", taille=" + taille + ", poids=" + poids + ", invalide=" + invalide + ", vip="
				+ vip + ", services=" + services + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getTaille() {
		return taille;
	}

	public void setTaille(float taille) {
		this.taille = taille;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	public boolean isInvalide() {
		return invalide;
	}

	public void setInvalide(boolean invalide) {
		this.invalide = invalide;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	public ArrayList<Service> getServices() {
		return services;
	}

	public void setServices(ArrayList<Service> services) {
		this.services = services;
	}

	@Override
	public void acheter(Service service) {
		this.services.add(service);
		
	}
}