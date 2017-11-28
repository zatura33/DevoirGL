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

}
