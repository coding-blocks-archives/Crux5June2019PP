package L6_June17;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Jun-2019
 *
 */

public class Array2DOps {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		// int[][] arr = takeInput() ;

		// int[][] arr = { { 10, 20, 30, 40 }, { 50, 60, 70, 80 }, { 90, 12, 23, 56 } };
		// display(arr);
		// verticalDisplay(arr);
		// waveDisplay(arr);
		// spiralDisplay(arr);

		int[][] one = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int[][] two = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 } };
		int[][] res = matrixMultiplication(one, two);

		display(res);
	}

	public static int[][] takeInput() {

		System.out.println("Rows ?");
		int rows = scn.nextInt();

		int[][] arr = new int[rows][];

		for (int r = 0; r < arr.length; r++) {

			System.out.println("Cols for " + r + " row ?");
			int cols = scn.nextInt();

			arr[r] = new int[cols];

			for (int c = 0; c < arr[r].length; c++) {
				System.out.println("[" + r + "-" + c + "] ?");
				arr[r][c] = scn.nextInt();
			}

		}

		return arr;

	}

	public static void display(int[][] arr) {

		for (int r = 0; r < arr.length; r++) {

			for (int c = 0; c < arr[r].length; c++) {
				System.out.print(arr[r][c] + " ");
			}

			System.out.println();
		}

	}

	public static void verticalDisplay(int[][] arr) {

		for (int c = 0; c < arr[0].length; c++) {
			for (int r = 0; r < arr.length; r++) {

				System.out.print(arr[r][c] + " ");
			}
		}

		System.out.println();

	}

	public static void waveDisplay(int[][] arr) {

		for (int c = 0; c < arr[0].length; c++) {

			if (c % 2 == 0) {

				for (int r = 0; r < arr.length; r++) {
					System.out.print(arr[r][c] + " ");
				}

			} else {

				for (int r = arr.length - 1; r >= 0; r--) {
					System.out.print(arr[r][c] + " ");
				}
			}

		}

		System.out.println();

	}

	public static void spiralDisplay(int[][] arr) {

		int minRow = 0;
		int maxRow = arr.length - 1;
		int minCol = 0;
		int maxCol = arr[0].length - 1;

		int count = 0;
		int nel = arr.length * arr[0].length;

		while (count < nel) {

			// first col
			for (int r = minRow; r <= maxRow && count < nel; r++) {
				System.out.print(arr[r][minCol] + " ");
				count++;
			}
			minCol++;

			// last row
			for (int c = minCol; c <= maxCol && count < nel; c++) {
				System.out.print(arr[maxRow][c] + " ");
				count++;
			}
			maxRow--;

			// last col
			for (int r = maxRow; r >= minRow && count < nel; r--) {
				System.out.print(arr[r][maxCol] + " ");
				count++;
			}
			maxCol--;

			// first row
			for (int c = maxCol; c >= minCol && count < nel; c--) {
				System.out.print(arr[minRow][c] + " ");
				count++;
			}
			minRow++;

		}

	}

	public static int[][] matrixMultiplication(int[][] one, int[][] two) {

		int r1 = one.length;
		int c1 = one[0].length;
		int r2 = two.length;
		int c2 = two[0].length;

		int[][] ans = new int[r1][c2];

		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {

				int sum = 0;

				for (int k = 0; k < c1; k++) {
					sum = sum + one[i][k] * two[k][j];
				}

				ans[i][j] = sum;
			}

		}

		return ans;

	}

}
