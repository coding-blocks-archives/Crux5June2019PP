package Assignments.June19;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 19-Jun-2019
 *
 */

public class PatternRhombus {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		way2(n);

	}

	public static void way2(int n) {

		int nsp = n - 1;
		int nst = 1;

		int row = 1;
		int start = 1 ;

		while (row <= 2 * n - 1) {

			int val = start ;

			// spaces
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			// stars
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print(val);

				if (cst <= nst / 2) {
					val++;
				} else {
					val--;
				}
			}

			// prep

			if (row <= n - 1) {
				nst += 2;
				nsp--;
				start++ ;
			} else {
				nst -= 2;
				nsp++;
				start-- ;
			}

			row++;
			System.out.println();
		}

	}

	public static void way1(int n) {

		int nsp = n - 1;
		int nst = 1;

		int row = 1;

		while (row <= 2 * n - 1) {

			int val;

			if (row <= n)
				val = row;
			else
				val = 2 * n - row;

			// spaces
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			// stars
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print(val);

				if (cst <= nst / 2) {
					val++;
				} else {
					val--;
				}
			}

			// prep

			if (row <= n - 1) {
				nst += 2;
				nsp--;
			} else {
				nst -= 2;
				nsp++;
			}

			row++;
			System.out.println();
		}

	}
}
