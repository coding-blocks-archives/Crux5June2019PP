package may28;

import java.util.Iterator;

public class GensortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = { 10, 15, 25 };
		int[] B = { 1, 5, 20, 30 };

		int[] C = new int[A.length + B.length];

		printArray(A, B, C, 0, 0, 0, false);

	}

	public static void printArray(int[] A, int[] B, int[] C, int i, int j, int len, boolean isLastA) {

		if (!isLastA) {

			if (len != 0)
				display(C, len + 1);

			for (int k = i; k < A.length; k++) {

				if (len == 0) {
					C[len] = A[k];
					printArray(A, B, C, k + 1, j, len, true);
				} else {
					if (C[len] < A[k]) {
						C[len + 1] = A[k];
						printArray(A, B, C, k + 1, j, len + 1, true);
					}
				}
			}
		} else {

			for (int k = j; k < B.length; k++) {

				if (C[len] < B[k]) {
					C[len + 1] = B[k];
					printArray(A, B, C, i, k + 1, len + 1, false);
				}
			}
		}
	}

	public static void display(int[] C, int len) {

		for (int i = 0; i < len; i++) {

			System.out.print(C[i] + " ");
		}

		System.out.println();
	}

}
