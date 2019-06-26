package Assignments.June26;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 26-Jun-2019
 *
 */

public class RainWaterTrapping {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		while (tc > 0) {
			int n = scn.nextInt();

			int[] arr = new int[n];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}

			int[] l = new int[arr.length];
			l[0] = arr[0];

			for (int i = 1; i < l.length; i++) {
				l[i] = Math.max(l[i - 1], arr[i]);
			}

			int[] r = new int[arr.length];
			r[r.length - 1] = arr[arr.length - 1];

			for (int i = r.length - 2; i >= 0; i--) {
				r[i] = Math.max(r[i + 1], arr[i]);
			}

			int sum = 0;

			for (int b = 0; b < arr.length; b++) {
				sum += Math.min(l[b], r[b]) - arr[b];
			}

			System.out.println(sum);

			tc--;
		}

	}
}
