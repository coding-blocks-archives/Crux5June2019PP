package Assignments.July28;

import java.util.Scanner;

public class LinkedList2 {

	private Node head;

	private class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void tripletFromThreeLL(LinkedList2 la, LinkedList2 lb, LinkedList2 lc, int givenNumber) {

		Node head1 = la.head;

		while (head1 != null) {

			Node head2 = lb.head;
			while (head2 != null) {

				Node head3 = lc.head;
				while (head3 != null) {

					if (head1.data + head2.data + head3.data == givenNumber) {

						System.out.println(head1.data + " " + head2.data + " " + head3.data);
						return;
					}

					head3 = head3.next;
				}

				head2 = head2.next;
			}

			head1 = head1.next;
		}

		System.out.println("No Triplet Found");
	}

	public void display(Node head) {

		if (head == null) {
			return;
		}

		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public void addFirst(int item) {

		Node nn = new Node(item);
		nn.next = head;
		head = nn;
	}

	public static void main(String args[]) {

		Scanner scn = new Scanner(System.in);

		LinkedList2 llist1 = new LinkedList2();
		LinkedList2 llist2 = new LinkedList2();
		LinkedList2 llist3 = new LinkedList2();

		int a = scn.nextInt();
		int b = scn.nextInt();
		int c = scn.nextInt();

		for (int i = 0; i < a; i++)
			llist1.addFirst(scn.nextInt());

		for (int i = 0; i < b; i++)
			llist2.addFirst(scn.nextInt());

		for (int i = 0; i < c; i++)
			llist3.addFirst(scn.nextInt());

		int givenNumber = scn.nextInt();

		llist1.tripletFromThreeLL(llist1, llist2, llist3, givenNumber);
	}
}
