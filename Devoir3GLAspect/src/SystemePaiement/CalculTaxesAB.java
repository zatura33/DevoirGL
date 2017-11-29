package SystemePaiement;

public class CalculTaxesAB implements ICalculTaxes 
{

	@Override
	public double CalculTaxes(double prixHorsTaxes) {
		double total = 0;
		total = prixHorsTaxes * 1.05;
		return total;
	}
}
