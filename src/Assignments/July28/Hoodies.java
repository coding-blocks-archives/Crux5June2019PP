package Assignments.July28;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Hoodies {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		ArrayList<Queue<Integer>> courses = new ArrayList<>();

		for (int i = 0; i <= 4; i++) {
			courses.add(new LinkedList<>());
		}

		ArrayList<Integer> order = new ArrayList<>();

		int q = scn.nextInt();

		for (int i = 1; i <= q; i++) {

			char ch = scn.next().charAt(0);

			if (ch == 'E') {

				int c = scn.nextInt();
				int rno = scn.nextInt();

				courses.get(c).add(rno);

				if (!order.contains(c)) {
					order.add(c);
				}

			} else if (ch == 'D') {

				int rc = order.get(0); // get the course no
				int rr = courses.get(rc).remove(); // remove the student from respective queue

				System.out.println(rc + " " + rr);

				if (courses.get(rc).isEmpty()) {
					order.remove(0);
				}

			}

		}

	}
}
