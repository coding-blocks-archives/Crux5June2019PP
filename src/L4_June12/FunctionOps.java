package L4_June12;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Jun-2019
 *
 */

public class FunctionOps {

	public static void main(String[] args) {

		// printPrimes(10, 200);
		printArmstrong(0, 1000);
	}

	public static void printPrimes(int lo, int hi) {

		for (int n = lo; n <= hi; n++) {

			boolean res = isPrime(n);
			if (res)
				System.out.println(n);

		}
	}

	public static boolean isPrime(int n) {

		int div = 2;

		while (div <= n - 1) {

			if (n % div == 0) {
				return false;
			}

			div++;
		}

		return true;
	}

	public static void printArmstrong(int lo, int hi) {

		for (int n = lo; n <= hi; n++) {

			boolean res = isArmstrong(n);

			if (res)
				System.out.println(n);
		}
	}

	public static boolean isArmstrong(int n) {

		int nod = numberOfDigits(n);

		int temp = n;
		int ans = 0;

		while (n != 0) {

			int rem = n % 10;
			ans = ans + (int) Math.pow(rem, nod);
			n = n / 10;

		}

		if (temp == ans) {
			return true;
		} else {
			return false;
		}

	}

	public static int numberOfDigits(int n) {

		int count = 0;

		while (n != 0) {
			count++;
			n = n / 10;
		}

		return count;
	}

}
