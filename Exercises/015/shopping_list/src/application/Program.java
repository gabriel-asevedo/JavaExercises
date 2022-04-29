package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		try {
			System.out.println("\tEnter Client Data: ");
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.next();
			System.out.print("Birth date (DD/MM/YYYY): ");
			Date birthDate = sdf.parse(sc.next());

			Client client = new Client(name, email, birthDate);

			System.out.println("\n\tEnter Order Data:");
			System.out.print("Status:\n \tPENDING_PAYMENT,\n" + "	PROCESSING,\n" + "	SHIPPED,\n" + "	DELIVERED\n: ");
			OrderStatus status = OrderStatus.valueOf(sc.next());

			Order order = new Order(new Date(), status, client);

			System.out.print("\nHow many items to this order? ");
			int numberItems = sc.nextInt();

			for (int i = 0; i < numberItems; i++) {
				System.out.println("\n\tEnter #" + (i + 1) + " item data: ");
				System.out.print("Product name: ");
				sc.nextLine();
				String productName = sc.nextLine();
				System.out.print("Product price: $");
				double productPrice = sc.nextDouble();
				System.out.print("Quantity: ");
				int quantity = sc.nextInt();

				Product product = new Product(productName, productPrice);

				OrderItem it = new OrderItem(quantity, productPrice, product);

				order.addItem(it);
			}

			System.out.println();
			System.out.println(order);

		} catch (ParseException e) {
			System.out.println("ERROR: Invalid date format");
		} catch (RuntimeException e) {
			System.out.println("ERROR: Data entered incorrectly");
		}

		sc.close();
	}

}
