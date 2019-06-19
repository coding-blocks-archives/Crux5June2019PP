package Assignments.June19;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 19-Jun-2019
 *
 */

public class ReplaceThemAll {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int ans = 0;
		int m = 1;

		if (n == 0) {
			System.out.println(5);
		} else {
			while (n != 0) {

				int rem = n % 10;

				if (rem == 0)
					rem = 5;

				ans = rem * m + ans;

				m = m * 10;
				n = n / 10;
			}

			System.out.println(ans);
		}
	}
}
