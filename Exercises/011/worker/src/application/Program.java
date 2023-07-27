package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {
	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Worker Data");
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Worker level: JUNIOR, MID_LEVEL, SENIOR\nR:");
			WorkerLevel level = WorkerLevel.valueOf(sc.next());
			System.out.print("Base Salary: $");
			Double baseSalary = sc.nextDouble();
			System.out.print("Department name: ");
			sc.nextLine();
			String department = sc.nextLine();

			Worker worker = new Worker(name, level, baseSalary, new Department(department));

			System.out.print("\nNumber of contracts: ");
			int numberContracts = sc.nextInt();

			for (int i = 0; i < numberContracts; i++) {
				System.out.printf("\nContract #%d\n", i + 1);
				System.out.print("Date (dd/MM/yyyy): ");
				Date contractDate = sdf.parse(sc.next());
				System.out.print("Value per hour: $");
				Double valuePerHour = sc.nextDouble();
				System.out.print("Duration (hours): ");
				Integer hours = sc.nextInt();

				HourContract contract = new HourContract(contractDate, valuePerHour, hours);
				worker.addContract(contract);
			}

			System.out.print("\nEnter month and year to calculate income (MM/YYYY): ");
			String monthAndYear = sc.next();
			int month = Integer.parseInt(monthAndYear.substring(0, 2));
			int year = Integer.parseInt(monthAndYear.substring(3));

			System.out.println(worker);
			System.out.printf("Income for %s:  $%.2f", monthAndYear, worker.income(year, month));

		} catch (InputMismatchException e) {
			System.out.println("ERROR! Data entered incorrectly");
		} catch (RuntimeException e) {
			System.out.println("Unexpected error!");
		} finally {
			sc.close();
		}
	}
}
