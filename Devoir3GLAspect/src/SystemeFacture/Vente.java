package SystemeFacture;

import java.util.List;

import Models.Article;
import Models.Membre;
import application.DataBase;

public class Vente 
{
	private int ID;
	private List<Article> ListArticles;
	private double Montant;
	private Membre Membre;

	public Vente(int id, List<Article> listArticles, double montant, Membre membre) 
	{
		setID(id);
		ListArticles = listArticles;
		Montant = montant;
		Membre = membre;
	}
	
	public Vente() 
	{}

	public List<Article> getListArticles() 
	{
		return ListArticles;
	}

	public void setListArticles(List<Article> listArticles) 
	{
		this.ListArticles = listArticles;
	}

	public double getMontant() 
	{
		return Montant;
	}

	public void setMontant(double montant) 
	{
		Montant = montant;
	}

	public Membre getMembre() 
	{
		return Membre;
	}

	public void setMembre(Membre membre) 
	{
		this.Membre = membre;
	}

	public int getID() 
	{
		return ID;
	}

	public void setID(int iD) 
	{
		ID = iD;
	}
	
	public Vente ReturnVenteByID(int ID) 
	{
		for (int i = 0; i< DataBase.GetVentes().size(); i++) {
			if (DataBase.GetVentes().get(i).ID == ID) {
				return DataBase.GetVentes().get(i);
			}
		}
		return null;
	}
	
	public Facture CreateFacture(boolean estPaye, Province laProvince) 
	{
		Facture facture = new Facture(Integer.toString(DataBase.ListeFacture.size()+1),this.Montant,estPaye,this,laProvince);
		return  facture;
	}
}
