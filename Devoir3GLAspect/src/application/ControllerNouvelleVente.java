package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Models.Article;
import Models.Membre;
import SystemeFacture.Vente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControllerNouvelleVente implements Initializable 
{
		
	ObservableList<Article> articles;
	 @FXML
    private TextField txtIDArticle;

    @FXML
    private TextField txtIDMembre;    
	    
    @FXML
    private TableView<Article> TableView;

    @FXML
    void onClickScanArticle(ActionEvent event) 
    {
    	if(this.txtIDArticle.getText().equals("")) 
    	{
    		this.ErrorMessage();
			return;
		}
		try 
		{
			Article article = new Article();
			article = article.ReturnArticleByID(this.txtIDArticle.getText());
			if(article == null) 
			{
	    		this.ErrorMessage();
	    		return;
			}
			
			articles.add(article);
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			this.ErrorMessage();
		}    
    }
    
    @FXML
    void OnClickSuivant(ActionEvent event) 
    {
		if(this.txtIDMembre.getText().equals("") || articles.size() == 0) 
		{
    		this.ErrorMessage();
    		return;
		}
		Membre membre = new Membre();
		membre = membre.ReturnMembreByID(this.txtIDMembre.getText());
		
		double montantHorsTaxe = 0;
		List<Article> ArticlesVendu = new ArrayList<Article>();
		for (Article mesArticles :articles) 
		{
			if(mesArticles.getQuantity() == 0) 
			{
				new Alert(Alert.AlertType.ERROR, "L'article : "+mesArticles.getName()+" est actuellement en rupture de stock ...").showAndWait();
				continue;
			}
			montantHorsTaxe += mesArticles.getPrice();
			mesArticles.setQuantity(mesArticles.getQuantity()-1);
			ArticlesVendu.add(mesArticles);
		}
    	Vente vente = new Vente((DataBase.GetVentes().size()+1), ArticlesVendu, montantHorsTaxe, membre);
    	DataBase.AddVente(vente);
    	
		try 
		{
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/ResumeVente.fxml"));
    		fxmlLoader.setController(new ControllerResumeVente(vente.getID()));
    		
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
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) 
    {	
	TableColumn IDColomn = new TableColumn("ID");
	IDColomn.setMinWidth(100);
	IDColomn.setCellValueFactory(
			new PropertyValueFactory<>("ID"));

	TableColumn NameColumn = new TableColumn("Nom");
	NameColumn.setMinWidth(200);
	NameColumn.setCellValueFactory(
			new PropertyValueFactory<>("Name"));

	TableColumn PriceColumn = new TableColumn("Prix");
	PriceColumn.setMinWidth(100);
	PriceColumn.setCellValueFactory(
			new PropertyValueFactory<>("Price"));

	TableColumn QuantityColumn = new TableColumn("Quantite");
	QuantityColumn.setMinWidth(100);
	QuantityColumn.setCellValueFactory(
			new PropertyValueFactory<>("Quantity"));

	articles = FXCollections.observableArrayList();
	
	TableView.getColumns().addAll(IDColomn,NameColumn,PriceColumn, QuantityColumn);

	TableView.setItems(articles);
	}
    
    public void ErrorMessage() 
    {
		new Alert(Alert.AlertType.ERROR, "Il semble y avoir une erreur, Veuillez Verifier que tous les champs sont remplis").showAndWait();
		System.out.println("Il semble y avoir une erreur, Veuillez Verifier que tous les champs sont remplis");
    }
}
