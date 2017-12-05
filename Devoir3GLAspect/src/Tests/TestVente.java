package Tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import Models.Article;
import Models.Membre;
import SystemeFacture.Province;
import SystemeFacture.Vente;
import application.DataBase;

public class TestVente {

	@Test
	public void testReturnVenteByID() {
		int ID = 120;
		List<Article> list = null;
		Vente vente = new Vente(ID, list, (double)10, new Membre());
		DataBase.AddVente(vente);
		
		assertNotNull("Erreur, vente nulle", vente.ReturnVenteByID(ID));

	}

	@Test
	public void testCreateFacture() {
		
		Vente vente = new Vente();
		
		assertNotNull("Erreur, vente nulle",vente.CreateFacture(true, Province.AB));
		assertNotNull("Erreur, vente nulle",vente.CreateFacture(false, Province.AB));
	}

}
