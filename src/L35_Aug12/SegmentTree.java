package L35_Aug12;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Aug-2019
 *
 */

public class SegmentTree {

	private class Node {
		int data;
		int si;
		int ei;
		Node left;
		Node right;
	}

	private Node root;
	private SegmentTreeI sti;

	public SegmentTree(int[] arr, SegmentTreeI sti) {
		this.sti = sti;
		this.root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int lo, int hi) {

		Node nn = new Node();
		nn.si = lo;
		nn.ei = hi;

		if (lo == hi) {
			nn.data = arr[lo];
			return nn;
		}

		int mid = (lo + hi) / 2;

		nn.left = construct(arr, lo, mid);
		nn.right = construct(arr, mid + 1, hi);

		nn.data = sti.operation(nn.left.data, nn.right.data);

		return nn;
	}

	public void display() {
		System.out.println("----------------------");
		display(root);
		System.out.println("----------------------");
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		String str = "";

		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}

		str += " -> " + node.data + " <- ";

		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public int query(int qsi, int qei) {

		return query(root, qsi, qei);
	}

	private int query(Node node, int qsi, int qei) {

		// full contribution
		if (node.si >= qsi && node.ei <= qei) {
			return node.data;
		}

		// no contribution
		else if (qei < node.si || qsi > node.ei) {
			return sti.defaultValue();
		}

		// partial : overlapping
		else {

			int lc = query(node.left, qsi, qei);
			int rc = query(node.right, qsi, qei);

			return sti.operation(lc, rc);
		}

	}

	public void update(int idx, int item) {

		update(root, idx, item);
	}

	private void update(Node node, int idx, int item) {

		if (node.si == idx && node.ei == idx) {
			node.data = item;
		}

		// idx lies in nodes range
		else if (idx >= node.si && idx <= node.ei) {

			update(node.left, idx, item);
			update(node.right, idx, item);

			node.data = sti.operation(node.left.data, node.right.data);
		}

		// idx is outside the nodes range
		else {
			return;
		}

	}

}
