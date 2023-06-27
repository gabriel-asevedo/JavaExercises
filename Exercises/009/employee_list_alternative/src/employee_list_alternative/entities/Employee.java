package employee_list_alternative.entities;

public class Employee {

	private Long id;
	private String name;
	private Double salary;

	public Employee() {
	}

	public Employee(Long id, String name, Double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void increaseSalary(Double percentage) {
		salary += salary * percentage / 100;

	}

	@Override
	public String toString() {
		return id + ", " + name + ", " + String.format("$%.2f", salary);
	}

}
