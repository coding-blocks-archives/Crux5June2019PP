package Assignments.June19;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 19-Jun-2019
 *
 */

public class BostonNumber {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int digitSum = sumOfDigits(n);

		int factorSum = 0;

		int on = n;
		for (int i = 2; i * i <= on; i++) {

			if (isPrime(i)) {

				while (n % i == 0) {
					n = n / i;
					factorSum += sumOfDigits(i);
				}
			}

		}

		if (n > 1)
			factorSum += sumOfDigits(n);

		if (factorSum == digitSum) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

	public static boolean isPrime(int n) {

		int div = 2;

		while (div * div <= n) {

			if (n % div == 0) {
				return false;
			}

			div++;
		}

		return true;
	}

	public static int sumOfDigits(int n) {

		int sum = 0;

		while (n != 0) {
			int rem = n % 10;
			sum += rem;
			n = n / 10;
		}

		return sum;

	}

}
