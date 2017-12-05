import Models.Article;
import Models.Inventaire;
import java.util.List;

public aspect AspectTest {

	public int Inventaire.ItemExist(Article article, List<Article> Liste) 
	{		
		for (int a = 0;a<Liste.size(); a++) 
		{
			// Si meme Id et meme nom et meme prix alors on met a jour le nombre dans l'inventaire
			if(article.getID().equals(Liste.get(a).getID()) && article.getName().equals(Liste.get(a).getName()) && article.getPrice() == Liste.get(a).getPrice())
			{
				return a;
			}
		}

		return -1;
	}
}