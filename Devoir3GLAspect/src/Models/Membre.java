package Models;

public class Membre {
	private String Nom;
	private String Prenom;
	private String CodeUtilisateur;
	private String Adresse;
	private String NumTel;
	private String Entreprise;
	
	public Membre(String nom, String prenom, String codeUtilisateur, String adresse, String numTel, String entreprise) {
		Nom = nom;
		Prenom = prenom;
		CodeUtilisateur = codeUtilisateur;
		Adresse = adresse;
		NumTel = numTel;
		Entreprise = entreprise;
	}
	
	public String getNom() {
		return Nom;
	}
	
	public void setNom(String nom) {
		Nom = nom;
	}
	
	public String getPrenom() {
		return Prenom;
	}
	
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	
	public String getCodeUtilisateur() {
		return CodeUtilisateur;
	}
	
	public void setCodeUtilisateur(String codeUtilisateur) {
		CodeUtilisateur = codeUtilisateur;
	}
	
	public String getAdresse() {
		return Adresse;
	}
	
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	
	public String getNumTel() {
		return NumTel;
	}
	
	public void setNumTel(String numTel) {
		NumTel = numTel;
	}
	
	public String getEntreprise() {
		return Entreprise;
	}
	
	public void setEntreprise(String entreprise) {
		Entreprise = entreprise;
	}
}
