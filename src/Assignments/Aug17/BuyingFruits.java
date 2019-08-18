package Assignments.Aug17;

import java.util.Scanner;

public class BuyingFruits {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int[][] arr = new int[3][3];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = scn.nextInt();
			}
		}

		int[][] strg = new int[arr.length][arr[0].length];

		for (int i = 0; i < strg[0].length; i++) {
			strg[0][i] = arr[0][i];
		}

		for (int row = 1; row < strg.length; row++) {
			for (int col = 0; col < strg[0].length; col++) {

				int minFromPrevRow = Integer.MAX_VALUE;

				for (int k = 0; k < strg[0].length; k++) {

					if (k != col) {
						minFromPrevRow = Math.min(minFromPrevRow, strg[row - 1][k]);
					}
				}

				strg[row][col] = minFromPrevRow + arr[row][col];

			}

		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < strg[0].length; i++) {
			min = Math.min(min, strg[strg.length - 1][i]);
		}

		System.out.println(min);

	}
}
