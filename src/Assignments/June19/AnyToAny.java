package Assignments.June19;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 19-Jun-2019
 *
 */

public class AnyToAny {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int sb = scn.nextInt();
		int db = scn.nextInt();
		int n = scn.nextInt();

		int ia = anybaseToDecimal(n, sb);
		int ans = decimalToAnybase(ia, db);

		System.out.println(ans);

	}

	public static int anybaseToDecimal(int n, int sb) {

		int ans = 0;

		int multiplier = 1;

		while (n != 0) {

			int rem = n % 10;
			ans = ans + rem * multiplier;

			multiplier = multiplier * sb;
			n = n / 10;

		}

		return ans;

	}

	public static int decimalToAnybase(int n, int db) {

		int ans = 0;

		int multiplier = 1;

		while (n != 0) {

			int rem = n % db;
			ans = ans + rem * multiplier;

			multiplier = multiplier * 10;
			n = n / db;

		}

		return ans;

	}
}
