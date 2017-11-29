package Models;

import java.util.ArrayList;
import java.util.List;

public class Inventaire {
	private List<Article> Liste;


	public Inventaire() {
		Liste = new ArrayList<Article>();
	}
	public List<Article> getListe() {
		return Liste;
	}

	public void setListe(List<Article> liste) {
		Liste = liste;
	}

	public void AddItem(Article article) {
		int i = 0;
		//Output : C
		for (int a =0; a<Liste.size(); a++) {
			if(article.getName().equals(Liste.get(a).getName())){
				Liste.get(a).setQuantity(article.getQuantity() + Liste.get(a).getQuantity());
				System.out.println("Item Update");

				i++;
			}
		}

		if(i == 0) {
			Liste.add(article);
			System.out.println("Add Article");

		}		
	}

}
