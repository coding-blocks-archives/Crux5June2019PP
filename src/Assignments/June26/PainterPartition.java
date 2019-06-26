package Assignments.June26;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 26-Jun-2019
 *
 */

public class PainterPartition {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int nop = scn.nextInt();
		int nob = scn.nextInt();

		int[] arr = new int[nob];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		int lo = 0;
		int hi = 0;
		for (int val : arr)
			hi += val;

		int finalAns = 0;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (isItPossible(nop, nob, arr, mid)) {
				finalAns = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}

		}

		System.out.println(finalAns);

	}

	private static boolean isItPossible(int nop, int nob, int[] arr, int mid) {

		int painters = 1;
		int time = 0;

		int i = 0;

		while (i < arr.length) {

			if (time + arr[i] <= mid) {
				time += arr[i];
				i++;
			} else {
				painters++;
				time = 0;

				if (painters > nop) {
					return false;
				}
			}

		}

		return true;

	}
}
