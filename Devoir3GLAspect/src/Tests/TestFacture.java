package Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import SystemeFacture.Facture;
import SystemeFacture.Province;
import SystemeFacture.Vente;
import SystemePaiement.ModePaiement;
import application.DataBase;

public class TestFacture {

	@Test
	public void testReturnFactureByNumFacture() 
	{
		String NumFacture = "qwe12356";
		Facture facture = new Facture(NumFacture,(double)10, true,new Vente(),Province.AB);
		DataBase.AddFacture(facture);
		
		assertNotNull("Erreur, facture nulle",facture.ReturnFactureByNumFacture(NumFacture));	
		}

	@Test
	public void testCreatePaiement() {
		Facture facture = new Facture();
		
		assertNotNull("Erreur, facture nulle",facture.CreatePaiement(ModePaiement.Cheque));
		assertNotNull("Erreur, facture nulle",facture.CreatePaiement(ModePaiement.Comptant));
		assertNotNull("Erreur, facture nulle",facture.CreatePaiement(ModePaiement.Credit));
	}

}
