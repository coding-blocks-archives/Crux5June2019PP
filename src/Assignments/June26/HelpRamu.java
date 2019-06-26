package Assignments.June26;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 26-Jun-2019
 *
 */

public class HelpRamu {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		while (tc > 0) {
			int c1 = scn.nextInt();
			int c2 = scn.nextInt();
			int c3 = scn.nextInt();
			int c4 = scn.nextInt();

			int nor = scn.nextInt();
			int noc = scn.nextInt();

			int[] rickshaw = new int[nor];
			for (int i = 0; i < rickshaw.length; i++) {
				rickshaw[i] = scn.nextInt();
			}

			int[] cabs = new int[noc];
			for (int i = 0; i < cabs.length; i++) {
				cabs[i] = scn.nextInt();
			}

			System.out.println(minCost(c1, c2, c3, c4, rickshaw, cabs));
			tc--;
		}

	}

	public static int minCost(int c1, int c2, int c3, int c4, int[] rickshaw, int[] cabs) {

		int rMinCost = minCostTransport(c1, c2, c3, c4, rickshaw);
		int cMinCost = minCostTransport(c1, c2, c3, c4, cabs);

		return Math.min(c4, rMinCost + cMinCost);

	}

	private static int minCostTransport(int c1, int c2, int c3, int c4, int[] transport) {

		int sum = 0;

		for (int i = 0; i < transport.length; i++) {
			sum += Math.min(c1 * transport[i], c2);
		}

		return Math.min(sum, c3);

	}

}
