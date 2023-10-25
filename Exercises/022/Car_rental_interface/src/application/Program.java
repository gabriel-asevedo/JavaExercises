package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		try {
			System.out.println("Enter rental data");
			System.out.print("Car model: ");
			String carModel = sc.nextLine();
			System.out.print("Withdrawal (dd/MM/yyyy hh:mm): ");
			LocalDateTime start = LocalDateTime.parse(sc.nextLine(), dtf);
			System.out.print("Return (dd/MM/yyyy hh:mm): ");
			LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), dtf);

			CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));

			System.out.print("Enter hourly price: $");
			Double pricePerHour = sc.nextDouble();
			System.out.print("Enter price per day: $");
			Double pricePerDay = sc.nextDouble();

			RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());

			rentalService.processInvoice(carRental);

			System.out.println("\nINVOICE:");
			System.out.printf("Basic pay: $%,.2f\n", carRental.getInvoice().getBasicPayment());
			System.out.printf("Tax: $%,.2f\n", carRental.getInvoice().getTax());
			System.out.printf("Total payment: $%,.2f\n", carRental.getInvoice().getTotalPayment());

		} catch (InputMismatchException e) {
			System.out.println("Error: Data entered incorrectly.");
		} catch (DateTimeParseException e) {
			System.out.println("Error: The date was entered incorrectly. Make sure you enter the correct model and try again.");
		} catch (Exception e) {
			System.out.println("Unexpected error.");
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

	}

}
