package Assignments.July28;

import java.util.*;

public class LinkedList {
	private class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public void addLast(int data) {

		Node node = new Node(data, null);

		if (size == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}

		this.size++;
	}

	public void display() {
		Node node = this.head;

		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}

	}

	public void deleteNodes() throws Exception {

		this.head = reverse();

		Node max = this.head;
		Node curr = this.head.next;

		while (curr != null) {

			if (max.data <= curr.data) {

				max = curr;
				curr = curr.next;

			} else {

				max.next = curr.next;
				curr = curr.next;
			}
		}

		this.head = reverse();

	}

	public Node reverse() {

		Node prev = null;
		Node curr = this.head;

		while (curr != null) {

			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;

	}

	public static void main(String[] args) throws Exception {

		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();

		LinkedList list = new LinkedList();

		for (int i = 0; i < N; i++) {
			list.addLast(scn.nextInt());
		}

		list.deleteNodes();
		list.display();
	}
}
