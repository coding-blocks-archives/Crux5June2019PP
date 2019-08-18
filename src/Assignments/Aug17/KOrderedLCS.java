package Assignments.Aug17;

import java.util.Scanner;

public class KOrderedLCS {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int os = scn.nextInt();
		int ts = scn.nextInt();
		int k = scn.nextInt();

		int[] one = new int[os];

		for (int i = 0; i < one.length; i++) {
			one[i] = scn.nextInt();
		}

		int[] two = new int[ts];

		for (int i = 0; i < two.length; i++) {
			two[i] = scn.nextInt();
		}

		int[][][] strg = new int[k + 1][os + 1][ts + 1];

		for (int i = 0; i < strg.length; i++) {

			for (int j = 0; j < strg[i].length; j++) {
				for (int j2 = 0; j2 < strg[i][j].length; j2++) {
					strg[i][j][j2] = -1;
				}
			}
		}

		// System.out.println(kOrderedLCSRec(k, one, 0, two, 0));

		// System.out.println(kOrderedLCSTD(k, one, 0, two, 0, strg));

		System.out.println(kOrderedLCSBU(one, two, k));

	}

	public static int kOrderedLCSRec(int k, int[] one, int i, int[] two, int j) {

		if (i == one.length || j == two.length) {
			return 0;
		}

		int ans = 0;

		if (one[i] == two[j]) {
			ans = kOrderedLCSRec(k, one, i + 1, two, j + 1) + 1;
		} else {

			int o1 = kOrderedLCSRec(k, one, i, two, j + 1);
			int o2 = kOrderedLCSRec(k, one, i + 1, two, j);
			int o3 = 0;

			if (k >= 1)
				o3 = kOrderedLCSRec(k - 1, one, i + 1, two, j + 1) + 1;

			ans = Math.max(o1, Math.max(o2, o3));

		}

		return ans;
	}

	public static int kOrderedLCSTD(int k, int[] one, int i, int[] two, int j, int[][][] strg) {

		if (i == one.length || j == two.length) {
			return 0;
		}

		if (strg[k][i][j] != -1) {
			return strg[k][i][j];
		}

		int ans = 0;

		if (one[i] == two[j]) {
			ans = kOrderedLCSTD(k, one, i + 1, two, j + 1, strg) + 1;
		} else {

			int o1 = kOrderedLCSTD(k, one, i, two, j + 1, strg);
			int o2 = kOrderedLCSTD(k, one, i + 1, two, j, strg);
			int o3 = 0;

			if (k >= 1)
				o3 = kOrderedLCSTD(k - 1, one, i + 1, two, j + 1, strg) + 1;

			ans = Math.max(o1, Math.max(o2, o3));

		}

		strg[k][i][j] = ans;

		return ans;
	}

	public static int kOrderedLCSBU(int[] one, int[] two, int k) {

		int[][][] strg = new int[k + 1][one.length + 1][two.length + 1];

		for (int kl = 0; kl <= k; kl++) {

			for (int il = one.length - 1; il >= 0; il--) {

				for (int jl = two.length - 1; jl >= 0; jl--) {

					int ans;

					if (one[il] == two[jl]) {
						ans = strg[kl][il + 1][jl + 1] + 1;
					} else {

						int o1 = strg[kl][il][jl + 1];
						int o2 = strg[kl][il + 1][jl];
						int o3 = 0;

						if (kl >= 1)
							o3 = strg[kl - 1][il + 1][jl + 1] + 1;

						ans = Math.max(o1, Math.max(o2, o3));

					}

					strg[kl][il][jl] = ans;

				}
			}

		}

		return strg[k][0][0];

	}

}