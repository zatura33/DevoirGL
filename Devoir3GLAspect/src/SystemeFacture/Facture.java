package SystemeFacture;

import java.util.List;

import SystemePaiement.*;
import application.DataBase;

public class Facture
{
	private String NumFacture;
	private double Montant;
	private boolean estPaye;
	private Vente vente;
	private ICalculTaxes CalculTaxes;


	public Facture(String numFacture, double montant, boolean estPaye, Vente vente, Province laProvince) 
	{
		NumFacture = numFacture;
		Montant = montant;
		this.estPaye = estPaye;
		this.vente = vente;

		switch(laProvince) 
		{
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
	
	public Facture() {}

	public String getNumFacture() 
	{
		return NumFacture;
	}

	public void setNumFacture(String numFacture) 
	{
		NumFacture = numFacture;
	}

	public double getMontant() 
	{
		return Montant;
	}

	public void setMontant(double montant) 
	{
		Montant = montant;
	}

	public boolean isEstPaye() 
	{
		return estPaye;
	}

	public void setEstPaye(boolean estPaye) 
	{
		this.estPaye = estPaye;
	}

	public Vente getVente() 
	{
		return vente;
	}

	public void setVente(Vente vente) 
	{
		this.vente = vente;
	}
	
	public Facture ReturnFactureByNumFacture(String NumFacture) 
	{
		List<Facture> listFacture = DataBase.GetFacture();
		
		for (int i = 0; i< listFacture.size(); i++) {
			if (listFacture.get(i).getNumFacture() == NumFacture) {
				return listFacture.get(i);
			}
		}
		return null;
	}
	
	public Paiement CreatePaiement(ModePaiement modePaiement) 
	{
		Paiement paiement = new Paiement(modePaiement,this.getMontant(),this);
		return paiement;
	}
}
