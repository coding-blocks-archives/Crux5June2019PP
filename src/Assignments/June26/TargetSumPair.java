package Assignments.June26;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 26-Jun-2019
 *
 */

public class TargetSumPair {

	public static void main(String[] args) {

		int[] arr = { 3, 4, 6, 9, 11, 14, 18 };
		int target = 20;

		int left = 0;
		int right = arr.length - 1;

		while (left < right) {

			int sum = arr[left] + arr[right];

			if (sum > target) {
				right--;
			} else if (sum < target) {
				left++;
			} else {
				System.out.println(arr[left] + " and " + arr[right]);
				left++;
				right--;
			}

		}

	}
}



