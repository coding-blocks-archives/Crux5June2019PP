package Assignments.June26;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 26-Jun-2019
 *
 */

public class PairOfRoses {

	public static void main(String[] args) {

		int[] arr = { 3, 4, 6, 9, 11, 14, 18 };
		int target = 20;

		int fl = 0;
		int fr = 0;

		int left = 0;
		int right = arr.length - 1;

		while (left < right) {

			int sum = arr[left] + arr[right];

			if (sum > target) {
				right--;
			} else if (sum < target) {
				left++;
			} else {
				fl = left;
				fr = right;

				left++;
				right--;
			}

		}

		System.out.println("Deepak should buy roses whose prices are " + fl + " and " + fr + ".");

	}
}
