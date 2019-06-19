package Assignments.June19;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 19-Jun-2019
 *
 */

public class PatternHourGlass {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int start = n;
		int nst = 2 * n + 1;
		int nsp = 0;

		for (int row = 1; row <= 2 * n + 1; row++) {

			int val = start;

			// spaces
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			// stars
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print(val);

				if (cst <= nst / 2)
					val--;
				else
					val++;
			}

			// prep
			System.out.println();
			if (row <= n) {
				start--;
				nsp++;
				nst -= 2;
			} else {
				start++;
				nsp--;
				nst += 2;
			}

		}

	}
}
