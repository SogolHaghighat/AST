package exercise_sheet_1;

import java.util.Scanner;

public class PiCalc {

	double diameter;
	int precision;
	Scanner sc1;
	double area = 0;
	double oldArea;
	double areaError;
	double circumference = 0;
	double oldCircumference;
	double circumferenceError;
	double pieValue;
	String pie;
	String newPie;

	public PiCalc() {
		sc1 = new Scanner(System.in);
		pie = Double.toString(Math.PI);
	}

	public static void main(String[] args) {
		PiCalc project01 = new PiCalc();
		project01.inputPrecision();
		project01.inputDiameter();
		for (int i = 0; i < project01.precision + 1; i++) {
			project01.updatePie(i);
			project01.area();
			project01.circumference();
			System.out.println("for the value of pi:                            " + project01.pieValue);
			System.out.format("The area of the circle is:                      %.3f%n", project01.area);
			System.out.format("The percentage of increase in area is:          %.3f%n", project01.areaError);
			System.out.format("The circumference of the circle is:             %.3f%n", project01.circumference);
			System.out.format("The percentage of increase in circumference is: %.3f%n", project01.areaError);
			System.out.println("----------------------------------------------------------------");

		}

		project01.sc1.close();

	}

	public void inputDiameter() {
		System.out.println("Please enter the diameter: ");
		while (true) {
			if (sc1.hasNextInt() || sc1.hasNextDouble()) {
				diameter = sc1.nextDouble();
				if (diameter > 0) {
					break;
				} else {
					System.out.println("Please try again.");
					sc1.nextLine();
				}
			} else {
				System.out.println("Please try again.");
				sc1.nextLine();
			}
		}
	}

	public void inputPrecision() {
		System.out.println("Please enter the Pi precision: ");
		while (true) {
			if (sc1.hasNextInt()) {
				precision = sc1.nextInt();
				if (precision >= 0) {
					precision = Math.min(precision, 10);
					// System.out.println("maximum reasonable precision number
					// is 10");
					break;
				} else {
					System.out.println("Please try again.");
					sc1.nextLine();
				}

			} else {
				System.out.println("Please try again.");
				sc1.nextLine();
			}
		}

	}

	public void updatePie(int i) {
		newPie = pie.substring(0, i + 2);
		pieValue = Double.parseDouble(newPie);
	}

	public void area() {
		oldArea = area;
		area = pieValue * diameter * diameter / 4;
		if (oldArea == 0) {
			areaError = 100;
		} else {
			areaError = ((area - oldArea) / oldArea) * 100;
		}

	}

	public void circumference() {
		oldCircumference = circumference;
		circumference = pieValue * diameter;
		if (oldCircumference == 0) {
			circumferenceError = 100;
		} else {
			circumferenceError = ((circumference - oldCircumference) / oldCircumference) * 100;
		}

	}

}
