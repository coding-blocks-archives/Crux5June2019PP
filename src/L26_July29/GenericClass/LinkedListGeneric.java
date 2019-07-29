package L26_July29.GenericClass;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Jul-2019
 *
 */

public class LinkedListGeneric<T> {

	private class Node {
		T data;
		Node next;

		public Node(T data) {
			this.data = data;
		}

		public Node() {

		}
	}

	private Node head;
	private Node tail;
	private int size;

	// O(1)
	public boolean isEmpty() {
		return size == 0;
	}

	// O(1)
	public T getFirst() throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty.");
		}

		return head.data;
	}

	// O(1)
	public T getLast() throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty.");
		}

		return tail.data;
	}

	// O(n)
	public T getAt(int idx) throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= size) {
			throw new Exception("Invalid Index.");
		}

		Node temp = head;

		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}

		return temp.data;
	}

	// O(n)
	private Node getNodeAt(int idx) throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= size) {
			throw new Exception("Invalid Index.");
		}

		Node temp = head;

		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}

		return temp;
	}

	// O(n)
	public void display() {

		System.out.println("---------------------");

		Node temp = head;

		while (temp != null) {
			System.out.println(temp.data + " ");
			temp = temp.next;
		}

		System.out.println(".");
		System.out.println("---------------------");

	}

	// O(1)
	public void addLast(T item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		if (size > 0)
			tail.next = nn;

		// data members
		if (size == 0) {
			head = tail = nn;
			size++;
		} else {
			tail = nn;
			size++;
		}

	}

	// O(1)
	public void addFirst(T item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		nn.next = head;

		// data members
		if (size == 0) {
			head = tail = nn;
			size++;
		} else {
			head = nn;
			size++;
		}

	}

	// O(n)
	public void addAt(T item, int idx) throws Exception {

		if (idx < 0 || idx > size) {
			throw new Exception("Invalid Index.");
		}

		if (idx == 0) {
			addFirst(item);
		} else if (idx == size) {
			addLast(item);
		} else {

			// create a new Node
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			// links set
			Node nm1 = getNodeAt(idx - 1);
			Node np1 = nm1.next;

			nm1.next = nn;
			nn.next = np1;

			// data members
			size++;

		}

	}

	// O(1)
	public T removeFirst() throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty.");
		}

		T temp = head.data;

		if (size == 1) {
			head = tail = null;
			size--;
		} else {
			head = head.next;
			size--;
		}

		return temp;

	}

	// O(n)
	public T removeLast() throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty.");
		}

		T temp = tail.data;

		if (size == 1) {
			head = tail = null;
			size--;
		} else {
			tail = getNodeAt(size - 2);
			tail.next = null;
			size--;
		}

		return temp;

	}

	// O(n)
	public T removeAt(int idx) throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= size) {
			throw new Exception("Invalid Index.");
		}

		if (idx == 0) {
			return removeFirst();
		} else if (idx == size - 1) {
			return removeLast();
		} else {

			Node nm1 = getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;
			size--;

			return n.data;

		}
	}

}
