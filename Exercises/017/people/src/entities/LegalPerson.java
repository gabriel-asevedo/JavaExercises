package entities;

public class LegalPerson extends Person {

	private Integer employeeNumber;

	public LegalPerson() {
	}

	public LegalPerson(String name, Double annualIncome, Integer employeeNumber) {
		super(name, annualIncome);
		this.employeeNumber = employeeNumber;
	}

	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	@Override
	public final double taxPaid() {
		return (employeeNumber > 10) ? annualIncome * 0.14 : annualIncome * 0.16;
	}

	@Override
	public final String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + String.format("\t$%.2f", taxPaid()));
		return sb.toString();
	}

}
