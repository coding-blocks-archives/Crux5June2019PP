package Assignments.June19;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 19-Jun-2019
 *
 */

public class PatternInvertedHG {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int nst = 1;
		int nsp = 2 * n - 1;

		for (int row = 1; row <= 2 * n + 1; row++) {

			int val = n;

			// stars
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print(val);
				val--;
			}

			// spaces
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			// stars

			int cst = 1;
			if (row == n + 1) {
				cst = 2;
				val++;
			}

			for (; cst <= nst; cst++) {
				val++;
				System.out.print(val);
			}

			// prep
			System.out.println();
			if (row <= n) {
				nsp -= 2;
				nst++;
			} else {
				nsp += 2;
				nst--;
			}

		}

	}
}
