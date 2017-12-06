package Aspect;
import Models.Article;
import Models.Inventaire;
import Models.InventaireSingleton;
import Models.Membre;
import SystemeFacture.Vente;

import java.util.List;
import application.ControllerAjoutArticle;
import application.ControllerNouvelleVente;
import application.DataBase;
public aspect AspectClass {

	public int Inventaire.ItemExist(Article article, List<Article> Liste) 
	{		
		for (int a = 0;a<Liste.size(); a++) 
		{
			// Si meme Id et meme nom et meme prix alors on met a jour le nombre dans l'inventaire
			if(article.getID().equals(Liste.get(a).getID()) && article.getName().equals(Liste.get(a).getName()))
			{
				return a;
			}
		}

		return -1;
	}

	// Verification pour que l'ID soit unique
	pointcut callAddItemXIntoInventaire(Article article):
		call(void AddItem(Article))&& args(article)&& within (ControllerAjoutArticle);

	before(Article article): callAddItemXIntoInventaire(article) 
	{
		List<Article> listeArticles = InventaireSingleton.getInstance().getListe();
		for (int a = 0;a<listeArticles.size(); a++) 
		{
			if(article.getID().equals(listeArticles.get(a).getID()) && !article.getName().equals(listeArticles.get(a).getName()))
			{
				throw new IllegalArgumentException("Cet ID est deja utilisé");
			}
		}
	}

	// Verifier si le client est bien membre
	pointcut callAddVenteXIntoDatabase(Vente vente):
		call(void AddVente(Vente))&& args(vente)&& within (ControllerNouvelleVente);

	before(Vente vente): callAddVenteXIntoDatabase(vente) 
	{
		List<Membre> listeMembres = DataBase.GetListMembre();
		for (int a = 0;a<listeMembres.size(); a++) 
		{
			if(vente.getMembre().getCodeUtilisateur().equals(listeMembres.get(a).getCodeUtilisateur()))
			{
				System.out.println("Cette personne est bien membre");
				return;
			}
		}
		throw new IllegalArgumentException("Cette personne n'est pas un membre");
	}
}