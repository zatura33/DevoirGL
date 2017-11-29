package application;

import java.net.URL;
import java.util.ResourceBundle;

import Models.Article;
import Models.InventaireSingleton;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControllerConsulterInventaire implements Initializable
{
	@FXML
	private Button butRetour;

	@FXML
	private javafx.scene.control.TableView<Article> TableView;


	@FXML
	void OnClickRetour(ActionEvent event) {
		try {
			Parent rootContainer;
			rootContainer = FXMLLoader.load(getClass().getResource("/application/Facade.fxml"));
			Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene s=new Scene(rootContainer);

			stageTheEventSourceNodeBelongs.setScene(s);

		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}    

	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("start");

		TableColumn firstNameCol = new TableColumn("Nom");
		firstNameCol.setMinWidth(200);
		firstNameCol.setCellValueFactory(
				new PropertyValueFactory<>("Name"));

		TableColumn TwoNameCol = new TableColumn("Prix");
		TwoNameCol.setMinWidth(100);
		TwoNameCol.setCellValueFactory(
				new PropertyValueFactory<>("Price"));

		TableColumn lastNameCol = new TableColumn("Quantite");
		lastNameCol.setMinWidth(100);
		lastNameCol.setCellValueFactory(
				new PropertyValueFactory<>("Quantity"));

		ObservableList<Article> articles = FXCollections.observableArrayList();
		for (int i = 0; i< InventaireSingleton.getInstance().getListe().size(); i++) {
			articles.add(InventaireSingleton.getInstance().getListe().get(i));
		}
		System.out.println("Singleton size :" +InventaireSingleton.getInstance().getListe().size());
		TableView.getColumns().addAll(firstNameCol,TwoNameCol, lastNameCol);

		TableView.setItems(articles);

	}

}