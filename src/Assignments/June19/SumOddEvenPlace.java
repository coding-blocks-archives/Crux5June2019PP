package Assignments.June19;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 19-Jun-2019
 *
 */

public class SumOddEvenPlace {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int place = 1;
		int sumOdd = 0;
		int sumEven = 0;

		while (n != 0) {
			int rem = n % 10;

			if (place % 2 == 0) {
				sumEven += rem;
			} else {
				sumOdd += rem;
			}
			
			place++ ;
			n = n / 10;
		}
		
		System.out.println(sumOdd);
		System.out.println(sumEven);

	}
}
