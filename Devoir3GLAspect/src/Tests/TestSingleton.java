package Tests;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import Models.Inventaire;
import Models.InventaireSingleton;
import application.DataBase;

public class TestSingleton {

	private static Inventaire ListeInventaire;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		ListeInventaire = DataBase.GetInventaire();
	}
	
	@Test
	public void testGetInstance() 
	{
		for (int i = 0; i<InventaireSingleton.getInstance().getListe().size();i++)
		{
			assertEquals("Inventaire incorrect",ListeInventaire.getListe().get(i).getID(),InventaireSingleton.getInstance().getListe().get(i).getID());
		}
	}
}
