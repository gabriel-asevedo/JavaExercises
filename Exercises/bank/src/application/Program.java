package application;

import java.util.Locale;
import java.util.Scanner;

import entities.BankAccount;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		BankAccount account = new BankAccount();
		System.out.print("Account number: ");
		int accountNumber = sc.nextInt();
		System.out.print("Name of the account holder: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("Want to make an initial deposit? (y/n): ");
		String option = sc.next();

		if (option.equalsIgnoreCase("y")) {
			System.out.print("What the value ? $");
			double initialDeposit = sc.nextDouble();
			account = new BankAccount(accountNumber, name, initialDeposit);

		} else {
			account = new BankAccount(accountNumber, name);
		}

		System.out.println(account);

		System.out.print("Enter a deposit value: ");
		double deposit = sc.nextDouble();
		account.deposit(deposit);

		System.out.println(account);

		System.out.print("Enter a withdraw value: ");
		double withdraw = sc.nextDouble();
		account.withdraw(withdraw);

		System.out.println(account);

		sc.close();
	}

}
