package model.entities;

import model.exceptions.StudentException;

public class Student {

	private String name;
	private Double grade1, grade2, grade3;

	public Student() {
		super();
	}

	public Student(String name, Double grade1, Double grade2, Double grade3) throws StudentException {

		if (grade1 > 30 || grade2 > 35 || grade3 > 35) {
			throw new StudentException(
					"ERROR: Grade 1 limit is 30, Grade 2 and Grade 3 limit is 35.\n" + "Please re-enter data.");
		}

		this.name = name;
		this.grade1 = grade1;
		this.grade2 = grade2;
		this.grade3 = grade3;
	}

	public double finalGrade() {
		return grade1 + grade2 + grade3;
	}

	public double pointsToPass() {
		return 60 - finalGrade();
	}

	@Override()
	public String toString() {

		if (finalGrade() > 60) {
			return name + String.format("\nFinal Grade: %.2f", finalGrade()) + " (PASS)";
		} else {
			return name + String.format("\nFinal Grade: %.2f", finalGrade()) + " (FAILED) \nMissing: "
					+ String.format("%.2f POINTS", pointsToPass());
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getGrade1() {
		return grade1;
	}

	public Double getGrade2() {
		return grade2;
	}

	public Double getGrade3() {
		return grade3;
	}

}
