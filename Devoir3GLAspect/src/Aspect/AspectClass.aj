package Aspect;
import Models.Article;
import Models.Inventaire;
import Models.InventaireSingleton;
import Models.Membre;
import SystemeFacture.Facture;
import SystemePaiement.Paiement;
import SystemeFacture.Vente;
import application.DataBase;
import java.util.Date;
import java.util.List;
import application.ControllerAjoutArticle;
import application.ControllerNouvelleVente;
import application.ControllerPaiement;


public aspect AspectClass 
{
	// ------------------------------- Aspect 1 Log des acces a la DataBase------------------------------------//
	private Date date;
	pointcut callGetInventaire(): call(* DataBase.GetInventaire());
	pointcut callGetListMembre(): call(* DataBase.GetListMembre());
	pointcut callGetFacture(): call(* DataBase.GetFacture());
	pointcut callGetVente(): call(* DataBase.GetVentes());

	pointcut callAddFacture(): call(void DataBase.AddFacture(Facture));
	pointcut callAddPaiement(): call(void DataBase.AddPaiement(Paiement));
	pointcut callAddVente(): call(void DataBase.AddVente(Vente));

	after() : callGetInventaire()
	{
		date = new Date();
        System.out.println(date.toString());
        System.out.println("Acces a l'inventaire sur la base de donn�es");
    }
	after() : callGetListMembre()
	{
		date = new Date();
        System.out.println(date.toString());
        System.out.println("Acces a la liste des membres sur la base de donn�es");
    }
	after() : callGetFacture()
	{
		date = new Date();
        System.out.println(date.toString());
        System.out.println("Acces a la liste des factures sur la base de donn�es");
    }
	after() : callGetVente()
	{
		date = new Date();
        System.out.println(date.toString());
        System.out.println("Acces a la liste des ventes sur la base de donn�es");
    }
	
	after() : callAddFacture()
	{
		date = new Date();
        System.out.println(date.toString());
        System.out.println("Ajout d`une facture sur la base de donn�es");
    }
	
	after() : callAddPaiement()
	{
		date = new Date();
        System.out.println(date.toString());
        System.out.println("Ajout d`un paiement sur la base de donn�es");
    }
	
	after() : callAddVente()
	{
		date = new Date();
        System.out.println(date.toString());
        System.out.println("Ajout d`une vente sur la base de donn�es");
    }
	// ------------------------------- Aspect 2 Supprimer le client si la facture est payé ------------------------------------//

	pointcut callAddPaiementX(Paiement paiement):
		call(void AddPaiement(Paiement))&& args(paiement)&& within (ControllerPaiement);
	
	before(Paiement paiement): callAddPaiementX(paiement)
	{
		if(paiement.getFacture().isEstPaye())
		{
			paiement.getFacture().getVente().setMembre(null);
	        System.out.println(date.toString());
	        System.out.println("Facture payé, client supprimé");
		}
	}
	
	// ------------------------------- Aspect TEST Ne pas prendre en compte ... ------------------------------------//
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
				throw new IllegalArgumentException("Cet ID est deja utilis�");
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