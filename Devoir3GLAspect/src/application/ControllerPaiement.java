package application;

import java.net.URL;
import java.util.ResourceBundle;
import SystemeFacture.Facture;
import SystemePaiement.Paiement;
import SystemePaiement.ModePaiement;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.stage.Stage;

public class ControllerPaiement implements Initializable
{
	public ControllerPaiement(String numFacture) {
		NumFacture = numFacture;
	}

	private ModePaiement methodePaiement;

	private Facture facture;

	private String NumFacture;

	@FXML
	private Label lblMontant;

	@FXML
	private ComboBox<ModePaiement> cbTypePaiement;

	@FXML
	void OnClickPayer(ActionEvent event) 
	{
		if(methodePaiement == null) 
		{
			new Alert(Alert.AlertType.ERROR, "Erreur, Veuillez choisir une methode de paiement").showAndWait();
			return;
		}
		Paiement paiement = facture.CreatePaiement(this.methodePaiement);
		facture.setEstPaye(true);
		DataBase.AddPaiement(paiement);
		new Alert(Alert.AlertType.CONFIRMATION, "Paiement effectué avec succes.").showAndWait();

		try 
		{
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

	@FXML
	void OnClickAnnuler(ActionEvent event) 
	{
		try 
		{
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

	@FXML
	void OnClickMethodePaiement(ActionEvent event) 
	{
		SingleSelectionModel<ModePaiement> selectedType = cbTypePaiement.getSelectionModel();
		methodePaiement = selectedType.getSelectedItem();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		facture = new Facture();
		cbTypePaiement.setItems( FXCollections.observableArrayList( ModePaiement.values()));
		facture = facture.ReturnFactureByNumFacture(NumFacture);
		lblMontant.setText(""+facture.getMontant());
	}
}
