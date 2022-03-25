package entities;

public class CurrencyConverter {

	private Double dollarQuotation;

	public CurrencyConverter() {
		super();
	}

	public CurrencyConverter(Double dollarQuotation) {
		this.dollarQuotation = dollarQuotation;
	}

	public double buyDollars(double value) {
		value = value * dollarQuotation;
		return value += value * 6 / 100;
	}

	@Override
	public String toString() {
		return "\nAmount to be paid in your currency: $";
	}

	public Double getDollarQuotation() {
		return dollarQuotation;
	}

}
