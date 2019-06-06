import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 05-Jun-2019
 *
 */

public class Fibonacci {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int a = 0;
		int b = 1;

		int count = 1;

		while (count <= n + 1) {

			System.out.println(a);
			
			int sum = a + b;
			a = b;
			b = sum;

			count = count + 1;
		}

	}
}








