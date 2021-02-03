package fete_forraine;

import Individu.*;
import Item.Cadeau;
import Item.Produit;
import Stand.Attraction;
import Stand.Boutique;
import Stand.Restaurant;
import Stand.Stand;
import percistence.FileReaderParser;

import java.util.*;

public class Menu {

    final static String path = "src/percistence/data";
    final static String pathAdmin = "src/percistence/admin.ser";
    final static String pathEmployeData = "src/percistence/employeData.ser";

    final static int ADMIN = 1;
    final static int VISITEUR = 2;

    final static int RESERVATION = 1;
    final static int STAND = 2;

    final static int BOUTIQUE = 1;
    final static int RESTAURATION = 2;
    final static int ATTRACTION = 3;

    final static int EQUIPE = 1;
    final static int EMPLOYE = 2;
    final static int BESTEMPLOYE = 3 ;
    final static int LISTERESERVATION = 4;




    public static int getUserChoix(int state){
        int choix = 0;

        if (state == 1){
            //FETE FORAINE
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
            System.out.println("1. RESERVATION\n2. STAND");

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
            System.out.println("1. BOUTIQUE\n2. RESTAURATION\n3. ATTRACTION");

            do{
                System.out.println("Votre choix : ");
                choix = scanner.nextInt();
                System.out.println(choix);
                if(choix != 1 && choix !=2  && choix !=3 ){
                    System.out.println("choix invalide ! veuillez recommencer svp ");
                }
            }while(choix != 1 && choix !=2  && choix !=3) ;

            return choix;
        }
        else if(state == 4){
            //Premier appel
            Scanner scanner = new Scanner(System.in);  // Create a Scanner object
            System.out.println("---- ESPACE ADMIN-------");
            System.out.println("1. AFFICHAGE ÉQUIPE\n2. AFFICHAGE EMPLOYÉ\n3. AFFICHAGE MEILLEUR EMPLOYE\n4. AFFICHAGE RÉSERVATION ");

            do{
                System.out.println("Votre choix : ");
                choix = scanner.nextInt();
                System.out.println(choix);
                if(choix != 1 && choix !=2 && choix != 3 && choix != 4  ){
                    System.out.println("choix invalide ! veuillez recommencer svp ");
                }
            }while(choix != 1 && choix !=2 && choix != 3 && choix != 4  );

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

    public static int saveReservation(FileReaderParser fileReaderParser){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Votre nom : ");
        String nom = scanner.nextLine();
        System.out.println();

        System.out.print("Votre prénom : ");
        String prenom = scanner.nextLine();
        System.out.println();


        Tarification tarification = getTarification();

        System.out.println("Votre choix : " + tarification);

        int actualNumberOfReservation = fileReaderParser.numberOfReservation(path);

        Reservation reservation = new Reservation(actualNumberOfReservation, tarification);//Data
        Individu individu = new Individu(nom,prenom);

        fileReaderParser.fileWriterReservation(reservation, individu, path);

        return actualNumberOfReservation;
    }

    public static Produit getGoodies(Boutique boutique){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Voici les types de Goodies ! ");
        int i =  0;
        for( Produit produit : boutique.getProduits()){
            System.out.println(i+ ". "+produit.getNom());
            i++;
        }

        System.out.println("Choississez le numero correspondant à votre goodie : ");
        int choixSnack = scanner.nextInt();

        return boutique.getProduits().get(choixSnack);
    }

    public static void choiceGoodies(Boutique boutique, Visiteur visiteur){

        Produit produitBoutique = getGoodies(boutique);
        visiteur.acheter(produitBoutique, boutique.getEquipes(), boutique);

        System.out.println("Votre achat : " + produitBoutique.getNom());

    }

    public static Cadeau getCadeaux(Attraction attraction){

        int nombreDeCadeaux =  attraction.getCadeaux().size();

        Random random = new Random();
        int cadeauxAleatoire = random.nextInt(nombreDeCadeaux);

        Cadeau cadeau = attraction.getCadeaux().get(cadeauxAleatoire);

        return cadeau ;
    }

    public static Produit getSnacks(Restaurant restaurant){


        Scanner scanner = new Scanner(System.in);
        System.out.println("Voici les types de Snacks ");
        int i =  0;
        for( Produit produit : restaurant.getProduits()){
            System.out.println(i+ ". "+produit.getNom());
            i++;
        }
        System.out.println("Choississez le numero correspondant à votre snacks : ");
        int choixSnack = scanner.nextInt();

        return  restaurant.getProduits().get(choixSnack);
    }

    public static void choiceSnacks(Restaurant restaurant, Visiteur visiteur){

        Produit produitSnack = getSnacks(restaurant);

        visiteur.acheter(produitSnack, restaurant.getEquipes(),restaurant );

        System.out.println("Vous achetez ce snacks :" + produitSnack.getNom()+ "bon apétit ! ");

    }

    public static Attraction choiceAttraction(ArrayList<Attraction> attractions, Visiteur visiteur){

        boolean isOk = false;
        Attraction choixAttraction = new Attraction();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voici les choix d'attraction : ");
        int i =  0;
        for( Attraction attraction : attractions){
            System.out.println(i+ ". "+attraction.getNom_stand());
            i++;
        }

        int choix = -1;
        do{
            while (!isOk){
                choix = scanner.nextInt();
                choixAttraction = attractions.get(choix);
                System.out.println("Vous avez choisis :" + choixAttraction.getNom_stand());
                if(choixAttraction.authorisation(visiteur)){
                    isOk = true;
                }
                else{
                    System.out.println("Vous êtes trop jeunes, choisissez une autre attraction");
                }
            }
        }while (choix > attractions.size());

        return  choixAttraction;


    }

    public  static void initAllEmploye(	ArrayList<Employe> employes){
        employes.addAll(initEmployeAttraction());
        employes.addAll(initEmployeBoutique());
        employes.addAll(initEmployeRestaurant());
    }
    public static void affichageEmploye(ArrayList<Employe> employes){
        System.out.println(employes.toString());
    }

    public static void uiAdmin(Employe employe, Equipe equipe){
        ArrayList<Employe> employes = new ArrayList<>();

        initAllEmploye(employes);
        Integer adminChoix = null;
        do{
            adminChoix = getUserChoix( 4);

            if (adminChoix == EQUIPE){
                afficherEquipe(equipe);
            }
            else if (adminChoix == EMPLOYE){
                affichageEmploye(employes);
            }
            else if ( adminChoix == BESTEMPLOYE){
                affichageBestEmploye(employes);
            }
            else if ( adminChoix == LISTERESERVATION){
                affichageListReservation();
            }else{
                System.out.println("Veuillez selectionner parmis les choix suivant");
            }
        }while (adminChoix != EQUIPE && adminChoix != EMPLOYE && adminChoix != BESTEMPLOYE && adminChoix != LISTERESERVATION );

    }

    private static void affichageListReservation() {
        FileReaderParser fileReaderParser = new FileReaderParser();
        ArrayList<String> dataReservation = fileReaderParser.fileReaderReservation(path);

        System.out.println(dataReservation.toString());
    }

    private static void affichageBestEmploye(ArrayList<Employe> employes) {

        FileReaderParser fileReaderParser = new FileReaderParser();

        HashMap<String, String> employesData = fileReaderParser.readEmployesData(pathEmployeData);

        String nomEmploye = "";
        int max = 0;
        for(Employe employe : employes) {

            Integer data = Integer.parseInt(employesData.get(employe.getNom()));

            System.out.println(data);
            if(data > max){
                System.out.println("OK");
                max = Math.max(max, data);
                nomEmploye = employe.getNom();
            }

        }
        System.out.println("Le meilleur employé est : " + nomEmploye);


    }

    public static void mainFunction(Restaurant restaurant,
                                    Boutique boutique,
                                    ArrayList<Attraction> attractions,
                                    FileReaderParser fileReaderParser,
                                    ArrayList<Employe> employes){

        int userChoix;

        do{
            userChoix = getUserChoix(1);
            if(userChoix == VISITEUR) {

                Visiteur visiteur = initVisiteur();


                int visiteurChoix;
                do{
                    visiteurChoix = getUserChoix(2);
                    if (visiteurChoix == RESERVATION) {
                        int clientReservation = saveReservation(fileReaderParser);

                        System.out.println("Votre reservation a bien été enregistrée !\nVotre numéro de reservation est le :");
                        ArrayList<String> reservations = fileReaderParser.fileReaderReservation(path);

                        String reservation = reservations.get(clientReservation);
                        System.out.println(reservation);

                    }
                    if (visiteurChoix == STAND) {
                        int visiteurChoixStand;
                        do{
                            visiteurChoixStand = getUserChoix(3);
                            switch (visiteurChoixStand){
                                case BOUTIQUE :  choiceGoodies(boutique, visiteur);break;

                                case RESTAURATION : choiceSnacks(restaurant, visiteur); break;

                                case ATTRACTION : {
                                    Attraction attraction = choiceAttraction(attractions,visiteur);
                                    Cadeau cadeau = getCadeaux(attraction);
                                    System.out.println("Felicitation vous avez gagné : " + cadeau.getNom() + "!");
                                    break;
                                }
                            }
                        }while(visiteurChoixStand != BOUTIQUE && visiteurChoixStand != RESTAURATION && visiteurChoixStand != ATTRACTION );

                    }

                }while (visiteurChoix != STAND && visiteurChoix != RESERVATION);


            } else if ( userChoix == ADMIN) {
                System.out.println("Bienvenu dans la section ADMIN");

                HashMap<String, String> hashMap = fileReaderParser.readAdminData(pathAdmin);

                System.out.println("Inserrer votre nom d'utilisateur : ");

                Scanner scanner = new Scanner(System.in);
                String username = scanner.nextLine();

                String password = hashMap.get(username);

                System.out.println("Bienvenu : "+username+"\nInserrer votre mot de passe : ");
                String inputPassword = scanner.nextLine();

                if(inputPassword.equals(password)){
                    System.out.println("Vous êtes connnecté !");

                    Employe employe = findEmploye(username, boutique.getEquipes(), attractions.get(0).getEquipes(), restaurant.getEquipes());
                    Equipe equipe = findEquipe(employe ,boutique.getEquipes(), attractions.get(0).getEquipes(), restaurant.getEquipes());
                    uiAdmin(employe,equipe);

                }
                else{
                    System.out.println("mot de passe incorrecte");
                }
            }
        }while(userChoix!= VISITEUR && userChoix != ADMIN);


        storeData(fileReaderParser, employes);

    }

    private static void storeData(FileReaderParser fileReaderParser, ArrayList<Employe> employes) {
        HashMap<String, String> hashMap = fileReaderParser.readEmployesData(pathEmployeData);
        fileReaderParser.writeEmloyesData(pathEmployeData,employes,hashMap);
    }

    private static Visiteur initVisiteur() {
        Visiteur visiteur = new Visiteur();
        System.out.println("Bienvenu quel est votre nom ? ");
        Scanner scanner = new Scanner(System.in);
        String prenom = scanner.nextLine();

        System.out.println("Quel est votre age ?  ");

        int age = scanner.nextInt();

        visiteur.setAge(age);
        visiteur.setPrenom(prenom);

        return visiteur;
    }

    public static void afficherEquipe(Equipe equipe){
        System.out.println(equipe.toString());
    }

    public static ArrayList<Employe> initEmployeRestaurant(){
        ArrayList<Employe> employes = new ArrayList<Employe>();

        // equipe restaurant
        employes.add(new Employe("Axelis", "Keller", "manager", 1250f));
        employes.add(new Employe("Karl", "Smith", "manege", 1250f));
        employes.add(new Employe("John", "Rachid", "cuisine", 1250f));
        employes.add(new Employe("Thomas", "Muller", "caisse", 1250f));
        employes.add(new Employe("Will", "Cameron", "maintenance", 1250f));
        employes.add(new Employe("Mouna", "Litchi", "cuisine", 1250f));
        employes.add(new Employe("Conquérant", "Marc", "maintenance", 1250f));
        employes.add(new Employe("Chariqmatique", "John", "reservation", 1250f));

        return employes;
    }

    public static ArrayList<Employe> initEmployeBoutique(){
        ArrayList<Employe> employes = new ArrayList<Employe>();

        //equipe boutique
        employes.add(new Employe("Sasuke", "Uchiha", "manager", 2001f));
        employes.add(new Employe("Guerrier", "Kevin", "reservation", 1250f));
        employes.add(new Employe("Michael", "Jordan", "cuisine", 1250f));
        employes.add(new Employe("Domingues", "Cedric", "manege", 1250f));
        employes.add(new Employe("Da-Silva", "Silvana", "manege", 1250f));
        employes.add(new Employe("Oups", "Samantha", "manege", 1250f));
        employes.add(new Employe("Debbouz", "Jamel", "manege", 1250f));
        employes.add(new Employe("Charlie", "Damido", "reservation", 1149f));
        employes.add(new Employe("Doug", "Ezperanza", "cuisine", 1290f));

        return employes;
    }

    public static ArrayList<Employe> initEmployeAttraction(){
        ArrayList<Employe> employes = new ArrayList<Employe>();

        //equipe
        employes.add(new Employe("Naruto", "Uzumaki", "manager", 2090f));
        employes.add(new Employe("Pascal", "Dupont", "manege", 1550f));
        employes.add(new Employe("Thierry", "L'hermitte", "reservation", 1250f));
        employes.add(new Employe("Matéo", "Ducoin", "caisse", 1280f));
        employes.add(new Employe("Pricillia", "Brille", "caisse", 1450f));
        employes.add(new Employe("Sean", "Nord", "caisse", 1180f));
        employes.add(new Employe("El Maleh", "Gad", "manege", 1250f));
        employes.add(new Employe("Sakura", "Haruno", "accueil", 1890f));

        return employes;
    }

    public static Employe findEmploye(String username, Equipe equipesBoutique, Equipe equipesAttraction, Equipe equipesRestaurant){
        ArrayList<Equipe> equipes = new ArrayList<Equipe>();
        equipes.add(equipesBoutique);
        equipes.add(equipesAttraction);
        equipes.add(equipesRestaurant);

        Employe foundEmploye = new Employe();
        for(Equipe equipe : equipes){
            for(Employe employe : equipe.getEmploye()){
                if(employe.getNom().equals(username)){
                    foundEmploye = employe;
                    break;
                }
            }
        }
        return foundEmploye;
    }

    public static Equipe findEquipe(Employe employe, Equipe equipesBoutique, Equipe equipesAttraction, Equipe equipesRestaurant){
        ArrayList<Equipe> equipes = new ArrayList<Equipe>();
        equipes.add(equipesBoutique);
        equipes.add(equipesAttraction);
        equipes.add(equipesRestaurant);

        Equipe foundEquipe = new Equipe();
        for(Equipe equipe : equipes){
            for(Employe elem : equipe.getEmploye()){
                if(elem.equals(employe)){
                    foundEquipe = equipe;
                    break;
                }
            }
        }
        return foundEquipe;
    }

}
