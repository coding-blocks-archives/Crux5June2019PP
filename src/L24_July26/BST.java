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

	public void printInRange(int lo, int hi) {
		printInRange(root, lo, hi);
	}

	private void printInRange(Node node, int lo, int hi) {

		if (node == null) {
			return;
		}

		if (node.data < lo) {
			printInRange(node.right, lo, hi);
		}

		if (node.data > hi) {
			printInRange(node.left, lo, hi);
		}

		if (node.data >= lo && node.data <= hi) {

			printInRange(node.left, lo, hi);
			System.out.println(node.data);
			printInRange(node.right, lo, hi);
		}

	}

	public void replaceWithSumLarger() {
		replaceWithSumLarger(root, new int[1]);
	}

	private void replaceWithSumLarger(Node node, int[] maxsum) {

		if (node == null) {
			return;
		}

		replaceWithSumLarger(node.right, maxsum);

		int temp = node.data;
		node.data = maxsum[0];
		maxsum[0] += temp;

		replaceWithSumLarger(node.left, maxsum);

	}

	public void addOneLevelBefore(int item) {

		if (root == null) {
			root = new Node();
			root.data = item;
		} else {
			addOneLevelBefore(root, item);
		}
	}

	private void addOneLevelBefore(Node node, int item) {

		if (item <= node.data) {

			if (node.left == null) {
				Node nn = new Node();
				nn.data = item;
				node.left = nn;
			} else {
				addOneLevelBefore(node.left, item);
			}

		} else {

			if (node.right == null) {
				Node nn = new Node();
				nn.data = item;
				node.right = nn;
			} else {
				addOneLevelBefore(node.right, item);
			}

		}

	}

	public void addParent(int item) {
		if (root == null) {
			root = new Node();
			root.data = item;
		} else {
			addParent(root, null, item);
		}
	}

	private void addParent(Node node, Node parent, int item) {

		if (node == null) {

			Node nn = new Node();
			nn.data = item;

			if (item <= parent.data) {
				parent.left = nn;
			} else {
				parent.right = nn;
			}

			return;
		}

		if (item <= node.data) {
			addParent(node.left, node, item);
		} else {
			addParent(node.right, node, item);
		}

	}

	public void addReturn(int item) {
		root = addReturn(root, item);
	}

	private Node addReturn(Node node, int item) {

		if (node == null) {
			Node nn = new Node();
			nn.data = item;
			return nn;
		}

		if (item <= node.data) {
			node.left = addReturn(node.left, item);
		} else {
			node.right = addReturn(node.right, item);
		}

		return node;
	}

	public void removeParent(int item) {

		if (root.data == item) {
			if (root.left == null) {
				root = root.right;
			} else if (root.right == null) {
				root = root.left;
			} else {
				removeParent(root, null, item);
			}
		} else {
			removeParent(root, null, item);
		}

	}

	private void removeParent(Node node, Node parent, int item) {

		if (node == null) {
			return;
		}

		if (item < node.data) {
			removeParent(node.left, node, item);
		} else if (item > node.data) {
			removeParent(node.right, node, item);
		} else {

			if (node.left == null && node.right == null) {

				if (item <= parent.data) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}

			else if (node.left == null && node.right != null) {

				if (item <= parent.data) {
					parent.left = node.right;
				} else {
					parent.right = node.right;
				}
			}

			else if (node.left != null && node.right == null) {

				if (item <= parent.data) {
					parent.left = node.left;
				} else {
					parent.right = node.left;
				}
			}

			else {

				int m = max(node.left);
				node.data = m;
				removeParent(node.left, node, m);

			}
		}

	}

}
