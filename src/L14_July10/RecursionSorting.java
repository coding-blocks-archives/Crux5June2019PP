package L14_July10;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Jul-2019
 *
 */

public class RecursionSorting {

	public static void main(String[] args) {

		int[] arr = { 50, 40, 30, 8, 9, 6 };

		int[] ans = mergeSort(arr, 0, arr.length - 1);
		
		for(int val : ans) {
			System.out.println(val);
		}
	}

	public static int[] mergeTwoSortedArrays(int[] one, int[] two) {

		int[] ans = new int[one.length + two.length];

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				ans[k] = one[i];
				i++;
				k++;
			} else {
				ans[k] = two[j];
				j++;
				k++;
			}

		}

		if (i == one.length) {
			while (j < two.length) {
				ans[k] = two[j];
				j++;
				k++;
			}

		}

		if (j == two.length) {
			while (i < one.length) {
				ans[k] = one[i];
				i++;
				k++;
			}

		}

		return ans;

	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {

		if (lo == hi) {
			int[] br = new int[1];
			br[0] = arr[lo];
			return br;
		}

		int mid = (lo + hi) / 2;

		int[] fh = mergeSort(arr, lo, mid);
		int[] sh = mergeSort(arr, mid + 1, hi);

		int[] merged = mergeTwoSortedArrays(fh, sh);

		return merged;

	}

}
