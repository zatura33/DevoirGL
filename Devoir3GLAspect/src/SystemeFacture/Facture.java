package SystemeFacture;

import SystemePaiement.*;

public class Facture
{
	private String NumFacture;
	private double Montant;
	private boolean estPaye;
	private Vente vente;
	private ICalculTaxes CalculTaxes;


	public Facture(String numFacture, double montant, boolean estPaye, Vente vente, province laProvince) {
		NumFacture = numFacture;
		Montant = montant;
		this.estPaye = estPaye;
		this.vente = vente;

		switch(laProvince) {
		case AB:
			CalculTaxes = new CalculTaxesAB();
			break;
		case ON :
			CalculTaxes = new CalculTaxesON();
			break;
		case QC :
			CalculTaxes = new CalculTaxesQC();
			break;
		}

		Montant = CalculTaxes.CalculTaxes(montant);
	}

	public String getNumFacture() {
		return NumFacture;
	}


	public void setNumFacture(String numFacture) {
		NumFacture = numFacture;
	}


	public double getMontant() {
		return Montant;
	}


	public void setMontant(double montant) {
		Montant = montant;
	}


	public boolean isEstPaye() {
		return estPaye;
	}


	public void setEstPaye(boolean estPaye) {
		this.estPaye = estPaye;
	}


	public Vente getVente() {
		return vente;
	}


	public void setVente(Vente vente) {
		this.vente = vente;
	}
}
