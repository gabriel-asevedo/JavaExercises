package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Student;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		System.out.print("Student Name: ");
		String name = sc.nextLine();

		double grade1, grade2, grade3;
		do {
			System.out.print("Grade 1: ");
			grade1 = sc.nextDouble();
			System.out.print("Grade 2: ");
			grade2 = sc.nextDouble();
			System.out.print("Grade 3: ");
			grade3 = sc.nextDouble();

			if (grade1 > 30 || grade2 > 35 || grade3 > 35) {
				System.out.println("\nIncorrect information entered!");
				System.out.println("Grade 1 limit is 30.\nGrade 2 and Grade 3 limit is 35.\nPlease re-enter data.\n");
			}

		} while (grade1 > 30 || grade2 > 35 || grade3 > 35);

		Student student = new Student(name, grade1, grade2, grade3);

		System.out.println("\n\t(Student Data)");
		System.out.println(student);

		if (student.finalGrade() > 60) {
			System.out.println("(PASS)");
		} else {
			System.out.println("(FAILED)");
			System.out.println("MISSING: " + student.pointsToPass());
		}

		sc.close();

	}

}
