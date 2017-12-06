package Tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import SystemePaiement.CalculTaxesAB;
import SystemePaiement.CalculTaxesON;
import SystemePaiement.CalculTaxesQC;
import SystemePaiement.ICalculTaxes;

public class TestCalculTaxes 
{
	private static double montantHT;
	private static double prixTTC;
	private ICalculTaxes calculTx;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		montantHT = 520;
		prixTTC = 0;
	}
	
	@Test
	public void testCalculTaxesQC() {

		prixTTC = montantHT * 1.05;
		prixTTC *= 1.09975;		
		calculTx  = new CalculTaxesQC();

		assertEquals("Le Prix TTC n'est pas correct",prixTTC, calculTx.CalculTaxes(montantHT),0);
	}
	
	@Test
	public void testCalculTaxesON() {

		prixTTC = montantHT * 1.05;
		prixTTC *= 1.08;		
		calculTx  = new CalculTaxesON();

		assertEquals("Le Prix TTC n'est pas correct",prixTTC, calculTx.CalculTaxes(montantHT),0);
	}
	
	@Test
	public void testCalculTaxesAB() {

		prixTTC = montantHT * 1.05;
		calculTx  = new CalculTaxesAB();

		assertEquals("Le Prix TTC n'est pas correct",prixTTC, calculTx.CalculTaxes(montantHT),0);
	}

}
