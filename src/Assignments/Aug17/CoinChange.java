package Assignments.Aug17;

public class CoinChange {

	public static void main(String[] args) {

		int[] arr = { 2, 5, 3, 6 };
		int amount = 10;
		System.out.println(coins(arr, 0, amount));
		System.out.println(coinsTD(arr, 0, amount, new int[arr.length][amount + 1]));
		System.out.println(coinsBU(arr, amount));
	}

	public static int coins(int[] arr, int vidx, int amount) {

		if (arr.length == vidx) {
			return 0;
		}

		if (amount == 0) {
			return 1;
		}

		int inc = 0;

		if (arr[vidx] <= amount) {

			inc = coins(arr, vidx, amount - arr[vidx]);
		}

		int exc = coins(arr, vidx + 1, amount);

		return inc + exc;

	}

	public static int coinsTD(int[] arr, int vidx, int amount, int[][] strg) {

		if (vidx == arr.length || amount < 0) {
			return 0;
		}
		if (amount == 0)
			return 1;

		if (strg[vidx][amount] != 0)
			return strg[vidx][amount];

		int exc = coinsTD(arr, vidx + 1, amount, strg);
		int inc = coinsTD(arr, vidx, amount - arr[vidx], strg);

		strg[vidx][amount] = inc + exc;
		return inc + exc;
	}

	public static int coinsBU(int[] arr, int amount) {

		int[][] strg = new int[arr.length + 1][amount + 1];

		for (int row = arr.length; row >= 0; row--) {

			for (int col = 0; col <= amount; col++) {

				if (row == arr.length) {
					strg[row][col] = 0;
					continue;
				}

				if (col == 0) {
					strg[row][col] = 1;
					continue;
				}

				int inc = 0;
				if (arr[row] <= col) {
					inc = strg[row][col - arr[row]];
				}

				int exc = strg[row + 1][col];

				strg[row][col] = inc + exc;
			}
		}

		return strg[0][amount];
	}

	public static int coinsBUSE(int[] arr, int amount) {

		int[] strg = new int[amount + 1];

		for (int row = arr.length; row >= 0; row--) {

			for (int col = amount; col >= 0; col--) {

				if (row == arr.length) {
					strg[col] = 0;
					continue;
				}

				if (col == 0) {
					strg[col] = 1;
					continue;
				}

				int inc = 0;
				if (arr[row] <= col) {
					inc = strg[col - arr[row]];
				}

				int exc = strg[col];

				strg[col] = inc + exc;
			}
		}

		return strg[amount];
	}

}
