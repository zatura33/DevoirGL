	package SystemePaiement;
	
	import SystemeFacture.Facture;
	
	enum ModePaiement{Comptant, Cheque, Credit};
	
	public class Paiement {
	private ModePaiement modePaiement;
	private double Montant;
	private Facture facture;
	
	public Paiement(ModePaiement modePaiement, double montant, Facture facture) {
		this.modePaiement = modePaiement;
		Montant = montant;
		this.facture = facture;
	}
	public ModePaiement getModePaiement() {
		return modePaiement;
	}
	public void setModePaiement(ModePaiement modePaiement) {
		this.modePaiement = modePaiement;
	}
	public double getMontant() {
		return Montant;
	}
	public void setMontant(double montant) {
		Montant = montant;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
	}
