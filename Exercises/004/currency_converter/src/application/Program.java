package application;

import java.util.Locale;
import java.util.Scanner;

import entities.CurrencyConverter;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		try {
			System.out.print("What is the dollar price? $");
			double dollar = sc.nextDouble();
			System.out.print("How many dollars will be bought? $");
			double value = sc.nextDouble();

			CurrencyConverter conversion = new CurrencyConverter(dollar);

			System.out.println(conversion + String.format("%.2f", conversion.buyDollars(value)));
		
		} catch (InputMismatchException i) {
			System.out.println("Error: Incorrectly entered data.");
		} catch (RuntimeException e) {
			System.out.println("Unexpected error.");
		} finally {
			sc.close();
		}

	}

}