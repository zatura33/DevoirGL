import Models.Article;
public aspect CeationArticle {
	
	public int Article.assertX(int Quantity) {
		return (Quantity);
	}
	
	public void Article.changeQuantity(int Quantity) {		
			System.out.println("quantité vaut:"+Quantity);
	}
}
/*public aspect PointAspect {
public boolean Point.assertX(int x) {
return (x <= 100 && x >= 0);
}
public void Point.changeX(int x) {
if(!assertX(x))
	System.out.println("X n'a pas une valeur valide");
else
	setX(x);
}}
*/

/*public class Point{
private int x;
private int y;

public Point(int x, int y) {
	this.x = x;
	this.y = y;
}
public int getX() {return x;}
public int getY() {return y;}
public void setX(int x) {this.x = x;}
public void setY(int y) {this.y = y;}	
}
*/