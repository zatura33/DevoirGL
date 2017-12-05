package SystemeFacture;

import java.util.List;

import Models.Article;
import Models.Membre;
import SystemePaiement.Paiement;
import application.DataBase;

public class Vente {
	private int ID;
	private List<Article> ListArticles;
	private double Montant;
	private Membre Membre;

	public Vente(int id, List<Article> listArticles, double montant, Membre membre) {
		setID(id);
		ListArticles = listArticles;
		Montant = montant;
		Membre = membre;
	}
	
	public Vente() {}

	public List<Article> getListArticles() {
		return ListArticles;
	}

	public void setListArticles(List<Article> listArticles) {
		this.ListArticles = listArticles;
	}

	public double getMontant() {
		return Montant;
	}

	public void setMontant(double montant) {
		Montant = montant;
	}

	public Membre getMembre() {
		return Membre;
	}

	public void setMembre(Membre membre) {
		this.Membre = membre;
	}

	public Facture CreateFacture(double montant, boolean estPaye, province laProvince) {
		Facture facture = new Facture(Integer.toString(DataBase.ListeFacture.size()+1),montant,estPaye,this,laProvince);
		return  facture;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public Vente ReturnMembreByID(int ID) {
		for (int i = 0; i< DataBase.getVentes().size(); i++) {
			if (DataBase.getVentes().get(i).ID == ID) {
				return DataBase.getVentes().get(i);
			}
		}
		return null;
	}
}
