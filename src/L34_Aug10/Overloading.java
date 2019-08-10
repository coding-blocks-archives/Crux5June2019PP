package L34_Aug10;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Aug-2019
 *
 */

public class Overloading {

	public static void main(String[] args) {

		System.out.println(add(2, 3));
		System.out.println(add(2, 3, 4));
		System.out.println(add(2.6, 5.8));
		int[] arr = { 2, 3, 4, 5 };
		System.out.println(add(arr));
	}

	public static int add(int a, int b) {
		return a + b;
	}

	public static int add(int a, int b, int c) {
		return a + b + c;

	}

	public static int add(double a, double b) {
		return (int) (a + b);
	}

	public static int add(int... args) {
		int sum = 0;

		for (int val : args) {
			sum += val;
		}

		return sum;
	}

}




