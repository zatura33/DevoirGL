package Tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import Models.Article;
import Models.Inventaire;
import Models.InventaireSingleton;

public class TestArticles 
{
	private static Inventaire inventaire;
	private static int newQuantity;
	private static Article article;
	private static Article articleVide;
	private static String ID;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		ID = "123456789";
		inventaire = InventaireSingleton.getInstance();
		newQuantity = 150;
		article = new Article(ID,"testcase",20,5);
		articleVide = new Article();
	}
	
	@Test
	public void testSetQuantity() 
	{
		for (Article article : inventaire.getListe())
		{
			article.setQuantity(newQuantity);
		}
		
		for (int i =0; i<InventaireSingleton.getInstance().getListe().size();i++)
		{
			assertEquals("Erreur dans le changement de quantité",inventaire.getListe().get(i).getQuantity(), inventaire.getListe().get(i).getQuantity());
		}
	}

	@Test
	public void testReturnArticleByID() 
	{
		inventaire.AddItem(article);
		assertNotNull(articleVide = articleVide.ReturnArticleByID(ID));
	}
}