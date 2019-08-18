package Assignments.Aug17;

import java.util.Scanner;

public class MinimumJumpsRequired {

	public static void main(String[] args) {

		int[] arr = { 3, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };

		System.out.println(minimumJumpsRec(arr, 0));
		System.out.println(minimumJumpsBU(arr));
	}

	public static int minimumJumpsRec(int[] arr, int curr) {

		if (curr == arr.length - 1) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= arr[curr]; i++) {

			if (curr + i <= arr.length - 1) {
				int ans = minimumJumpsRec(arr, curr + i);

				if (ans < min) {
					min = ans;
				}
			}

		}

		return min + 1;

	}

	public static int minimumJumpsTD(int[] arr, int curr, int[] strg) {

		if (curr == arr.length - 1) {
			return 0;
		}

		if (strg[curr] != 0) {
			return strg[curr];
		}

		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= arr[curr]; i++) {

			if (curr + i <= arr.length - 1) {
				int ans = minimumJumpsTD(arr, curr + i, strg);

				if (ans < min) {
					min = ans;
				}
			}

		}

		strg[curr] = min + 1;

		return min + 1;

	}

	public static int minimumJumpsBU(int[] arr) {

		int[] strg = new int[arr.length];

		for (int curr = strg.length - 2; curr >= 0; curr--) {

			int min = Integer.MAX_VALUE;

			for (int i = 1; i <= arr[curr]; i++) {

				if (curr + i <= arr.length - 1) {
					int ans = strg[curr + i];

					if (ans < min) {
						min = ans;
					}
				}

			}

			strg[curr] = min + 1;

		}

		return strg[0];

	}

}