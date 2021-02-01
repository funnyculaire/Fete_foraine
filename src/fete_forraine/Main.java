package fete_forraine;

import Individu.Visiteur;
import Item.Service;
import Stand.Attraction;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		
		Attraction attraction = new Attraction();
		Visiteur visiteur = new Visiteur(); 
		
		ArrayList<Service> services = new ArrayList<Service>();
		visiteur.setVisiteur(15,190.0f,120.0f,true,true,services);
		
		System.out.println(visiteur.toString());
	}
}