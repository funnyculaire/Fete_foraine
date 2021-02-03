package percistence;

import Individu.Individu;
import fete_forraine.Reservation;

import java.io.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files


public class FileReaderParser {

    public FileReaderParser(){

    }
    public void fileWriter(Reservation reservation, Individu individu, String path){
        try{
            File file = new File(path);


            if (file.createNewFile()) {
                //exist
                System.out.println("File created: " + file.getName());

            } else {
                //do
                FileWriter writer = new FileWriter(path, true);
                int numeroReservation = numberOfReservation(path) + 1 ;

                System.out.println("Numero de reservation : " + numeroReservation);



                DecimalFormatSymbols dfs = new DecimalFormatSymbols();
                dfs.setDecimalSeparator('.');

                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                decimalFormat.setDecimalFormatSymbols(dfs);

                float prixToWrite = Float.parseFloat(decimalFormat.format(reservation.getPrix()));
                String dataToWrite = "\nNumero de reservation  : " + numeroReservation
                        +" Nom :"+ individu.getNom()
                        +" Prenom :"+ individu.getPrenom()
                        +" Type Tarification  :"+ reservation.getType_tarification()
                        +" Prix Total  :" + prixToWrite;


                writer.write(dataToWrite);
                writer.close();

                System.out.println("Donnée ecrite !");
            }

        }
        catch(FileNotFoundException e){
            System.err.println("Erreur !");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public int numberOfReservation(String path){
        int i  = 0;
        try{
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                //compte le nombre de ligne
                scanner.nextLine();
                i++;
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return i;
    }

    public ArrayList<String> fileReader(String path){

        ArrayList<String> data = new ArrayList<String>();
        try{
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()){
                String newLine = scanner.nextLine();
                data.add(newLine);
            }


        }catch (FileNotFoundException e){
            System.err.println("Erreur ! ");
            System.out.println(e);
            e.printStackTrace();
        }

        return data;
    }
}
