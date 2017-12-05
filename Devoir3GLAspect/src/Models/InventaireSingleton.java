package Models;

import application.DataBase;

public class InventaireSingleton 
{
	private static Inventaire instance;
	private InventaireSingleton(){}

	static
	{
		try
		{
			instance = DataBase.GetInventaire();
		}
		catch(Exception e)
		{
			throw new RuntimeException("Exception occured in creating singleton instance");
		}
	}

	public static Inventaire getInstance()
	{
		return instance;
	}

}
