package L22_Jul24;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Jul-2019
 *
 */

public class BTClient {

	// 10 true 20 true 40 false false true 50 false false true 30 false true 60
	// false false

	// Dia :
	// 10 true 20 true 40 true 50 true 60 false false false false true 70 false true
	// 80 false true 90 false false true 30 false false

	// Subtree Sum :
	// 1 true 2 true 4 false false true -5 false false true -3 true -4 false false
	// true 5 true 6 false false true 7 false false
	public static void main(String[] args) {

		// int[] pre = { 10, 20, 40, 50, 30, 60, 70, 80 };
		// int[] in = { 20, 50, 40, 10, 60, 30, 70, 80 };

		int[] pre = { 70, 50, 20, 60, 100, 75, 105 };
		int[] in = { 20, 50, 60, 70, 75, 100, 105 };
		BinaryTree bt = new BinaryTree(pre, in);
		bt.display();

		System.out.println(bt.size());
		System.out.println(bt.max());
		System.out.println(bt.find(60));
		System.out.println(bt.ht());

		System.out.println(bt.diameter1());
		System.out.println(bt.diameter2());

		// 10 true 30 false true 160 false false true 20 true 50 false false true 40
		// false false
		// BinaryTree bt1 = new BinaryTree();
		// bt1.display();
		// System.out.println(bt.flipEquivalent(bt1));

		bt.preorder();
		bt.preorderI();

		System.out.println(bt.maxSubtreeSum());
		System.out.println(bt.maxSubtreeSum2());

		System.out.println(bt.isTreeBST());
	}
}
