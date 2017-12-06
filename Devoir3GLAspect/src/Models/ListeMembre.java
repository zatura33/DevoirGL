package Models;

import java.util.ArrayList;
import java.util.List;

import application.DataBase;

public class ListeMembre 
{
	private List<Membre> Liste;

	public ListeMembre() 
	{
		Liste = new ArrayList<Membre>();
		Liste = DataBase.GetListMembre();
	}
	
	public List<Membre> getListe() 
	{
		return Liste;
	}

}
