package Assignments.Aug17;

import java.util.Scanner;

public class LIS {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = scn.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println(lis(arr, i));
		}

		System.out.println(lisBU(arr));
	}

	public static int lis(int[] arr, int vidx) {

		int max = 1;
		for (int i = vidx + 1; i < arr.length; i++) {

			if (arr[i] > arr[vidx])
				max = Math.max(lis(arr, i) + 1, max);
		}

		return max;
	}

	public static int lisBU(int[] arr) {
		int n = arr.length;
		int[] strg = new int[n];

		for (int i = 0; i < strg.length; i++) {

			strg[i] = 1;

			for (int j = 0; j < i; j++) {

				if (arr[j] < arr[i]) {
					strg[i] = Math.max(strg[i], strg[j] + 1);
				}

			}

		}

		int max = Integer.MIN_VALUE;

		for (int val : strg) {
			max = Math.max(max, val);
		}

		return max;

	}
}
