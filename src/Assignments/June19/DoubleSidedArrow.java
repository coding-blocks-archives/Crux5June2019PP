package Assignments.June19;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 19-Jun-2019
 *
 */

public class DoubleSidedArrow {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		way2(n);
	}

	public static void way1(int n) {

		int start = 1;
		int nst = 1;
		int nsp1 = n - 1;
		int nsp2 = -1;

		for (int row = 1; row <= n; row++) {

			int val = start;

			// nsp1
			for (int csp = 1; csp <= nsp1; csp++) {
				System.out.print(" ");
			}

			// nst
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print(val);
				val--;
			}

			// nsp2
			for (int csp = 1; csp <= nsp2; csp++) {
				System.out.print(" ");
			}

			// nst
			int cst = 1;
			if (row == 1 || row == n)
				cst = 2;

			for (; cst <= nst; cst++) {
				val++;
				System.out.print(val);
			}

			// prep
			System.out.println();
			if (row <= n / 2) {
				start++;
				nst++;
				nsp1 -= 2;
				nsp2 += 2;
			} else {
				start--;
				nst--;
				nsp1 += 2;
				nsp2 -= 2;
			}
		}

	}

	public static void way2(int n) {

		int nst = 1;
		int nsp1 = n - 1;
		int nsp2 = -1;

		for (int row = 1; row <= n; row++) {

			int val;
			if (row <= n / 2)
				val = row;
			else
				val = n - row + 1;

			// nsp1
			for (int csp = 1; csp <= nsp1; csp++) {
				System.out.print(" ");
			}

			// nst
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print(val);
				val--;
			}

			// nsp2
			for (int csp = 1; csp <= nsp2; csp++) {
				System.out.print(" ");
			}

			// nst
			int cst = 1;
			if (row == 1 || row == n)
				cst = 2;

			for (; cst <= nst; cst++) {
				val++;
				System.out.print(val);
			}

			// prep
			System.out.println();
			if (row <= n / 2) {
				nst++;
				nsp1 -= 2;
				nsp2 += 2;
			} else {
				nst--;
				nsp1 += 2;
				nsp2 -= 2;
			}
		}

	}
}
