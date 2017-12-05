package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import SystemePaiement.CalculTaxesQC;
import SystemePaiement.ICalculTaxes;

public class TestCalculTaxesQC {

	@Test
	public void testCalculTaxes() {
		double montantHT = 520;
		double prixTTC = 0;
		prixTTC = montantHT * 1.05;
		prixTTC *= 1.09975;
		ICalculTaxes calculTx = new CalculTaxesQC();
		
		assertEquals("Le Prix TTC n'est pas correct",prixTTC, calculTx.CalculTaxes(montantHT),0);
	}

}
