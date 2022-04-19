package entities;

public class NaturalPerson extends Person {

	private Double healthSpending;

	public NaturalPerson() {
		super();
	}

	public NaturalPerson(String name, Double annualIncome, Double healthSpending) {
		super(name, annualIncome);
		this.healthSpending = healthSpending;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	@Override
	public double taxPaid() {
		double tax;

		if (annualIncome < 20000.00) {
			tax = annualIncome * 15 / 100;

			if (healthSpending != 0) {
				tax -= healthSpending * 50 / 100;
			}

		} else {
			tax = annualIncome * 25 / 100;

			if (healthSpending != 0) {
				tax -= healthSpending * 50 / 100;
			}
		}

		return tax;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + String.format("\t$%.2f", taxPaid()));
		return sb.toString();
	}

}
