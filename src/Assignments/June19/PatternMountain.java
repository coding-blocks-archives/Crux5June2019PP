package Assignments.June19;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 19-Jun-2019
 *
 */

public class PatternMountain {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int nst = 1;
		int nsp = 2 * n - 3;

		for (int row = 1; row <= n; row++) {

			int val = 1;

			// stars
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print(val);
				val++;

			}

			// spaces
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			int cst = 1;
			if (row == n) {
				cst = 2;
				val--;
			}
			// stars
			for (; cst <= nst; cst++) {
				val--;
				System.out.print(val);
			}

			// prep
			System.out.println();
			nst++;
			nsp -= 2;

		}

	}
}
