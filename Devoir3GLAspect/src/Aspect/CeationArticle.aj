package Aspect;
import Models.Article;
import application.ControllerAjoutArticle;

public aspect CeationArticle {

	pointcut callSetX(): call(void AddItem(Article))&& within (ControllerAjoutArticle);
	before() : callSetX()  
	{
        System.out.println("Before call void AddItem(Article)");
    }
	
	after() : callSetX()  
	{
        System.out.println("After call void AddItem(Article)");
    }
}

