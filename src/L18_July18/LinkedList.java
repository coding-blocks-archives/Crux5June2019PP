package L18_July18;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Jul-2019
 *
 */

public class LinkedList {

	private class Node {
		int data;
		Node next;

		public Node(int data) {
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
	public int getFirst() throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty.");
		}

		return head.data;
	}

	// O(1)
	public int getLast() throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty.");
		}

		return tail.data;
	}

	// O(n)
	public int getAt(int idx) throws Exception {

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
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.println(".");
		System.out.println("---------------------");

	}

	// O(1)
	public void addLast(int item) {

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
	public void addFirst(int item) {

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
	public void addAt(int item, int idx) throws Exception {

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
	public int removeFirst() throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty.");
		}

		int temp = head.data;

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
	public int removeLast() throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty.");
		}

		int temp = tail.data;

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
	public int removeAt(int idx) throws Exception {

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

	public void RDI() throws Exception {

		int left = 0;
		int right = size - 1;

		while (left < right) {

			Node ln = getNodeAt(left);
			Node rn = getNodeAt(right);

			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;

			left++;
			right--;

		}

	}

	public void RPI() {

		Node prev = null;
		Node curr = head;

		while (curr != null) {

			Node ahead = curr.next;

			curr.next = prev;

			prev = curr;
			curr = ahead;

		}

		Node temp = head;
		head = tail;
		tail = temp;

		// tail.next = null;

	}

	public void RPR() {
		RPR(null, head);

		Node temp = head;
		head = tail;
		tail = temp;

		// tail.next = null;

	}

	private void RPR(Node prev, Node curr) {

		if (curr == null) {
			return;
		}

		RPR(curr, curr.next);
		curr.next = prev;

		// Node ahead = curr.next ;
		// curr.next = prev;
		// RPR(curr, ahead);

	}

	public void RDR() {
		// RDR(head, head, 0);

		HeapMover mover = new HeapMover();
		mover.left = head;

		RDRHeap(mover, head, 0);

	}

	private Node RDR(Node left, Node right, int count) {

		if (right == null) {
			return left;
		}

		Node cl = RDR(left, right.next, count + 1);

		if (count >= size / 2) {
			int temp = cl.data;
			cl.data = right.data;
			right.data = temp;
		}

		return cl.next;
	}

	private class HeapMover {
		Node left;
	}

	private void RDRHeap(HeapMover mover, Node right, int count) {

		if (right == null) {
			return;
		}

		RDRHeap(mover, right.next, count + 1);

		if (count >= size / 2) {
			int temp = mover.left.data;
			mover.left.data = right.data;
			right.data = temp;
		}

		mover.left = mover.left.next;
	}

	public void fold() {
		fold(head, head, 0);
	}

	private Node fold(Node left, Node right, int count) {

		if (right == null) {
			return left;
		}

		left = fold(left, right.next, count + 1);

		if (count > size / 2) {

			Node ahead = left.next;

			left.next = right;
			right.next = ahead;

			return ahead;
		}

		if (count == size / 2) {
			tail = right;
			tail.next = null;
		}

		return null;

	}

	public int mid() {

		Node slow = head;
		Node fast = head;

		// while (fast.next != null && fast.next.next != null) {
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;
	}

	public int kthFromLast(int k) {

		Node slow = head;
		Node fast = head;

		for (int i = 1; i <= k; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;

	}

	public int linkedListIntersection() {

		Node a1 = new Node(10);
		Node a2 = new Node(20);
		Node a3 = new Node(30);
		Node a4 = new Node(40);
		Node a5 = new Node(50);
		Node a6 = new Node(60);

		Node b1 = new Node(70);
		Node b2 = new Node(80);
		Node b3 = new Node(90);
		Node b4 = new Node(100);
		Node b5 = new Node(110);
		Node b6 = new Node(120);

		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;

		b1.next = b2;
		b2.next = b3;
		b3.next = b4;
		b4.next = b5;
		b5.next = b6;
		b6.next = a3;

		// logic ...
		Node fp = a1;
		Node sp = b1;

		while (fp != sp) {

			// fp = (fp == null ) ? b1 : fp.next ;

			if (fp == null) {
				fp = b1;
			} else {
				fp = fp.next;
			}

			if (sp == null) {
				sp = a1;
			} else {
				sp = sp.next;
			}
		}

		return fp.data;

	}

	public void createDummyList() {

		Node a1 = new Node(10);
		Node a2 = new Node(20);
		Node a3 = new Node(30);
		Node a4 = new Node(40);
		Node a5 = new Node(50);
		Node a6 = new Node(60);
		Node a7 = new Node(70);
		Node a8 = new Node(80);

		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = a7;
		a7.next = a8;
		a8.next = a4;

		head = a1;
	}

	public boolean detectRemoveLoop1() {

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				break;
			}

		}

		if (slow == fast) {

			// remove loop

			// 1. no. of nodes in loop
			int count = 1;
			Node temp = slow.next;
			while (temp != slow) {
				count++;
				temp = temp.next;
			}

			// 2. move one pointer count distance
			Node ahead = head;

			for (int i = 1; i <= count; i++) {
				ahead = ahead.next;
			}

			// 3. move two pointers with same speed
			Node loop = ahead;
			Node start = head;

			while (loop.next != start.next) {
				loop = loop.next;
				start = start.next;
			}

			loop.next = null;

			return true;
		} else {
			return false;
		}

	}

	public boolean detectRemoveLoop2() {

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				break;
			}

		}

		if (slow == fast) {

			// remove loop
			Node loop = slow;
			Node start = head;

			while (loop.next != start.next) {
				loop = loop.next;
				start = start.next;
			}

			loop.next = null;

			return true;
		} else {
			return false;
		}

	}

	public void kReverse(int k) throws Exception {

		LinkedList prev = null;

		while (size != 0) {

			LinkedList curr = new LinkedList();

			for (int i = 1; i <= k && size != 0; i++) {
				curr.addFirst(this.removeFirst());
			}

			if (prev == null) {
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size += curr.size;
			}

		}

		head = prev.head;
		tail = prev.tail;
		size = prev.size;

	}

}
