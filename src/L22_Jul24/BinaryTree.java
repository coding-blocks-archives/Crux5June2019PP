package L22_Jul24;

import java.security.IdentityScope;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Jul-2019
 *
 */

public class BinaryTree {

	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BinaryTree() {
		root = construct(null, false);
	}

	private Node construct(Node parent, boolean ilc) {

		if (parent == null) {
			System.out.println("Enter the data for root node ?");
		} else {

			if (ilc) {
				System.out.println("Enter the data for left child of " + parent.data + " ?");
			} else {
				System.out.println("Enter the data for right child of " + parent.data + " ?");
			}
		}

		int item = scn.nextInt();

		Node nn = new Node();
		nn.data = item;

		System.out.println(nn.data + " has left child ?");
		boolean hlc = scn.nextBoolean();

		if (hlc) {
			nn.left = construct(nn, true);
		}

		System.out.println(nn.data + " has right child ?");
		boolean hrc = scn.nextBoolean();

		if (hrc) {
			nn.right = construct(nn, false);
		}

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

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int lm = max(node.left);
		int rm = max(node.right);

		return Math.max(node.data, Math.max(lm, rm));
	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null) {
			return false;
		}

		if (node.data == item) {
			return true;
		}

		boolean lf = find(node.left, item);
		boolean rf = find(node.right, item);

		return lf || rf;

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

	private class HeapMover {
		int ans;
	}

	public int diameter1() {
		HeapMover mover = new HeapMover();
		diameter1(root, mover);
		return mover.ans;
	}

	private int diameter1(Node node, HeapMover mover) {

		if (node == null) {
			return -1;
		}

		int lh = diameter1(node.left, mover);
		int rh = diameter1(node.right, mover);

		int diameterPresentNode = lh + rh + 2;

		if (diameterPresentNode > mover.ans) {
			mover.ans = diameterPresentNode;
		}

		return Math.max(lh, rh) + 1;

	}

	public int diameter2() {
		return diameter2(root);
	}

	private int diameter2(Node node) {

		if (node == null) {
			return 0;
		}

		int ld = diameter2(node.left);
		int rd = diameter2(node.right);

		int sp = ht(node.left) + ht(node.right) + 2;

		int ans = Math.max(sp, Math.max(ld, rd));

		return ans;

	}

	private class DiaPair {
		int d = 0;
		int h = -1;
	}

	public int diameter3() {
		return diameter3(root).d;
	}

	private DiaPair diameter3(Node node) {

		if (node == null) {
			return new DiaPair();
		}

		DiaPair ldp = diameter3(node.left);
		DiaPair rdp = diameter3(node.right);

		DiaPair sdp = new DiaPair();

		int ld = ldp.d;
		int rd = rdp.d;
		int sp = ldp.h + rdp.h + 2;

		sdp.d = Math.max(sp, Math.max(ld, rd));

		sdp.h = Math.max(ldp.h, rdp.h) + 1;

		return sdp;
	}

	public boolean isBalanced() {
		return isBalanced(root);
	}

	private boolean isBalanced(Node node) {

		if (node == null) {
			return true;
		}

		boolean lb = isBalanced(node.left);
		boolean rb = isBalanced(node.right);

		int bf = ht(node.left) - ht(node.right);

		if ((bf == -1 || bf == 0 || bf == 1) && lb && rb) {
			return true;
		} else {
			return false;
		}

	}

	private class BalPair {
		boolean b = true;
		int h = -1;
	}

	public boolean isBalanced2() {
		return isBalanced2(root).b;
	}

	private BalPair isBalanced2(Node node) {

		if (node == null) {
			return new BalPair();
		}

		BalPair lbp = isBalanced2(node.left);
		BalPair rbp = isBalanced2(node.right);

		BalPair sbp = new BalPair();

		int bf = lbp.h - rbp.h;

		if ((bf == -1 || bf == 0 || bf == 1) && lbp.b && rbp.b) {
			sbp.b = true;
		} else {
			sbp.b = false;
		}

		sbp.h = Math.max(lbp.h, rbp.h) + 1;

		return sbp;
	}

	public boolean flipEquivalent(BinaryTree other) {
		return flipEquivalent(root, other.root);
	}

	public boolean flipEquivalent(Node n1, Node n2) {

		if (n1 == null && n2 == null) {
			return true;
		}

		if (n1 == null || n2 == null) {
			return false;
		}

		if (n1.data != n2.data) {
			return false;
		}

		boolean ll = flipEquivalent(n1.left, n2.left);
		boolean rr = flipEquivalent(n1.right, n2.right);

		boolean lr = flipEquivalent(n1.left, n2.right);
		boolean rl = flipEquivalent(n1.right, n2.left);

		return (ll && rr) || (lr && rl);

	}

	// NLR : preorder
	// NRL : postorder rev
	// LNR : inorder
	// RNL : inoder rev
	// LRN : postorder
	// RLN : preoder rev
	public void preorder() {
		preorder(root);
	}

	private void preorder(Node node) {

		if (node == null)
			return;

		System.out.println(node.data);
		preorder(node.left);
		preorder(node.right);
	}

}
