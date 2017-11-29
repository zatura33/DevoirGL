package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerFacade {

	@FXML
	private Button payerFacture;

	@FXML
	private Button inscription;

	@FXML
	private Button Inventaire;

	@FXML
	private Button ajoutArticle;

	@FXML
	private Button vente;

	@FXML
	private Button dossierMembre;

	@FXML
	void OnClickInscriptionMembre(ActionEvent event) {

	}

	@FXML
	void OnClickNouvelleVente(ActionEvent event) {

	}

	@FXML
	void OnClickConsulterInventaire(ActionEvent event) {
		Parent rootContainer;
		try {
			rootContainer = FXMLLoader.load(getClass().getResource("/application/ConsulterInventaire.fxml"));
			Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene s=new Scene(rootContainer);

			stageTheEventSourceNodeBelongs.setScene(s);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void OnClickPayerFacture(ActionEvent event) {

	}

	@FXML
	void OnClickDossierMembre(ActionEvent event) {

	}

	@FXML
	void OnClickAjoutArticle(ActionEvent event) {
		Parent rootContainer;
		try {
			rootContainer = FXMLLoader.load(getClass().getResource("/application/AjoutArticle.fxml"));
			Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene s=new Scene(rootContainer);

			stageTheEventSourceNodeBelongs.setScene(s);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
