package Assignments.Aug17;

import java.util.Arrays;
import java.util.Scanner;

public class LCS3 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		String s1 = scn.next();
		String s2 = scn.next();
		String s3 = scn.next();

		int[][][] strg = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];

		for (int[][] st : strg) {
			for (int[] s : st) {
				Arrays.fill(s, -1);
			}
		}
		System.out.println(lcs(s1, s2, s3, strg));
		System.out.println(lcsBU(s1, s2, s3));

	}

	public static int lcs(String s1, String s2, String s3, int[][][] strg) {

		if (s1.length() == 0 || s2.length() == 0 || s3.length() == 0) {
			return 0;
		}

		if (strg[s1.length()][s2.length()][s3.length()] != -1) {
			return strg[s1.length()][s2.length()][s3.length()];
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		char ch3 = s3.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		String ros3 = s3.substring(1);

		int ans = 0;
		if (ch1 == ch2 && ch1 == ch3) {

			ans = lcs(ros1, ros2, ros3, strg) + 1;
		} else {

			int fh = lcs(ros1, s2, s3, strg);
			int sh = lcs(s1, ros2, s3, strg);
			int th = lcs(s1, s2, ros3, strg);

			ans = Math.max(fh, Math.max(sh, th));

		}

		return strg[s1.length()][s2.length()][s3.length()] = ans;
	}

	public static int lcsBU(String s1, String s2, String s3) {

		int[][][] strg = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];

		for (int k = s3.length(); k >= 0; k--) {

			for (int i = s1.length(); i >= 0; i--) {

				for (int j = s2.length(); j >= 0; j--) {

					if (i == s1.length() || j == s2.length() || k == s3.length()) {
						strg[i][j][k] = 0;
						continue;
					}

					char ch1 = s1.charAt(i);
					char ch2 = s2.charAt(j);
					char ch3 = s3.charAt(k);

					if (ch1 == ch2 && ch2 == ch3) {

						strg[i][j][k] = strg[i + 1][j + 1][k + 1] + 1;
						continue;
					}

					int fh = strg[i + 1][j][k];
					int sh = strg[i][j + 1][k];
					int th = strg[i][j][k + 1];

					strg[i][j][k] = Math.max(fh, Math.max(sh, th));

				}
			}

		}

		return strg[0][0][0];

	}

}
