package Item;

public class Produit extends Service{

	private String categorie;

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Produit(String nom, float prix, String categorie) {

		super(nom, prix);
		this.categorie = categorie;
	}
}