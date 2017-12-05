package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerFacade 
{
	Parent rootContainer;

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
	void OnClickInscriptionMembre(ActionEvent event) 
	{
		new Alert(Alert.AlertType.INFORMATION, "Non-implementer, les cas d'utilisation ayant été implémentés sont la vente d'un article avec son paiement sur place, ajouter un article dans la base de données et consulter le catalogue d'articles.").showAndWait();
	}

	@FXML
	void OnClickNouvelleVente(ActionEvent event) 
	{
		try 
		{
			rootContainer = FXMLLoader.load(getClass().getResource("/application/NouvelleVente.fxml"));
			Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene s=new Scene(rootContainer);

			stageTheEventSourceNodeBelongs.setScene(s);

		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@FXML
	void OnClickConsulterInventaire(ActionEvent event) 
	{
		try 
		{
			rootContainer = FXMLLoader.load(getClass().getResource("/application/ConsulterInventaire.fxml"));
			Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene s=new Scene(rootContainer);

			stageTheEventSourceNodeBelongs.setScene(s);

		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@FXML
	void OnClickPayerFacture(ActionEvent event) 
	{
		new Alert(Alert.AlertType.INFORMATION, "Non-implementer, les cas d'utilisation ayant été implémentés sont la vente d'un article avec son paiement sur place, ajouter un article dans la base de données et consulter le catalogue d'articles.").showAndWait();
	}

	@FXML
	void OnClickDossierMembre(ActionEvent event) 
	{
		new Alert(Alert.AlertType.INFORMATION, "Non-implementer, les cas d'utilisation ayant été implémentés sont la vente d'un article avec son paiement sur place, ajouter un article dans la base de données et consulter le catalogue d'articles.").showAndWait();
	}

	@FXML
	void OnClickAjoutArticle(ActionEvent event) 
	{
		try 
		{
			rootContainer = FXMLLoader.load(getClass().getResource("/application/AjoutArticle.fxml"));
			Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene s=new Scene(rootContainer);

			stageTheEventSourceNodeBelongs.setScene(s);

		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
