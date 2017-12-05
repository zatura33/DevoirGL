package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Models.Article;
import Models.Inventaire;
import Models.InventaireSingleton;
import application.DataBase;

public class TestSingleton {

	@Test
	public void testGetInstance() {
		DataBase.GetInventaire();
		InventaireSingleton.getInstance();
		for (int i = 0; i<InventaireSingleton.getInstance().getListe().size();i++)
		{
			if(DataBase.GetInventaire().getListe().get(i).getID() == (InventaireSingleton.getInstance().getListe().get(i).getID())) 
			{
				continue;
			}
			fail("Inventaire incorrect");
		}
	}

}
