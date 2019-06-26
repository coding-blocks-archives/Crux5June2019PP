package Assignments.June26;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 26-Jun-2019
 *
 */

public class BookAllocation {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		while (tc > 0) {
			int nob = scn.nextInt();
			int nos = scn.nextInt();

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

				if (isItPossible(nob, nos, arr, mid)) {
					finalAns = mid;
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}

			}

			System.out.println(finalAns);

			tc--;
		}

	}

	private static boolean isItPossible(int nob, int nos, int[] arr, int mid) {

		int student = 1;
		int pagesRead = 0;

		int i = 0;

		while (i < arr.length) {

			if (pagesRead + arr[i] <= mid) {
				pagesRead += arr[i];
				i++;
			} else {
				student++;
				pagesRead = 0;

				if (student > nos) {
					return false;
				}
			}

		}

		return true;

	}
}
