package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		List<Employee> list = new ArrayList<>();

		try {
			System.out.print("Number of employees: ");
			int number = sc.nextInt();

			for (int i = 0; i < number; i++) {
				System.out.printf("\n\tEmployee #%d\n", i + 1);
				System.out.print("Is the employee outsourced? (y/n): ");
				String option = sc.next();
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Worked hours: ");
				int hours = sc.nextInt();
				System.out.print("Value per hour: $");
				double valuePerHour = sc.nextDouble();

				if (option.equalsIgnoreCase("y")) {
					System.out.print("Which the additional charge? ");
					double additionalCharge = sc.nextDouble();

					list.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
				} else {
					list.add(new Employee(name, hours, valuePerHour));
				}

			}

			System.out.println();
			System.out.println("PAYMENTS:");
			for (Employee emp : list) {
				System.out.println(emp);
			}
		} catch (InputMismatchException i) {
			System.out.println("Error: Incorrectly entered data.");
		} catch (RuntimeException e) {
			System.out.println("Unexpected error.");
		} finally {
			sc.close();
		}
	}

}
