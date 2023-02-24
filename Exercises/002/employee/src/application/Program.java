package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		try {
			System.out.print("Employee name: ");
			String name = sc.nextLine();
			System.out.print("Gross salary: $");
			double grossSalary = sc.nextDouble();
			System.out.print("Tax: $");
			double tax = sc.nextDouble();

			Employee emp = new Employee(name, grossSalary, tax);

			System.out.println("\nEmployee: " + emp);

			System.out.print("\nWhat percentage of salary increase? ");
			double increaseSalary = sc.nextDouble();
			emp.increaseSalary(increaseSalary);

			System.out.println("\nUpdate Salary: " + emp);

		} catch (InputMismatchException i) {
			System.out.println("Error: Incorrectly entered data.");
		} catch (RuntimeException e) {
			System.out.println("Unexpected error.");
		} finally {
			sc.close();
		}

	}

}
