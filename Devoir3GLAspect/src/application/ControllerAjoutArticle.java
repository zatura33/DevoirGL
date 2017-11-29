package application;

import Models.Article;
import Models.InventaireSingleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerAjoutArticle {

	@FXML
	private Button butAjout;

	@FXML
	private TextField txtPriceArticle;

	@FXML
	private TextField txtQuantity;

	@FXML
	private TextField txtNameArticle;

	@FXML
	void OnclickAjouter(ActionEvent event) {
		if(this.txtNameArticle.getText().equals("") || this.txtQuantity.getText().equals("") || this.txtPriceArticle.getText().equals("")) {
			System.out.println("Il semble y avoir une erreur dans l'ajout d'article ...");
			return;
		}
		try {
			Article article = new Article(this.txtNameArticle.getText(), Integer.parseInt(this.txtPriceArticle.getText()),Integer.parseInt(this.txtQuantity.getText()));

			InventaireSingleton.getInstance().AddItem(article);
			System.out.println("End");

			Parent rootContainer;
			rootContainer = FXMLLoader.load(getClass().getResource("/application/Facade.fxml"));
			Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene s=new Scene(rootContainer);

			stageTheEventSourceNodeBelongs.setScene(s);

		}
		catch(Exception e) {
			e.printStackTrace();
		}    
	}

	@FXML
	void OnclickRetour(ActionEvent event) {
		try {
			Parent rootContainer;
			rootContainer = FXMLLoader.load(getClass().getResource("/application/Facade.fxml"));
			Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene s=new Scene(rootContainer);

			stageTheEventSourceNodeBelongs.setScene(s);

		}
		catch(Exception e) {
			e.printStackTrace();
		}    
	}

}
