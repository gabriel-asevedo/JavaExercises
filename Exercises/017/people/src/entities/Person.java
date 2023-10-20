package entities;

public abstract class Person {

	protected String name;
	protected Double annualIncome;

	public Person() {
	}

	public Person(String name, Double annualIncome) {
		this.name = name;
		this.annualIncome = annualIncome;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAnnualIncome() {
		return annualIncome;
	}

	public abstract double taxPaid();

	@Override
	public abstract String toString();

}
