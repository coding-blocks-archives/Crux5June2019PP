package Assignments.June19;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 19-Jun-2019
 *
 */

public class Chewbacca {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		long n = scn.nextLong();

		long ans = 0;
		long m = 1;

		while (n != 0) {

			long rem = n % 10;

			if (rem >= 5 && n != 9) {
				rem = 9 - rem;
			}

			ans = rem * m + ans;

			m = m * 10;
			n = n / 10;
		}

		System.out.println(ans);
	}
}
