package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Number of products: ");
			int number = sc.nextInt();

			for (int i = 0; i < number; i++) {
				System.out.printf("\n\tProduct #%d\n", i + 1);
				System.out.print("Common, Used or Imported? (c/u/i): ");
				String option = sc.next();
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.next();
				System.out.print("Price: $");
				double price = sc.nextDouble();

				if (option.equalsIgnoreCase("c")) {

					list.add(new Product(name, price));

				} else if (option.equalsIgnoreCase("u")) {
					System.out.print("Manufacture Date (dd/MM/yyyy): ");
					Date manufactureDate = sdf.parse(sc.next());

					list.add(new UsedProduct(name, price, manufactureDate));

				} else if (option.equalsIgnoreCase("i")) {
					System.out.print("Customs Fee: $");
					double customsFee = sc.nextDouble();

					list.add(new ImportedProduct(name, price, customsFee));

				}
			}

			System.out.println();
			System.out.println("\tPRICE TAGS:\n");

			for (Product product : list) {
				System.out.println(product.priceTag());
			}
		} catch (ParseException e) {
			System.out.println("Error: Invalid date format");
		} catch (InputMismatchException i) {
			System.out.println("Error: Incorrectly entered data.");
		} catch (RuntimeException e) {
			System.out.println("Unexpected error.");
		} finally {
			sc.close();
		}
	}

}
