package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Student;
import model.exceptions.StudentException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		try {
			System.out.print("Student Name: ");
			String name = sc.nextLine();
			System.out.print("Grade 1: ");
			double grade1 = sc.nextDouble();
			System.out.print("Grade 2: ");
			double grade2 = sc.nextDouble();
			System.out.print("Grade 3: ");
			double grade3 = sc.nextDouble();

			Student student = new Student(name, grade1, grade2, grade3);

			System.out.println("\n\tStudent Data");
			System.out.println(student);

		} catch (StudentException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("ERROR: Data entered incorrectly");
		}

		sc.close();
	}

}
