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
		this.ShowMessageNotImplementedYet();
	}

	// Nouvelle Vente
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

	// Consulter inventaire
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

	// Payer facture
	@FXML
	void OnClickPayerFacture(ActionEvent event) 
	{
		this.ShowMessageNotImplementedYet();
	}

	// Dossier membre
	@FXML
	void OnClickDossierMembre(ActionEvent event) 
	{
		this.ShowMessageNotImplementedYet();
	}

	// Ajouter article
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
	
	private void ShowMessageNotImplementedYet()
	{
		new Alert(Alert.AlertType.INFORMATION, "Non-implementer, les cas d'utilisation ayant été implémentés sont :\n  - La vente d'un article avec son paiement sur place\n  - Ajouter un article dans la base de données\n  - Consulter le catalogue d'articles.").showAndWait();
	}

}
