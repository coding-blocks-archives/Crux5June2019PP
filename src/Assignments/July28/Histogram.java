package Assignments.July28;

import java.util.*;

public class Histogram {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		long[] arr = new long[scn.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextLong();
		}

		long maxArea = 0;
		long pArea = 0;

		Stack<Integer> stack = new Stack<>();

		int i = 0;
		while (i < arr.length) {

			if (stack.isEmpty() || arr[i] > arr[stack.peek()]) {
				stack.push(i);
				i++;
			}

			else {

				long x = arr[stack.pop()];

				int R = i;

				if (stack.isEmpty()) {
					pArea = R * x;
				} else {
					int L = stack.peek();
					pArea = (R - L - 1) * x;
				}

				if (pArea > maxArea) {
					maxArea = pArea;
				}

			}

		}

		while (!stack.isEmpty()) {

			long x = arr[stack.pop()];

			int R = i;

			if (stack.isEmpty()) {
				pArea = R * x;
			} else {
				int L = stack.peek();
				pArea = (R - L - 1) * x;
			}

			if (pArea > maxArea) {
				maxArea = pArea;
			}

		}

		System.out.println(maxArea);

	}
}
