package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.LegalPerson;
import entities.NaturalPerson;
import entities.Person;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		List<Person> list = new ArrayList<>();

		try {
			System.out.print("Number of taxpayers: ");
			int number = sc.nextInt();

			for (int i = 0; i < number; i++) {
				System.out.printf("\n\tTaxpayer #%d\t\n", i + 1);
				System.out.print("Natural Person or Legal Person? (n/l): ");
				String option = sc.next();

				while (validation(option)) {
					System.out.print("Invalid option, Try Again (n/l): ");
					option = sc.next();
				}

				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Annual income: $");
				double annualIncome = sc.nextDouble();

				if (option.equalsIgnoreCase("n")) {
					System.out.print("Health spending: $");
					double HealthSpending = sc.nextDouble();
					list.add(new NaturalPerson(name, annualIncome, HealthSpending));

				} else if (option.equalsIgnoreCase("l")) {
					System.out.print("Number of company employees: ");
					int employeeNumber = sc.nextInt();
					list.add(new LegalPerson(name, annualIncome, employeeNumber));

				}
			}

			System.out.println("\n\tTax Paid:");

			double totalTaxes = 0.0;
			for (Person person : list) {
				totalTaxes += person.taxPaid();
			}

			for (Person person : list) {
				System.out.println(person);
			}

			System.out.println("\n\tTotal Tax:");
			System.out.println(String.format("$%.2f", totalTaxes));

		} catch (InputMismatchException i) {
			System.out.println("Error: Incorrectly entered data.");
		} catch (RuntimeException e) {
			System.out.println("Unexpected error.");
		} finally {
			sc.close();
		}
	}

	public static Boolean validation(String option) {
		return (option.equalsIgnoreCase("n")) || (option.equalsIgnoreCase("l")) ? false : true;
	}

}
