package entities;

public class NaturalPerson extends Person {

	private Double healthExpenses;

	public NaturalPerson() {
	}

	public NaturalPerson(String name, Double annualIncome, Double healthExpenses) {
		super(name, annualIncome);
		this.healthExpenses = healthExpenses;
	}

	public Double gethealthExpenses() {
		return healthExpenses;
	}

	@Override
	public final Double taxPaid() {
		Double value = (annualIncome < 20000.0) ? 0.15 : 0.25;
		return (healthExpenses == 0.0) ? annualIncome * value : annualIncome * value - healthExpenses * 0.50;
	}

	@Override
	public final String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + String.format("\t$%.2f", taxPaid()));
		return sb.toString();
	}

}
