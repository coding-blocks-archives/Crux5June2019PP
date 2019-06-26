package Assignments.June26;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 26-Jun-2019
 *
 */

public class MaxCircularSum {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		while (tc > 0) {
			int n = scn.nextInt();

			int[] arr = new int[n];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}

			int max = Integer.MIN_VALUE;

			for (int si = 0; si < arr.length; si++) {

				int sum = 0;

				for (int ei = si; ei < si + arr.length; ei++) {

					int k = ei % arr.length;
					sum += arr[k];

					if (sum > max)
						max = sum;
				}
			}

			System.out.println(max);
			tc--;
		}

	}
}
