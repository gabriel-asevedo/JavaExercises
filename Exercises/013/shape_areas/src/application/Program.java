package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		List<Shape> list = new ArrayList<>();

		try {
			System.out.print("Number of Shapes: ");
			int number = sc.nextInt();

			for (int i = 0; i < number; i++) {
				System.out.printf("\n\tShape #%d\n", i + 1);
				System.out.print("Rectangle or Circle? (r/c): ");
				String option = sc.next();
				System.out.print("Color: (Black/Blue/Red): ");
				Color color = Color.valueOf(sc.next());

				if (option.equalsIgnoreCase("r")) {
					System.out.print("Width: ");
					double width = sc.nextDouble();
					System.out.print("Height: ");
					double height = sc.nextDouble();

					list.add(new Rectangle(color, width, height));

				} else if (option.equalsIgnoreCase("c")) {
					System.out.print("Radius: ");
					double radius = sc.nextDouble();

					list.add(new Circle(color, radius));
				}
			}

			System.out.println();
			System.out.println("SHAPE AREAS:");

			for (Shape shape : list) {
				System.out.println(shape);
			}
		} catch (RuntimeException e) {
			System.out.println("ERROR: Data entered incorrectly");
		}
		sc.close();

	}

}
