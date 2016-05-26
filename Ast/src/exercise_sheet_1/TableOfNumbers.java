package exercise_sheet_1;


public class TableOfNumbers {

	public static void main(String[] args) {
		for (int i = 1 ; i < 101 ; i++) {

			System.out.format("%10.0f %10.2f 10^%d %10.2f %10.2f %10.2f %n", 2.0*i, Math.pow(i, 0.5), i, Math.pow(i, 3.0), Math.pow(2.0, i), Math.exp(i));
			
		}
		

	}

}
