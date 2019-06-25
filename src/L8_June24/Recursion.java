package L8_June24;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Jun-2019
 *
 */

public class Recursion {

	public static void main(String[] args) {

		// PD(3);
		// System.out.println(factorial(4));

		// PD(2);
		int[] arr = { 10, 20, 30, 40, 50 };
		printRevArray(arr, 0);
	}

	public static void PD(int n) {

		if (n == 0)
			return;

		System.out.println(n);
		PD(n - 1);

	}

	public static void PI(int n) {

		if (n == 0)
			return;

		PI(n - 1);
		System.out.println(n);
	}

	public static void PDI(int n) {

		if (n == 0)
			return;

		System.out.println("Hi " + n);
		PDI(n - 1);
		System.out.println("Bye " + n);
	}

	public static void PDISkips(int n) {

		if (n == 0)
			return;

		if (n % 2 == 1)
			System.out.println(n);

		PDISkips(n - 1);

		if (n % 2 == 0)
			System.out.println(n);

	}

	public static int factorial(int n) {

		if (n == 1) {
			return 1;
		}

		// smaller problem
		int fnm1 = factorial(n - 1);

		// self work
		int fn = fnm1 * n;

		return fn;

	}

	public static int power(int x, int n) {

		// base case
		if (n == 0) {
			return 1;
		}

		// smaller problem
		int pnm1 = power(x, n - 1);

		// self work
		int pn = pnm1 * x;

		return pn;

	}

	public static int fibonacci(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		int fnm1 = fibonacci(n - 1);
		int fnm2 = fibonacci(n - 2);

		int fn = fnm1 + fnm2;

		return fn;

	}

	public static void printArray(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return;
		}

		System.out.println(arr[vidx]);

		printArray(arr, vidx + 1);
	}

	public static void printRevArray(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return;
		}

		printRevArray(arr, vidx + 1);
		System.out.println(arr[vidx]);

	}

	public static int max(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return Integer.MIN_VALUE;
		}

		int rr = max(arr, vidx + 1);

		if (rr > arr[vidx]) {
			return rr;
		} else {
			return arr[vidx];
		}

	}

	public static int findFirstIndex(int[] arr, int vidx, int item) {

		if (vidx == arr.length) {
			return -1;
		}

		if (arr[vidx] == item) {
			return vidx;
		}

		return findFirstIndex(arr, vidx + 1, item);

	}

	public static int findLastIndex(int[] arr, int vidx, int item) {

		if (vidx == arr.length) {
			return -1;
		}

		int rr =  findLastIndex(arr, vidx + 1, item);

		if (arr[vidx] == item && rr == -1) {
			return vidx;
		}
		
		return rr ;
	}

	public static int[] findAllIndex(int[] arr, int vidx, int item) {

	}

}
