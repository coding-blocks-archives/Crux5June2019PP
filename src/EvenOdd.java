import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 05-Jun-2019
 *
 */

public class EvenOdd {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int rem = n % 2;

		if (rem == 0) {
			System.out.println("even");
		} else {
			System.out.println("odd");
		}

	}

}






