package Assignments.Aug17;

import java.util.Scanner;

public class MinimumMoneyNeeded {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int w = scn.nextInt();
		int[] price = new int[w + 1];

		for (int i = 1; i < price.length; i++) {
			price[i] = scn.nextInt();
		}

		int[][] strg = new int[w + 1][w + 1];
		System.out.println(minMoney(price, 1, w, strg));
		System.out.println(minMoney(price, w));
	}

	public static int minMoney(int[] price, int vidx, int cap, int[][] strg) {

		if (vidx == price.length) {
			return Integer.MAX_VALUE;
		}

		if (cap == 0) {
			return 0;
		}

		if (strg[vidx][cap] != 0) {
			return strg[vidx][cap];
		}

		int inc = Integer.MAX_VALUE;

		if ((vidx) <= cap && price[vidx] != -1) {
			inc = minMoney(price, vidx, cap - vidx, strg);
			if (inc != Integer.MAX_VALUE) {
				inc += price[vidx];
			}
		}

		int exc = minMoney(price, vidx + 1, cap, strg);

		return strg[vidx][cap] = Math.min(inc, exc);
	}

	public static int minMoney(int[] prices, int cap) {

		int[][] strg = new int[prices.length + 1][cap + 1];
		for (int row = prices.length; row >= 0; row--) {
			for (int col = 0; col <= cap; col++) {

				if (row == prices.length) {
					strg[row][col] = Integer.MAX_VALUE;
					continue;
				}

				if (col == 0) {
					strg[row][col] = 0;
					continue;
				}

				int inc = Integer.MAX_VALUE;

				if (prices[row] != -1 && row <= col) {
					inc = strg[row][col - row];
					if (inc != Integer.MAX_VALUE) {
						inc += prices[row];
					}
				}

				int exc = strg[row + 1][col];

				strg[row][col] = Math.min(inc, exc);

			}
		}
		return strg[1][cap];

	}

}
