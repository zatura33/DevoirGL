package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			Parent rootContainer = FXMLLoader.load(getClass().getResource("/application/Facade.fxml"));
			Scene s=new Scene(rootContainer);
			primaryStage.setScene(s);
			primaryStage.setTitle("Articles de sports");
			primaryStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) 
	{
		launch(args);
	}
}
