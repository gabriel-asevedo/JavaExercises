package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Registration;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		try {
			System.out.print("Number of students: ");
			int number = sc.nextInt();

			Registration[] registration = new Registration[10];

			int room;

			System.out.println("\tRegistration");

			for (int i = 1; i <= number; i++) {
				do {
					System.out.printf("\t(Room #%d)\n", i);
					System.out.print("Room: ");
					room = sc.nextInt();
					if (room < 1 || room > 10) {
						System.out.println("Invalid room, try again!\n");
					}
				} while (room < 1 || room > 10);

				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Email: ");
				String email = sc.next();

				registration[room] = new Registration(name, email);
			}

			System.out.println("\n\tRegistration Data");

			for (int i = 0; i < registration.length; i++) {
				if (registration[i] != null) {
					System.out.println("[Room " + i + "]");
					System.out.println(registration[i] + "\n");
				}

			}
		} catch (RuntimeException e) {
			System.out.println("ERROR: Data entered incorrectly");
		}
		sc.close();
	}

}
