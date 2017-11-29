package SystemeFacture;

import java.util.List;

import Models.Article;
import Models.Membre;
import SystemePaiement.Paiement;

public class Vente {
	private List<Article> listArticles;
	private double Montant;
	private Membre membre;

	public Vente(List<Article> listArticles, double montant, Membre membre) {
		super();
		this.listArticles = listArticles;
		Montant = montant;
		this.membre = membre;
	}

	public List<Article> getListArticles() {
		return listArticles;
	}

	public void setListArticles(List<Article> listArticles) {
		this.listArticles = listArticles;
	}

	public double getMontant() {
		return Montant;
	}

	public void setMontant(double montant) {
		Montant = montant;
	}

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	public Facture CreateFacture() {
		return null;
	}

	public Paiement CreatePaiement() {
		return null;
	}
}
