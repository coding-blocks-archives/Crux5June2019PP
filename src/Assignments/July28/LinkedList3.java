package Assignments.July28;

import java.util.*;

public class LinkedList3 {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public void addFirst(int item) {
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		if (size == 0) {
			this.head = nn;
			this.tail = nn;
			size++;
		} else {
			nn.next = this.head;
			this.head = nn;
			size++;
		}
	}

	public void addLast(int item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// update summary
		if (size == 0) {
			this.head = nn;
			this.tail = nn;
			size++;
		} else {
			this.tail.next = nn;
			this.tail = nn;
			size++;
		}
	}

	public void reverse() {
		Node curr = head;
		Node prev = head;

		while (curr != null) {
			Node ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}

		Node temp = head;
		head = tail;
		tail = temp;
		tail.next = null;

	}

	public void display() {
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) throws Exception {

		Scanner scn = new Scanner(System.in);

		int s1 = scn.nextInt();
		int s2 = scn.nextInt();

		LinkedList3 l1 = new LinkedList3();
		LinkedList3 l2 = new LinkedList3();

		for (int i = 0; i < s1; i++) {
			l1.addLast(scn.nextInt());
		}
		for (int i = 0; i < s2; i++) {
			l2.addLast(scn.nextInt());
		}

		LinkedList3 ans = l1.sumTwoLL(l2);

		ans.display();

	}

	public LinkedList3 sumTwoLL(LinkedList3 l2) {

		int carry = 0;
		LinkedList3 ans = new LinkedList3();

		// reverse the two linked lists : 1st is this and 2nd is l2
		this.reverse();
		l2.reverse();

		Node h1 = this.head;
		Node h2 = l2.head;

		while (h1 != null || h2 != null) {
			int sum = carry;
			if (h1 != null) {
				sum += h1.data;
				h1 = h1.next;
			}
			if (h2 != null) {
				sum += h2.data;
				h2 = h2.next;
			}

			int pa = sum % 10;
			carry = sum / 10;

			ans.addFirst(pa);

		}

		if (carry != 0) {
			ans.addFirst(carry);
		}

		return ans;
	}
}