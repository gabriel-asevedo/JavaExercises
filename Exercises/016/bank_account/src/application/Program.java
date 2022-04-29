package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exception.BusinessException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		try {
			System.out.println("\tAccount Data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance: $");
			double initialBalance = sc.nextDouble();
			System.out.print("Withdraw limit: $");
			double withdrawLimit = sc.nextDouble();

			Account acc = new Account(number, holder, initialBalance, withdrawLimit);

			System.out.println();
			System.out.print("Enter amount for withdraw: $");
			double amount = sc.nextDouble();
			acc.withdraw(amount);

			System.out.println(String.format("\nNew balance: $%.2f", acc.getBalance()));

		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("ERROR: Data entered incorrectly");
		}
		sc.close();

	}

}
