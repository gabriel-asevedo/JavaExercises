package entities;

public class LegalPerson extends Person {

	private Integer employeeNumber;

	public LegalPerson() {
		super();
	}

	public LegalPerson(String name, Double annualIncome, Integer employeeNumber) {
		super(name, annualIncome);
		this.employeeNumber = employeeNumber;
	}

	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	@Override
	public double taxPaid() {
		double tax;
		if (employeeNumber > 10) {
			tax = annualIncome * 14 / 100;
		} else {
			tax = annualIncome * 16 / 100;
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
