package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Rectangle;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		try {
			System.out.print("Enter the width of the rectangle: ");
			double width = sc.nextDouble();
			System.out.print("Enter the height of the rectangle: ");
			double height = sc.nextDouble();

			Rectangle rectangle = new Rectangle(width, height);

			System.out.println(rectangle);

		} catch (RuntimeException e) {
			System.out.println("!Error! Incorrectly entered data.");
		}
		sc.close();
	}

}
