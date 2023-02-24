package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		List<Employee> list = new ArrayList<>();
		try {
			System.out.print("How many employees will be registered? ");
			int number = sc.nextInt();

			for (int i = 0; i < number; i++) {
				System.out.printf("\nEmployee #%d", i + 1);
				System.out.print("\nId: ");
				int id = sc.nextInt();

				while (hasId(list, id)) {
					System.out.print("Id already taken! Try again: ");
					id = sc.nextInt();
				}

				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Salary: $");
				double salary = sc.nextDouble();

				list.add(new Employee(id, name, salary));
			}

			System.out.print("\nEnter the employee id that will have salary increase: ");
			int idsalary = sc.nextInt();
			Integer position = positionId(list, idsalary);

			if (position == null) {
				System.out.println("This Id does not exist!");
			} else {
				System.out.print("Enter the percentage: ");
				double percentage = sc.nextDouble();
				list.get(position).increaseSalary(percentage);
			}

			System.out.println("\n\tList of Employees");
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

	public static Integer positionId(List<Employee> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}

	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}
