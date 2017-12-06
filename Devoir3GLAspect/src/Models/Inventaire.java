package Models;

import java.util.ArrayList;
import java.util.List;

public class Inventaire 
{
	private List<Article> Liste;


	public Inventaire() 
	{
		Liste = new ArrayList<Article>();
	}
	
	public List<Article> getListe() 
	{
		return Liste;
	}

	public void setListe(List<Article> liste) 
	{
		Liste = liste;
	}

	public void AddItem(Article article) 
	{
		int exist = this.ItemExist(article, this.Liste);
		if (exist == -1)
		{
			Liste.add(article);
			System.out.println("Add Article");
		}
		else
		{
			Liste.get(exist).setQuantity(article.getQuantity() + Liste.get(exist).getQuantity());
			System.out.println("Item Update");
		}
	}
}
