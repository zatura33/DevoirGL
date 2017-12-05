package application;

import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Models.Article;
import Models.Membre;
import SystemeFacture.Facture;
import SystemeFacture.Vente;
import SystemeFacture.province;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.stage.Stage;

public class ControllerResumeVente implements Initializable{   
	private Vente vente;
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
    private ComboBox<province> cbProvince;

    @FXML
    void OnClickPayerMaintenant(ActionEvent event) 
    {
    		if(facture == null) 
    		{
    			ErrorMessage();
    			return;
    		}
    		//facture.setEstPaye(true);
    		DataBase.AddFacture(facture);
    }

    @FXML
    void OnClickPayerPlusTard(ActionEvent event) 
    {
		if(facture == null) {
			ErrorMessage();
			return;
		}
		DataBase.AddFacture(facture);
		
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
		// TODO Auto-generated method stub
		vente = new Vente();
		vente = vente.ReturnMembreByID(DataBase.getVentes().size());
		this.SetMembreValue(vente.getMembre());
		cbProvince.setItems( FXCollections.observableArrayList( province.values()));
		lblNbArticles.setText(Integer.toString(vente.getListArticles().size()));
		lblNumFacture.setText("");
		lblPrixTTC.setText("Need Province");
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
    	
	    	SingleSelectionModel<province> selectedType = cbProvince.getSelectionModel();
	    	province pro = selectedType.getSelectedItem();
	    	
		facture = vente.CreateFacture(false, pro);
		lblNumFacture.setText(facture.getNumFacture());
		lblPrixTTC.setText(Double.toString(facture.getMontant()));
		lblPrixHT.setText(Double.toString(vente.getMontant()));
    }

}
