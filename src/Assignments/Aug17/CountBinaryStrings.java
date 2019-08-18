package Assignments.Aug17;

public class CountBinaryStrings {

	public static void main(String[] args) {
		
		System.out.println(count(5, 0));
		System.out.println(countTD(5, 0, new int[6][2]));
		System.out.println(countBU(5));
	}

	public static int count(int n, int lastUsed) {

		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return lastUsed == 0 ? 2 : 1;
		}

		if (lastUsed == 0) {

			return count(n - 1, 0) + count(n - 1, 1);
		}

		return count(n - 1, 0);
	}

	public static int countTD(int n, int lastUsed, int[][] strg) {

		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return lastUsed == 0 ? 2 : 1;
		}

		if (strg[n][lastUsed] != 0) {
			return strg[n][lastUsed];
		}

		if (lastUsed == 0) {

			return strg[n][lastUsed] = countTD(n - 1, 0, strg) + countTD(n - 1, 1, strg);
		}

		return strg[n][lastUsed] = countTD(n - 1, 0, strg);
	}

	public static int countBU(int n) {

		int[] Ezero = new int[n + 1];
		int[] Eone = new int[n + 1];

		Ezero[1] = Eone[1] = 1;

		for (int i = 2; i <= n; i++) {

			Ezero[i] = Ezero[i - 1] + Eone[i - 1];
			Eone[i] = Ezero[i - 1];
		}

		return Ezero[n] + Eone[n];
	}

}
