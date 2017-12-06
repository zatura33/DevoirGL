package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import Models.Membre;
import SystemeFacture.Facture;
import SystemeFacture.Vente;
import SystemeFacture.Province;
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

public class ControllerResumeVente implements Initializable
{   
	public ControllerResumeVente(int ID) {
		IDVente = ID;
	}

	private Vente vente;

	private int IDVente;

	private Facture facture;

	@FXML
	private Label lblNumFacture;

	@FXML
	private Label lblPrenom;

	@FXML
	private Label lblNom;

	@FXML
	private Label lblAdresse;

	@FXML
	private Label lblNbArticles;

	@FXML
	private Label lblCodeUtilisateur;

	@FXML
	private Label lblNumtel;

	@FXML
	private Label lblPrixTTC;

	@FXML
	private Label lblPrixHT;

	@FXML
	private Label lblEntreprise;

	@FXML
	private ComboBox<Province> cbProvince;

	@FXML
	void OnClickPayerMaintenant(ActionEvent event) 
	{
		if(facture == null) 
		{
			ErrorMessage();
			return;
		}

		// On ajoute la facture sur la base de donne et on vas dans la nouvelle vue pour le paiement
		DataBase.AddFacture(facture);
		try 
		{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/Paiement.fxml"));
			fxmlLoader.setController(new ControllerPaiement(facture.getNumFacture()));

			Parent root1 = (Parent) fxmlLoader.load();
			Scene newScene=new Scene(root1);
			Stage anotherStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			anotherStage.setScene(newScene);
			anotherStage.show();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@FXML
	void OnClickPayerPlusTard(ActionEvent event) 
	{
		if(facture == null) {
			ErrorMessage();
			return;
		}
		// Ajout de la facture dans la BDD, elle sera disponnible en mode estPaye : false pour le paiement, et nous retournons sur la facade
		DataBase.AddFacture(facture);
		new Alert(Alert.AlertType.CONFIRMATION, "Voici votre numero de facture : "+facture.getNumFacture()+ "\nVeuillez le notez pour le paiement futur de celle-ci.").showAndWait();
		try 
		{
			Parent rootContainer;
			rootContainer = FXMLLoader.load(getClass().getResource("/application/Facade.fxml"));
			Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene s=new Scene(rootContainer);
			stageTheEventSourceNodeBelongs.setScene(s);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}

	public void ErrorMessage() 
	{
		new Alert(Alert.AlertType.ERROR, "Erreur, Veuillez choisir une province").showAndWait();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		vente = new Vente();
		vente = vente.ReturnVenteByID(IDVente);
		this.SetMembreValue(vente.getMembre());
		cbProvince.setItems( FXCollections.observableArrayList( Province.values()));
		lblNbArticles.setText(Integer.toString(vente.getListArticles().size()));
		lblNumFacture.setText("");
		lblPrixTTC.setText("Province Requise");
		lblPrixHT.setText(Double.toString(vente.getMontant()));
	}

	private void SetMembreValue(Membre membre) 
	{
		this.lblPrenom.setText(membre.getPrenom());
		this.lblNom.setText(membre.getNom());
		this.lblAdresse.setText(membre.getAdresse());
		this.lblCodeUtilisateur.setText(membre.getCodeUtilisateur());
		this.lblNumtel.setText(membre.getNumTel());
		this.lblEntreprise.setText(membre.getEntreprise());
	}

	@FXML
	void OnClickProvince(ActionEvent event) {

		SingleSelectionModel<Province> selectedType = cbProvince.getSelectionModel();
		Province pro = selectedType.getSelectedItem();

		facture = vente.CreateFacture(false, pro);
		lblNumFacture.setText(facture.getNumFacture());
		lblPrixTTC.setText(Double.toString(facture.getMontant()));
		lblPrixHT.setText(Double.toString(vente.getMontant()));
	}
}
