package application;
import java.util.ArrayList;
import java.util.List;

import Models.Article;
import Models.Inventaire;
import Models.Membre;
import SystemeFacture.Facture;
import SystemeFacture.Vente;
import SystemePaiement.Paiement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DataBase {
	public static List<Facture> ListeFacture= new ArrayList<Facture>();
	public static List<Paiement> ListePaiement= new ArrayList<Paiement>();
	public static List<Vente> ListeVente= new ArrayList<Vente>();

	public static Inventaire GetInventaire(){
		List<Article> Liste;
		Liste = new ArrayList<Article>();

		Liste.add(new Article("QW1","Baskets",250,10));
		Liste.add(new Article("QW2","Raquete de tennis",50,2));
		Liste.add(new Article("QW3","Gants de boxe",25,1));
		Liste.add(new Article("QW4","Ballon",60,5));
		Liste.add(new Article("QW5","Short",70,10));
		Liste.add(new Article("QW6","Poids",5000,3));

		Inventaire inventaire = new Inventaire();
		inventaire.setListe(Liste);
		return inventaire;

	}

	public static List<Membre> GetListMembre(){
		List<Membre> Liste;
		Liste = new ArrayList<Membre>();

		Liste.add(new Membre("1","Johann","Dufaud","123456789","22 rue des sapins", "8197016940","Devolutions"));
		Liste.add(new Membre("2","Emile","Desrosiers","741852963","22 rue des sapins", "8197016940","Devolutions"));
		Liste.add(new Membre("3","Vincent","Roy","963852741","22 rue des sapins", "8197016940","Devolutions"));

		return Liste;
	}
		
	public static void AddFacture(Facture facture) {
		ListeFacture.add(facture);
	}
	
	public static void AddPaiement(Paiement paiement) {
		ListePaiement.add(paiement);
	}
	
	public static void AddVente(Vente vente) {
		ListeVente.add(vente);
	}
	
	public static List<Vente> getVentes() {
		return ListeVente;
	}
}