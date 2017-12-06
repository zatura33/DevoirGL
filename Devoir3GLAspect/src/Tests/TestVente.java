package Tests;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import Models.Article;
import Models.Membre;
import SystemeFacture.Province;
import SystemeFacture.Vente;
import application.DataBase;

public class TestVente 
{
	private static int ID;
	private static List<Article> list;
	private static Vente vente;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		ID = 120;
		list = null;
		vente = new Vente(ID, list, (double)10, new Membre());
	}
	
	@Test
	public void testReturnVenteByID() 
	{
		DataBase.AddVente(vente);
		assertNotNull("Erreur, vente nulle", vente.ReturnVenteByID(ID));
	}

	@Test
	public void testCreateFacture() 
	{
		assertNotNull("Erreur, vente nulle",vente.CreateFacture(true, Province.AB));
		assertNotNull("Erreur, vente nulle",vente.CreateFacture(false, Province.AB));
	}
}
