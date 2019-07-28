package Assignments.July28;

import java.util.*;

public class PlayingWithCards {

	public static void main(String args[]) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int q = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		playingCards(arr, q);

	}

	public static void playingCards(int[] arr, int q) {

		ArrayList<Stack<Integer>> A = new ArrayList<>();
		ArrayList<Stack<Integer>> B = new ArrayList<>();

		int n = arr.length;

		for (int i = 0; i < n + 1; i++) {

			A.add(new Stack<>());
			B.add(new Stack<>());
		}

		for (int i = 0; i < arr.length; i++) {

			A.get(0).push(arr[i]);

		}

		for (int i = 1; i <= q; i++) {

			Stack<Integer> temp = A.get(i - 1);

			int prime = ithPrime(i);
			while (!temp.isEmpty()) {

				if (temp.peek() % prime == 0) {

					B.get(i).push(temp.peek());
				} else {
					A.get(i).push(temp.peek());
				}

				temp.pop();
			}
		}

		for (int i = 0; i <= q; i++) {

			Stack<Integer> temp = B.get(i);

			while (!temp.isEmpty()) {

				System.out.println(temp.pop());

			}
		}

		while (!A.get(q).isEmpty()) {

			System.out.println(A.get(q).pop());
		}

	}

	public static int ithPrime(int i) {

		int cnt = 0;

		int num = 2;
		while (true) {

			if (isPrime(num)) {
				cnt++;
			}

			if (cnt == i) {
				return num;
			}

			num++;
		}

	}

	public static boolean isPrime(int n) {

		for (int i = 2; i * i <= n; i++) {

			if (n % i == 0)
				return false;
		}

		return true;
	}

}
