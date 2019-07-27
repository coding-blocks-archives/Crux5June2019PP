package L24_July26;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 26-Jul-2019
 *
 */

public class BSTClient {

	public static void main(String[] args) {

		int[] in = { 10, 20, 30, 40, 50, 60 };

		BST bst = new BST(in);
		bst.display();

		System.out.println(bst.size());
		System.out.println(bst.max());
		System.out.println(bst.find(100));
		System.out.println(bst.ht());

		bst.printInRange(15, 55);
		// bst.replaceWithSumLarger();

		bst.display();
		// bst.addOneLevelBefore(29);
		// bst.addParent(25);
		// bst.addReturn(24);
		// bst.addReturn(15);
		bst.addReturn(29);

		
		bst.display();
		
		bst.removeParent(10);
		bst.removeParent(30);
		bst.removeParent(20);
		bst.removeParent(29);
		
		bst.display();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}









