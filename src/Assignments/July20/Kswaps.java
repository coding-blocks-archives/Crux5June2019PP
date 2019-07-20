package Assignments.July20;

public class Kswaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "129814999";

		char[] arr = str.toCharArray();
		int k = 4;

		System.out.println(MaxNumber(arr, 0, k));

	}

	public static int MaxNumber(char[] arr, int vidx, int k) {

		int max = Integer.parseInt(new String(arr));

		if (k == 0) {
			return max;
		}

		for (int i = vidx; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[j] > arr[i]) {

					swap(arr, i, j);
					int ans = MaxNumber(arr, i + 1, k - 1);
					max = Math.max(max, ans);
					swap(arr, i, j);

				}
			}
		}

		return max;

	}

	public static void swap(char[] arr, int i, int j) {

		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
