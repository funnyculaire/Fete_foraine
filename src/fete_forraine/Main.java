package fete_forraine;

import Individu.Employe;
import Individu.Equipe;
import Individu.Individu;
import Individu.Visiteur;
import Item.*;
import Stand.Attraction;
import Stand.Boutique;
import Stand.Restaurant;
import Stand.Stand;
import fete_forraine.Menu;
import fete_forraine.Reservation;
import fete_forraine.Tarification;
import percistence.FileReaderParser;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.*;


public class Main {


	public static void main(String[] args) {

		FileReaderParser fileReaderParser = new FileReaderParser();

		//SET AND INIT EMPLOYES
		ArrayList<Employe> employes = new ArrayList<Employe>();

		employes.addAll(Menu.initEmployeAttraction());
		employes.addAll(Menu.initEmployeBoutique());
		employes.addAll(Menu.initEmployeRestaurant());

		//INIT EQUIPES
		Equipe equipesRestaurant = new Equipe();
		Equipe equipesBoutique = new Equipe();
		Equipe equipesAttraction = new Equipe();

		//SET LIST EMPLOYE
		equipesRestaurant.setEmploye(Menu.initEmployeRestaurant());
		equipesBoutique.setEmploye(Menu.initEmployeBoutique());
		equipesAttraction.setEmploye(Menu.initEmployeAttraction());

		//SET CHEF EQUIPE
		equipesRestaurant.setChef_equipe(equipesRestaurant.getEmploye().get(0));
		equipesBoutique.setChef_equipe(equipesBoutique.getEmploye().get(0));
		equipesAttraction.setChef_equipe(equipesAttraction.getEmploye().get(0));

		///STAND
		Restaurant restaurant = new Restaurant("Chez Tony","","Nord-Est", equipesRestaurant,"",new ArrayList<Produit>());
		Boutique boutique = new Boutique("A la caverne d'Ali Baba","","Nord-Ouest", equipesBoutique,new ArrayList<Produit>());

		//Liste d'attraction
		ArrayList<Attraction> attractions = new ArrayList<Attraction>();
		Attraction attractionPeche = new Attraction("Peche à la ligne ","","Nord-Centre", equipesAttraction,12,new ArrayList<Cadeau>());
		Attraction attractionTireCorde = new Attraction("Tire à la Corde","","Nord-Est", equipesAttraction,12,new ArrayList<Cadeau>());
		Attraction attractionChambouleTout = new Attraction("Chamboule Tout","","Nord-Ouest", equipesAttraction,12,new ArrayList<Cadeau>());
		Attraction attractionTourInfernale = new Attraction("Tour Infernale (Interdit -18)","","Sud-Est", equipesAttraction,18,new ArrayList<Cadeau>());

		attractions.add(attractionPeche);
		attractions.add(attractionTireCorde);
		attractions.add(attractionChambouleTout);
		attractions.add(attractionTourInfernale);

		Menu.mainFunction(restaurant, boutique, attractions, fileReaderParser, employes);
	}
}
