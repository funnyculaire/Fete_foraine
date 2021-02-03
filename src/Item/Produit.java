package Item;

public class Produit extends Service{

	private String categorie;
	private Goodies goodie;
	private Snacks snack;

	public Produit() {
		super();

	}

	public Produit(String nom, float prix, Goodies goodies) {
		super(nom, prix);
	}

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

	public Produit(String nom, float prix, String categorie, Goodies goodie) {

		super(nom, prix);
		this.categorie = categorie;
		this.goodie = goodie;
	}
	public Produit(String nom, float prix, String categorie,Snacks snack ) {

		super(nom, prix);
		this.categorie = categorie;
		this.snack = snack;

	}

	@Override
	public String toString() {
		return "Produit{" +
				"categorie='" + categorie + '\'' +
				", goodie=" + goodie +
				", snack=" + snack +
				'}';
	}
}
