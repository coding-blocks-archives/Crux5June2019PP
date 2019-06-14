package L4_June12;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Jun-2019
 *
 */

public class ArrayOps {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		// int[] array = takeInput();
		// System.out.println(array);

		int[] array = { 100, 2, 78, 90 };
		// System.out.println(max(array));
		// System.out.println(linearSearch(array, 40));
		// System.out.println(binarySearch(array, 40));
		// display(array);

		// reverse(array);
		// rotate(array, 4);

		// display(inverse(array));

		// subarray(array);
		// subset(array);
		// display(array);
		// bubbleSort(array);
		selectionSort(array);

		display(array);

	}

	public static int[] takeInput() {

		System.out.println("Size ?");
		int n = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		return arr;

	}

	public static void display(int[] arr) {

		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	public static int max(int[] arr) {

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > max) {
				max = arr[i];
			}
		}

		return max;
	}

	public static int linearSearch(int[] arr, int item) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == item) {
				return i;
			}
		}

		return -1;

	}

	public static int binarySearch(int[] arr, int item) {

		int lo = 0;
		int hi = arr.length - 1;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (item > arr[mid]) {
				lo = mid + 1;
			} else if (item < arr[mid]) {
				hi = mid - 1;
			} else {
				return mid;
			}

		}

		return -1;

	}

	public static void reverse(int[] arr) {

		int lo = 0;
		int hi = arr.length - 1;

		while (lo < hi) {

			int temp = arr[lo];
			arr[lo] = arr[hi];
			arr[hi] = temp;

			lo++;
			hi--;

		}
	}

	public static void rotate(int[] arr, int rot) {

		rot = rot % arr.length;

		if (rot < 0) {
			rot = rot + arr.length;
		}

		for (int r = 1; r <= rot; r++) {

			int temp = arr[arr.length - 1];

			for (int i = arr.length - 1; i >= 1; i--) {
				arr[i] = arr[i - 1];
			}

			arr[0] = temp;

		}

	}

	public static int[] inverse(int[] arr) {

		int[] na = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			na[arr[i]] = i;
		}

		return na;

	}

	public static void subarray(int[] arr) {

		for (int si = 0; si < arr.length; si++) {

			for (int ei = si; ei < arr.length; ei++) {

				for (int k = si; k <= ei; k++) {
					System.out.print(arr[k] + " ");
				}
				System.out.println();
			}
		}
	}

	public static void subset(int[] arr) {

		int limit = (int) Math.pow(2, arr.length);

		for (int n = 0; n <= limit - 1; n++) {

			int temp = n;
			int idx = 0;

			while (temp != 0) {

				int rem = temp % 2;

				if (rem == 1) {
					System.out.print(arr[idx] + " ");
				}
				temp = temp / 2;
				idx++;

			}

			System.out.println();
		}

	}

	public static void bubbleSort(int[] arr) {

		int n = arr.length;

		for (int count = 0; count <= n - 2; count++) {

			for (int j = 0; j <= n - count - 2; j++) {

				if (arr[j] > arr[j + 1]) {

					// swap
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

		}

	}

	public static void selectionSort(int[] arr) {

		int n = arr.length;
		for (int count = 0; count <= n - 2; count++) {

			int min = count;

			for (int j = count + 1; j <= n - 1; j++) {

				if (arr[j] < arr[min]) {
					min = j;
				}
			}

			int temp = arr[count];
			arr[count] = arr[min];
			arr[min] = temp;

		}

	}

}
