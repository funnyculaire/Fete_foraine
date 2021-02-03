package fete_forraine;

import Individu.Employe;
import Individu.Equipe;
import Individu.Individu;
import Individu.Visiteur;
import Item.*;
import Stand.Attraction;
import Stand.Boutique;
import Stand.Restaurant;
import percistence.FileReaderParser;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	final static String path = "src/percistence/data";
	final static String pathAdmin = "src/percistence/admin.ser";

	final static int ADMIN = 1;
	final static int VISITEUR = 2;

	final static int RESERVATION = 1;
	final static int ACHAT = 2;

	final static int BOUTIQUE = 1;
	final static int RESTAURATION = 2;

	public static void dataReader(){
		FileReaderParser fileReaderParser = new FileReaderParser();
		ArrayList<String> resultat = new ArrayList<String>();
		resultat = fileReaderParser.fileReader(path);

		System.out.printf(resultat.toString());

	}

	public static void dataWriter(Reservation reservation, Individu individu, String path){
		FileReaderParser fileReaderParser = new FileReaderParser();
		//ArrayList<String> resultat = new ArrayList<String>();
		fileReaderParser.fileWriter(reservation, individu, path);

	}

	public static int getUserChoix(int state){
		int choix = 0;

		if (state == 1){
			//Premier appel
			Scanner scanner = new Scanner(System.in);  // Create a Scanner object
			System.out.println("---- FETE FORAINE-------");
			System.out.println("1. ADMIN\n2. VISITEUR ");

			do{
				System.out.println("Votre choix : ");
				choix = scanner.nextInt();
				System.out.println(choix);
				if(choix != 1 && choix !=2 ){
					System.out.println("choix invalide ! veuillez recommencer svp ");
				}
			}while(choix != 1 && choix !=2);

			return choix;

		}
		else if(state == 2){

			//Second appel
			Scanner scanner = new Scanner(System.in);  // Create a Scanner object
			System.out.println("---- ESPACE VISITEUR-------");
			System.out.println("1. RESERVATION\n2. ACHAT ");

			do{
				System.out.println("Votre choix : ");
				choix = scanner.nextInt();
				System.out.println(choix);
				if(choix != 1 && choix !=2 ){
					System.out.println("choix invalide ! veuillez recommencer svp ");
				}
			}while(choix != 1 && choix !=2);

			return choix;
		}
		else if(state == 3){
			//Premier appel
			Scanner scanner = new Scanner(System.in);  // Create a Scanner object
			System.out.println("---- ESPACE STAND-------");
			System.out.println("1. BOUTIQUE\n2. RESTAURATION ");

			do{
				System.out.println("Votre choix : ");
				choix = scanner.nextInt();
				System.out.println(choix);
				if(choix != 1 && choix !=2 ){
					System.out.println("choix invalide ! veuillez recommencer svp ");
				}
			}while(choix != 1 && choix !=2);

			return choix;
		}
		else if(state == 4){
			//Premier appel
			Scanner scanner = new Scanner(System.in);  // Create a Scanner object
			System.out.println("---- ESPACE ADMIN-------");
			System.out.println("1. AFFICHAGE ÉQUIPE\n2. AFFICHAGE EMPLOYÉ\n3. AFFICHAGE RÉSERVATION ");

			do{
				System.out.println("Votre choix : ");
				choix = scanner.nextInt();
				System.out.println(choix);
				if(choix != 1 && choix !=2 ){
					System.out.println("choix invalide ! veuillez recommencer svp ");
				}
			}while(choix != 1 && choix !=2 && choix != 3);

			return choix;
		}
		else if(state == 5){
			//Premier appel
			Scanner scanner = new Scanner(System.in);  // Create a Scanner object
			System.out.println("EMPLOYÉ DU MOIS ?");

			do{
				System.out.println("Votre choix : ");
				choix = scanner.nextInt();
				System.out.println(choix);
				if(choix != 1 && choix !=2 ){
					System.out.println("choix invalide ! veuillez recommencer svp ");
				}
			}while(choix != 1 && choix !=2);

			return choix;
		}
		else{
			return 1;
		}

	}



	public static Tarification getTarification(){
		Tarification choix = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Voici les types de tarification ");
		int i =  1;
		for( Tarification tarification : Tarification.values()){
			System.out.println(i+ ". "+tarification);
			i++;
		}


		int type_tarification = scanner.nextInt();

		switch (type_tarification){

			case 1 :
				choix = Tarification.ENFANT;
				break;

			case 2:
				choix = Tarification.ETUDIANT;
				break;

			case 3:
				choix = Tarification.FAMILLE_NOMBREUSE;
				break;

			case 4:
				choix = Tarification.GROUPE5;
				break;

			case 5:
				choix = Tarification.GROUPE10;
				break;

			case 6:
				choix = Tarification.NORMAL;
				break;

			case 7:
				choix = Tarification.SENIOR;
				break;

		}

		return  choix;
	}
	public static int saveReservation(){

		Scanner scanner = new Scanner(System.in);

		System.out.print("Votre nom : ");
		String nom = scanner.nextLine();
		System.out.println();

		System.out.print("Votre prénom : ");
		String prenom = scanner.nextLine();
		System.out.println();


		Tarification tarification = getTarification();

		System.out.println("Votre choix : " + tarification);

		FileReaderParser fileReaderParser = new FileReaderParser();
		int actualNumberOfReservation = fileReaderParser.numberOfReservation(path);

		Reservation reservation = new Reservation(actualNumberOfReservation, tarification);//Data
		Individu individu = new Individu(nom,prenom);

		fileReaderParser.fileWriter(reservation, individu, path);

		return actualNumberOfReservation;
	}

	public static Goodies getGoodies(){
		Goodies choix = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Voici les types de Goodies ");
		int i =  1;
		for( Goodies goodie : Goodies.values()){
			System.out.println(i+ ". "+goodie);
			i++;
		}

		System.out.println("Choississez le numero correspondant à votre goodies : ");
		int choixGoodie = scanner.nextInt();

		switch (choixGoodie){

			case 1 :
				choix = Goodies.PELUCHE;
				break;

			case 2:
				choix = Goodies.BALLON;
				break;

			case 3:
				choix = Goodies.FIGURINE;
				break;

			case 4:
				choix = Goodies.DEGUISEMENT;
				break;

			case 5:
				choix = Goodies.ÉPÉE;
				break;

			case 6:
				choix = Goodies.BOUCLIER;
				break;

			case 7:
				choix = Goodies.LIVRE;
				break;

			case 8:
				choix = Goodies.POUPÉE;
				break;

			case 9:
				choix = Goodies.MUG;
				break;

			case 10:
				choix = Goodies.BAGUE;
				break;

		}

		return  choix;
	}

	public static void choiceGoodies(){


		Goodies goodies = getGoodies();

		System.out.println("Votre achat : " + goodies);


	}


	public static Snacks getSnacks(){
		Snacks choix = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Voici les types de Snacks ");
		int i =  1;
		for( Snacks snack : Snacks.values()){
			System.out.println(i+ ". "+snack);
			i++;
		}

		System.out.println("Choississez le numero correspondant à votre snacks : ");
		int choixSnack = scanner.nextInt();

		switch (choixSnack){

			case 1 :
				choix = Snacks.CHURROS;
				break;

			case 2:
				choix = Snacks.GAUFFRE;
				break;

			case 3:
				choix = Snacks.GLACE;
				break;

			case 4:
				choix = Snacks.BARBE_À_PAPA;
				break;

			case 5:
				choix = Snacks.CREPE;
				break;

			case 6:
				choix = Snacks.GRANITÉ;
				break;

			case 7:
				choix = Snacks.BONBONS;
				break;

			case 8:
				choix = Snacks.COCA;
				break;

			case 9:
				choix = Snacks.FANTA;
				break;

			case 10:
				choix = Snacks.OASIS;
				break;

			case 11:
				choix = Snacks.VITTEL;
				break;

			case 12:
				choix = Snacks.CAFÉ;
				break;

			case 13:
				choix = Snacks.THÉ;
				break;

		}

		return  choix;
	}

	public static void choiceSnacks(){

		Snacks snacks = getSnacks();

		System.out.println("Vous achetez ce snacks :" + snacks + "bon apétit ! ");

	}


	public static void mainFunction(){
		int userChoix = getUserChoix(1);


		if(userChoix == VISITEUR) {

			int visiteurChoix = getUserChoix(2);

			if (visiteurChoix == RESERVATION) {
				int clientReservation = saveReservation();

				System.out.println("Votre reservation a bien été enregistrée !\nVotre numéro de reservation est le :");
				FileReaderParser fileReaderParser = new FileReaderParser();
				ArrayList<String> reservations = fileReaderParser.fileReader(path);

				String reservation = reservations.get(clientReservation);
				System.out.println(reservation);


			} else {
				//PARTIE ACHAT

				if (visiteurChoix == ACHAT) {
					visiteurChoix = getUserChoix(3);
					if (visiteurChoix == BOUTIQUE) {
						choiceGoodies();
					} else {
						//PARTIE SNACKS

						visiteurChoix = getUserChoix(4);
						if (visiteurChoix == RESTAURATION) {
							choiceSnacks();
						}
					}
				}

			}
		}
	}



	public static void main(String[] args) {

		//Instance
		//ArrayList<Produit> produits = new ArrayList<Produit>();
		//ArrayList<Produit> plats = new ArrayList<Produit>();
		//ArrayList<Employe> employes = new ArrayList<Employe>();
		//ArrayList<Cadeau> cadeaux = new ArrayList<Cadeau>();


		//Init le tout
		/*for(int i = 0; i<3; i++){
			employes.add(new Employe("Karl", "Smith"+i, "manege", 1250f));
			produits.add(new Produit("peluche"+i, 7.5f, "jouet"));
			cadeaux.add(new Cadeau("PS5", 0f));
			plats.add(new Produit("pate carbo", 7.5f, "pasta"));
		}*/

		//Equipe equipe = new Equipe("Delta", employes.get(0), "Accueil", true, employes);
		//Attraction attraction = new Attraction("Smash", "", "nord-est", equipe, 10, 130f, 40, 3, cadeaux);
		//Visiteur visiteur = new Visiteur(8, 160.0f, 40f, true, true, "Messaci", "Nacim");
		//System.out.println(visiteur.toString());

		//Boutique boutique = new Boutique("Goodies", "", "nord-ouest", equipe, produits);
		//Restaurant restaurant = new Restaurant("Mcdo","", "sud-est", equipe, "fast-food", plats);

		//visiteur.acheter(produits.get(0), equipe, boutique);

		//System.out.println(boutique.getHistorique().toString());

		//Check pour la validité
		//if(!attraction.authorisation(visiteur)) System.out.println("Le visiteur n'est pas autorisé");
		//else System.out.println("Le visiteur est autorisé");

		//System.out.println(equipe.meilleurEmploye().toString());

		//dataReader();
		//FileReaderParser fileReaderParser = new FileReaderParser();

		//int numeroDeReservation = fileReaderParser.numberOfReservation(path);
		//System.out.println("Numero de reservation : " + numeroDeReservation);
		//Reservation reservation = new Reservation(numeroDeReservation, Tarification.ETUDIANT);
		//dataWriter(reservation, visiteur, path);



		mainFunction();

		//fileReaderParser.writeToJson();
		//fileReaderParser.readAdminData(pathAdmin);


	}
}
