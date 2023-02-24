package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		try {
			System.out.print("Number of products: ");
			int number = sc.nextInt();

			Product[] vect = new Product[number];

			for (int i = 0; i < vect.length; i++) {
				System.out.printf("\tProduct #%d\n", i + 1);
				sc.nextLine();
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Price: $");
				double price = sc.nextDouble();

				vect[i] = new Product(name, price);
			}

			double sum = 0;

			for (Product product : vect) {
				sum += product.getPrice();
			}

			double averagePrice = sum / vect.length;

			System.out.println("\n((Product Data))");

			for (Product product : vect) {
				System.out.println(product);
			}

			System.out.printf("\nAverage Price $%.2f", averagePrice);

		} catch (InputMismatchException i) {
			System.out.println("Error: Incorrectly entered data.");
		} catch (RuntimeException e) {
			System.out.println("Unexpected error.");
		} finally {
			sc.close();
		}
	}

}
