package SystemePaiement;

public class CalculTaxesON implements ICalculTaxes 
{
	@Override
	public double CalculTaxes(double prixHorsTaxes) 
	{
		double total = 0;
		total = prixHorsTaxes * 1.05;
		total *= 1.08;
		return total;
	}
}
