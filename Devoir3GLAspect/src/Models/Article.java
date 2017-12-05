package Models;


public class Article 
{
	private String ID;
	private String Name;
	private double Price;
	private int Quantity;

	public Article(String id, String name, double price, int quantity) 
	{
		ID = id;
		Name = name;
		Price = price;
		Quantity = quantity;
	}
	
	public Article() 
	{
	}
	
	public String getName() 
	{
		return Name;
	}
	
	public void setName(String name) 
	{
		Name = name;
	}
	
	public String getID() 
	{
		return ID;
	}
	
	public void setID(String id) 
	{
		ID = id;
	}
	
	public double getPrice() 
	{
		return Price;
	}
	
	public void setPrice(double price) 
	{
		Price = price;
	}
	
	public int getQuantity() 
	{
		return Quantity;
	}
	
	public void setQuantity(int quantity) 
	{
		Quantity = quantity;
	}
	
	public String toString() 
	{
		return this.Name + " \tPrix : "+this.Price + " Quantité : "+this.Quantity;
	}
	
	public Article ReturnArticleByID(String ID) {
		for (int i = 0; i< InventaireSingleton.getInstance().getListe().size(); i++) {
			if (InventaireSingleton.getInstance().getListe().get(i).ID.equals(ID)) {
				return InventaireSingleton.getInstance().getListe().get(i);
			}
		}
		return null;
	}

}
