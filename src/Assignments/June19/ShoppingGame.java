package Assignments.June19;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 19-Jun-2019
 *
 */

public class ShoppingGame {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		for (int c = 1; c <= tc; c++) {

			int al = scn.nextInt();
			int hl = scn.nextInt();

			int ac = 0;
			int hc = 0;

			int i = 1;

			while (true) {

				if (i % 2 == 1) // odd : aayush
				{
					if (ac + i <= al) {
						ac = ac + i;
					} else {
						System.out.println("Harshit");
						break;
					}

				} else {
					if (hc + i <= hl) {
						hc = hc + i;
					} else {
						System.out.println("Aayush");
						break;
					}

				}

				i++;

			}
		}

	}
}
