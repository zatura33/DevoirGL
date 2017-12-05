package application;

import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Models.Article;
import Models.Membre;
import SystemeFacture.Vente;
import SystemeFacture.province;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class ControllerResumeVente implements Initializable{   
	private Vente vente;
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
    void OnClickPayerMaintenant(ActionEvent event) {

    }

    @FXML
    void OnClickPayerPlusTard(ActionEvent event) {

    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		vente = new Vente();
		vente = vente.ReturnMembreByID(DataBase.getVentes().size());
		this.SetMembreValue(vente.getMembre());
		cbProvince.setItems( FXCollections.observableArrayList( province.values()));

	}
	
	private void SetMembreValue(Membre membre) {
		this.lblPrenom.setText(membre.getPrenom());
		this.lblNom.setText(membre.getNom());
		this.lblAdresse.setText(membre.getAdresse());
		this.lblCodeUtilisateur.setText(membre.getCodeUtilisateur());
		this.lblNumtel.setText(membre.getNumTel());
	}
	
	private void SetListArticle(List<Article> listArticles) {
		
	}
	
    @FXML
    void OnClickProvince(ActionEvent event) {

    }

}
