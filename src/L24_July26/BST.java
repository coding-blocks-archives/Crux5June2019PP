package L24_July26;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 26-Jul-2019
 *
 */

public class BST {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BST(int[] in) {
		root = construct(in, 0, in.length - 1);
	}

	private Node construct(int[] in, int lo, int hi) {

		if (lo > hi) {
			return null;
		}

		int mid = (lo + hi) / 2;

		Node nn = new Node();
		nn.data = in[mid];

		nn.left = construct(in, lo, mid - 1);
		nn.right = construct(in, mid + 1, hi);

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

	public int size() {
		return size(root);
	}

	private int size(Node node) {

		if (node == null) {
			return 0;
		}

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		if (node.right == null) {
			return node.data;
		}

		return max(node.right);
	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null) {
			return false;
		}

		if (item < node.data) {
			return find(node.left, item);
		} else if (item > node.data) {
			return find(node.right, item);
		} else {
			return true;
		}

	}

	public int ht() {
		return ht(root);
	}

	private int ht(Node node) {

		if (node == null) {
			return -1;
		}

		int lh = ht(node.left);
		int rh = ht(node.right);

		return Math.max(lh, rh) + 1;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
