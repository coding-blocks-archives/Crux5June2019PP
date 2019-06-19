package Assignments.June19;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 19-Jun-2019
 *
 */

public class FibonacciPattern {

	public static void main(String[] args) {

		int n = 4;

		int a = 0;
		int b = 1;

		for (int r = 1; r <= n; r++) {
			for (int c = 1; c <= r; c++) {
				
				System.out.print(a + " ");

				int sum = a + b;
				a = b;
				b = sum;
			}
			System.out.println();
		}
	}
}







