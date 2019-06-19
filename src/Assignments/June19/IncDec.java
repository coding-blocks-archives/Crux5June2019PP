package Assignments.June19;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 19-Jun-2019
 *
 */

public class IncDec {

	public static void main(String[] args) {
		System.out.println(incdec());
	}

	public static boolean incdec() {

		Scanner scn = new Scanner(System.in);
		boolean gd = true;

		int n = scn.nextInt();
		int prev = scn.nextInt();

		for (int i = 1; i <= n - 1; i++) {

			int curr = scn.nextInt();

			if (gd) {

				if (prev > curr) {

				} else {
					gd = false;
				}

			} else { // inc seq

				if (prev < curr) {

				} else {
					return false;
				}
			}
			
			prev = curr ;

		}

		return true;

	}
}
