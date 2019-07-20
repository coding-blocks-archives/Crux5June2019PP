package Assignments.July20;

public class SplitArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 2, 3, 4, 5, 3 };
		System.out.println(split(arr, 0, 0, "", 0, ""));

	}

	public static int split(int[] arr, int vidx, int sum1, String ans1, int sum2, String ans2) {

		if (vidx == arr.length) {

			// if (sum1 == sum2) {
			System.out.println(ans1 + "and " + ans2);

			return 1;
			// }

			// return 0;
		}

		int cnt = 0;

		cnt += split(arr, vidx + 1, sum1 + arr[vidx], ans1 + arr[vidx] + " ", sum2, ans2);
		cnt += split(arr, vidx + 1, sum1, ans1, sum2 + arr[vidx], ans2 + arr[vidx] + " ");

		return cnt;
	}

}
