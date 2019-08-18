package Assignments.Aug17;

public class UglyNumbers {

	public static void main(String[] args) {

		System.out.println(ugly(3));
	}

	public static long ugly(int n) {

		long[] strg = new long[n];

		long next_mult_2 = 2;
		long next_mult_3 = 3;
		long next_mult_5 = 5;

		int i2 = 0;
		int i3 = 0;
		int i5 = 0;

		strg[0] = 1;
		long next_ugly = 1;

		for (int i = 1; i < n; i++) {

			next_ugly = Math.min(next_mult_2, Math.min(next_mult_3, next_mult_5));
			strg[i] = next_ugly;

			if (next_ugly == next_mult_2) {

				i2 += 1;
				next_mult_2 = strg[i2] * 2;
			}

			if (next_mult_3 == next_ugly) {
				i3 += 1;
				next_mult_3 = strg[i3] * 3;
			}

			if (next_mult_5 == next_ugly) {
				i5 += 1;
				next_mult_5 = strg[i5] * 5;
			}

		}

		return next_ugly;

	}

}
