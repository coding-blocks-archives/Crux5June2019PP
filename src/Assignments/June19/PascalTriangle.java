package Assignments.June19;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 19-Jun-2019
 *
 */

public class PascalTriangle {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		pascalTriangle2(n);

	}

	public static void pascalTriangle1(int n) {

		for (int r = 0; r < n; r++) {

			int val = 1;
			for (int c = 0; c <= r; c++) {
				System.out.print(val);
				val = (val * (r - c)) / (c + 1);
			}
			System.out.println();
		}

	}

	public static void pascalTriangle2(int n) {

		int[][] arr = new int[n][n];

		for (int r = 0; r < arr.length; r++) {

			for (int c = 0; c <= r; c++) {

				if (c == 0) {
					arr[r][c] = 1;
				} else {
					arr[r][c] = arr[r - 1][c - 1] + arr[r - 1][c];
				}
			}
		}

		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c <= r; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
	}

}
