package L22_Jul24;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Jul-2019
 *
 */

public class BTClient {

	// 10 true 20 true 40 false false true 50 false false true 30 false true 60 false false
	// Dia :
	// 10 true 20 true 40 true 50 true 60 false false false false true 70 false true
	// 80 false true 90 false false true 30 false false
	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();
		bt.display();

		System.out.println(bt.size());
		System.out.println(bt.max());
		System.out.println(bt.find(60));
		System.out.println(bt.ht());

		System.out.println(bt.diameter1());
		System.out.println(bt.diameter2());

		// 10 true 30 false true 160 false false true 20 true 50 false false true 40 false false
		BinaryTree bt1 = new BinaryTree();
		bt1.display();

		System.out.println(bt.flipEquivalent(bt1));

	}
}
