package employee_list_alternative.application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import employee_list_alternative.entities.Employee;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Employee> employee = new ArrayList<>();

		try {
			System.out.print("Number of Employees: ");
			int number = sc.nextInt();

			for (int i = 0; i < number; i++) {
				System.out.printf("\nEmployee #%d\n", i + 1);
				System.out.print("Id: ");
				Long id = sc.nextLong();
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Salary: $");
				double salary = sc.nextDouble();

				employee.add(new Employee(id, name, salary));
			}

			System.out.print("\nInform the employee id for salary increase: ");
			Long idEmployee = sc.nextLong();
			Employee hasId = hasId(employee, idEmployee);

			if (hasId != null) {
				System.out.print("Enter the percentage to increase:");
				double percentage = sc.nextDouble();
				hasId.increaseSalary(percentage);
			} else {
				System.out.print("\nThis id does not exist!\n\n");
			}

			System.out.println("\n___Employee List___");
			for (Employee emp : employee) {
				System.out.println(emp);
			}

		} catch (InputMismatchException e) {
			System.out.println("ERROR! Data entered incorrectly");
		} catch (RuntimeException e) {
			System.out.println("Unexpected error!");
		} finally {
			sc.close();
		}
	}

	public static Employee hasId(List<Employee> list, Long idEmployee) {
		for (Employee emp : list) {
			if (idEmployee.equals(emp.getId())) {
				return emp;
			}
		}
		return null;
	}

}
