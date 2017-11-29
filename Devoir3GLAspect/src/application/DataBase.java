package application;
import java.util.ArrayList;
import java.util.List;

import Models.Article;
import Models.Inventaire;
import Models.Membre;
import SystemeFacture.Facture;
import SystemePaiement.Paiement;

public class DataBase {
	public static List<Facture> ListeFacture= new ArrayList<Facture>();
	public static List<Paiement> ListePaiement= new ArrayList<Paiement>();

	public static Inventaire GetInventaire(){
		List<Article> Liste;
		Liste = new ArrayList<Article>();

		Liste.add(new Article("Baskets",250,10));
		Liste.add(new Article("Raquete de tennis",50,2));
		Liste.add(new Article("Gants de boxe",25,1));
		Liste.add(new Article("Ballon",60,5));
		Liste.add(new Article("Short",70,10));
		Liste.add(new Article("Poids",5000,3));

		Inventaire inventaire = new Inventaire();
		inventaire.setListe(Liste);
		return inventaire;

	}

	public static List<Membre> GetListMembre(){
		List<Membre> Liste;
		Liste = new ArrayList<Membre>();

		Liste.add(new Membre("Johann","Dufaud","123456789","22 rue des sapins", "8197016940","Devolutions"));
		Liste.add(new Membre("Emile","Desrosiers","741852963","22 rue des sapins", "8197016940","Devolutions"));
		Liste.add(new Membre("Vincent","Roy","963852741","22 rue des sapins", "8197016940","Devolutions"));

		return Liste;
	}
	
	public static void AddFacture(Facture facture) {
		ListeFacture.add(facture);
	}
	
	public static void AddPaiement(Paiement paiement) {
		ListePaiement.add(paiement);
	}
}