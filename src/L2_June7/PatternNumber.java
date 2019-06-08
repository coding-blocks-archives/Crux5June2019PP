package L2_June7;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Jun-2019
 *
 */

public class PatternNumber {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = 5;

		int nst = 1;
		int nsp = n - 1;

		int row = 1;

		int val = 1;

		// no. of rows
		while (row <= n) {

			 val = 1 ;

			// work
			int csp = 1;
			while (csp <= nsp) {
				System.out.print("\t");
				csp = csp + 1;
			}

			int cst = 1;
			while (cst <= nst) {
				System.out.print(val + "\t");
				val = val + 1;
				cst = cst + 1;
			}

			// prep
			System.out.println();
			row = row + 1;
			nst = nst + 2;
			nsp = nsp - 1;

		}

	}
}
