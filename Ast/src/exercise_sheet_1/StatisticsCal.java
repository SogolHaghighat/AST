package exercise_sheet_1;

import java.util.Scanner;

public class StatisticsCal {

	int numberOfInt;
	double[] listOfNumbers;
	Scanner sc1;
	double sum;
	double average;
	
	
	public static void main(String[] args) {
		StatisticsCal project01 = new StatisticsCal();
		project01.sc1 = new Scanner(System.in);
		do {
			project01.numberOfInt = project01.inputInt("Please enter an integer between 1 & 100.");
		} while (project01.numberOfInt < 0 || project01.numberOfInt > 101);
		
		project01.storeData();

		System.out.println("List of users input: ");
		for (int i = 0; i < project01.listOfNumbers.length; i++) {
			System.out.format("%.0f " , project01.listOfNumbers[i]);
		}
		
		System.out.println();
		
		project01.sum();
		project01.average();
		System.out.format("The sum of numbers is:      %.0f%n", project01.sum);
		System.out.format("The product of numbers is:  %.0f%n", project01.product());
		System.out.format("The average of numbers is:  %.0f%n", project01.average);
		System.out.format("The max of numbers is:      %.0f%n", project01.max());
		System.out.format("The min of numbers is:      %.0f%n", project01.min());
		System.out.format("The varinace of numbers is: %.0f%n", project01.variance());
		
		project01.sc1.close();
	}

	// taking an integer between from the user.
	public int inputInt(String printStatement) {
		int n = 0;
		
		System.out.println(printStatement);
		while (true) {
			if (sc1.hasNextInt()) {
				n = sc1.nextInt();
				break;
			} else {
				System.out.println("Please try again.");
					sc1.nextLine();
			}
		}
		return n;
	}

	// storing data.
	public void storeData() {
		listOfNumbers = new double[numberOfInt];
		for (int i = 1; i < numberOfInt + 1; i++) {
			listOfNumbers[i - 1] = inputInt("Please enter " + i + "th integer.");
		}
	}

	// doing statistical calculations
	public void sum() {
		sum = 0;
		for (int i = 0; i < listOfNumbers.length; i++) {
			sum += listOfNumbers[i];
		}
	}

	public double product() {
		double product;
		product = 1.0;
		for (int i = 0; i < listOfNumbers.length; i++) {
			product *= listOfNumbers[i];
		}
		return product;
	}

	public void average() {
		average = sum / numberOfInt;
	}

	public double max() {
		double max;
		max = listOfNumbers[0];
		for (int i = 0; i < listOfNumbers.length; i++) {
			if (listOfNumbers[i] > max) {
				max = listOfNumbers[i];
			}
		}
		return max;
	}

	public double min() {
		double min;
		min = listOfNumbers[0];
		for (int i = 0; i < listOfNumbers.length; i++) {
			if (listOfNumbers[i] < min) {
				min = listOfNumbers[i];
			}
		}
		return min;
	}

	public double variance() {
		double variance;
		variance = 0;
		for (int i = 0; i < listOfNumbers.length; i++) {
			variance += Math.pow((listOfNumbers[i] - average), 2);
		}
		variance /= numberOfInt;
		return variance;
	}

}
