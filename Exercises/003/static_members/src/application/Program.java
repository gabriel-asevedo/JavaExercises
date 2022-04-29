package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Calculator;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		try {
			System.out.print("Enter radius: ");
			double radius = sc.nextDouble();

			System.out.printf("\nCircumference: %.2f\n", Calculator.circumference(radius));
			System.out.printf("Volume: %.2f\n", Calculator.volume(radius));
			System.out.printf("PI value: %.2f", Calculator.PI);
		} catch (RuntimeException e) {
			System.out.println("ERROR: Data entered incorrectly");
		}

		sc.close();

	}

}