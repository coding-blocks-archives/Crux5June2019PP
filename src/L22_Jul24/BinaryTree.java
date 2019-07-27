package L22_Jul24;

import java.util.Scanner;
import java.util.Stack;

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

	public BinaryTree(int[] pre, int[] in) {
		root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {

		if (ilo > ihi || plo > phi) {
			return null;
		}

		Node nn = new Node();
		nn.data = pre[plo];

		int nel = 0;

		int si = -1;
		for (int i = ilo; i <= ihi; i++) {
			if (in[i] == pre[plo]) {
				si = i;
				break;
			}

			nel++;
		}

		nn.left = construct(pre, plo + 1, plo + nel, in, ilo, si - 1); // left st
		nn.right = construct(pre, plo + nel + 1, phi, in, si + 1, ihi); // right st

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

	// Ques : https://leetcode.com/problems/diameter-of-binary-tree/

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

	// Ques : https://leetcode.com/problems/flip-equivalent-binary-trees/

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
		System.out.println();
	}

	private void preorder(Node node) {

		if (node == null)
			return;

		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}

	private class Pair {
		Node n;
		boolean sd;
		boolean ld;
		boolean rd;
	}

	public void preorderI() {

		Stack<Pair> stack = new Stack<>();

		Pair sp = new Pair();
		sp.n = root;

		stack.push(sp);

		while (!stack.isEmpty()) {

			Pair tp = stack.peek();

			if (tp.sd == false) {
				System.out.print(tp.n.data + " ");
				tp.sd = true;

			} else if (tp.ld == false) {

				Pair np = new Pair();
				np.n = tp.n.left;

				if (np.n != null)
					stack.push(np);

				tp.ld = true;

			} else if (tp.rd == false) {

				Pair np = new Pair();
				np.n = tp.n.right;

				if (np.n != null)
					stack.push(np);

				tp.rd = true;

			} else {
				stack.pop();
			}

		}

		System.out.println();

	}

	// Ques : https://www.geeksforgeeks.org/find-largest-subtree-sum-tree/

	public int maxSubtreeSum() {
		int[] maxsum = new int[1];
		maxsum[0] = Integer.MIN_VALUE;
		maxSubtreeSum(root, maxsum);
		return maxsum[0];
	}

	private int maxSubtreeSum(Node node, int[] maxsum) {

		if (node == null) {
			return 0;
		}

		int ls = maxSubtreeSum(node.left, maxsum);
		int rs = maxSubtreeSum(node.right, maxsum);

		int ts = ls + rs + node.data;

		if (ts > maxsum[0]) {
			maxsum[0] = ts;
		}

		return ts;

	}

	private class SubtreePair {
		int entireSum;
		int maxSum = Integer.MIN_VALUE;
	}

	public int maxSubtreeSum2() {

		return maxSubtreeSum2(root).maxSum;

	}

	private SubtreePair maxSubtreeSum2(Node node) {

		if (node == null) {
			return new SubtreePair();
		}

		SubtreePair lsp = maxSubtreeSum2(node.left);
		SubtreePair rsp = maxSubtreeSum2(node.right);

		SubtreePair ssp = new SubtreePair();

		ssp.entireSum = lsp.entireSum + rsp.entireSum + node.data;

		ssp.maxSum = Math.max(ssp.entireSum, Math.max(lsp.maxSum, rsp.maxSum));

		return ssp;

	}

	private class BSTPair {
		boolean isBST = true;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

	}

	public boolean isTreeBST() {
		return isTreeBST(root).isBST;
	}

	private BSTPair isTreeBST(Node node) {

		if (node == null) {
			return new BSTPair();
		}

		BSTPair lbp = isTreeBST(node.left);
		BSTPair rbp = isTreeBST(node.right);

		BSTPair sbp = new BSTPair();

		if (lbp.isBST && rbp.isBST && node.data > lbp.max && node.data < rbp.min) {
			sbp.isBST = true;
		} else {
			sbp.isBST = false;
		}

		sbp.max = Math.max(node.data, rbp.max);
		sbp.min = Math.min(node.data, lbp.min);

		return sbp;
	}
}
