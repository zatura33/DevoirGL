package Tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import SystemeFacture.Facture;
import SystemeFacture.Province;
import SystemeFacture.Vente;
import SystemePaiement.ModePaiement;
import application.DataBase;

public class TestFacture 
{

	private static String NumFacture;
	private static Facture facture;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		NumFacture = "qwe12356";
		facture = new Facture(NumFacture,(double)10, true,new Vente(),Province.AB);
	}
	
	@Test
	public void testReturnFactureByNumFacture() 
	{
		DataBase.AddFacture(facture);
		assertNotNull("Erreur, facture nulle",facture.ReturnFactureByNumFacture(NumFacture));	
	}

	@Test
	public void testCreatePaiement() 
	{		
		assertNotNull("Erreur, facture nulle",facture.CreatePaiement(ModePaiement.Cheque));
		assertNotNull("Erreur, facture nulle",facture.CreatePaiement(ModePaiement.Comptant));
		assertNotNull("Erreur, facture nulle",facture.CreatePaiement(ModePaiement.Credit));
	}

}
