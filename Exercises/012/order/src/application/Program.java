package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Client Data");
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.next();
			System.out.print("Birth Date (DD/MM/YYYY): ");
			Date birthDate = sdf.parse(sc.next());

			Client client = new Client(name, email, birthDate);

			System.out.println("Order Data");
			System.out.print("Status: ");
			OrderStatus status = OrderStatus.valueOf(sc.next());

			Order order = new Order(new Date(), status, client);

			System.out.print("How many items to this order? ");
			int numberOrder = sc.nextInt();

			for (int i = 0; i < numberOrder; i++) {
				System.out.printf("\nItem #%d\n", i + 1);
				System.out.print("Product name: ");
				sc.nextLine();
				String productName = sc.nextLine();
				System.out.print("Product price: $");
				Double productPrice = sc.nextDouble();
				System.out.print("Quantity: ");
				Integer productQuantity = sc.nextInt();

				OrderItem orderItem = new OrderItem(productQuantity, productPrice,
						new Product(productName, productPrice));

				order.addItem(orderItem);
			}

			System.out.println(order);

		} catch (ParseException e) {
			System.out.println("ERROR: Date entered incorrectly.");
		} catch (EnumConstantNotPresentException e) {
			System.out.println("ERROR: invalid 'status' option.");
		} catch (InputMismatchException e) {
			System.out.println("ERROR: Data entered incorrectly.");
		} catch (Exception e) {
			System.out.println("Unexpected ERROR.");
		} finally {
			sc.close();
		}

	}
}
