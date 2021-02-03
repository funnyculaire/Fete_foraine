package fete_forraine;

public class Reservation {
	private int numero_reservation;
	private String type_tarification;
	private float prix = 25;

	public Reservation(int numero_reservation, Tarification tarification) {
		this.numero_reservation = numero_reservation;
		this.type_tarification = tarification.toString();
		updateTarification(tarification);


	}

	public Reservation(){

	}

	public void updateTarification(Tarification tarification){

		switch (tarification){

			case ENFANT :
				prix = this.prix *0.60f;
				break;

			case ETUDIANT:
				this.prix = this.prix *0.75f;
				break;

			case SENIOR:
				this.prix = this.prix *0.80f;
				break;

			case FAMILLE_NOMBREUSE:
				this.prix = this.prix *0.65f;
				break;

			case GROUPE5:
				this.prix = (this.prix *0.90f)*5;
				break;

			case GROUPE10:
				this.prix = (this.prix *0.85f)*10;
				break;

			case NORMAL:
				break;

		}

	}

	public int getNumero_reservation() {
		return numero_reservation;
	}

	public void setNumero_reservation(int numero_reservation) {
		this.numero_reservation = numero_reservation;
	}

	public String getType_tarification() {
		return type_tarification;
	}

	public void setType_tarification(String type_tarification) {
		this.type_tarification = type_tarification;
	}

	public float getPrix() {

		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}
}
