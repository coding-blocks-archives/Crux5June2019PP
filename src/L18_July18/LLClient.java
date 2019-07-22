package L18_July18;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Jul-2019
 *
 */

public class LLClient {

	public static void main(String[] args) throws Exception {

		LinkedList list = new LinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		list.addLast(60);
		list.addLast(70);
		list.addLast(80);
		// list.addLast(90);
		list.display();
		// list.addAt(50, 1);
		list.display();

		// System.out.println(list.removeFirst());
		// list.display();
		// System.out.println(list.removeLast());
		// list.display();
		// System.out.println(list.removeAt(1));
		// list.display();

		// list.RDR();
		// list.fold();
		// System.out.println(list.mid());
		// list.display();
		//
		// System.out.println(list.kthFromLast(5));
		//
		// System.out.println(list.linkedListIntersection());
		// list.createDummyList();
		// System.out.println(list.detectRemoveLoop2());
		//
		// list.display();

		list.kReverse(3);
		list.display();

	}
}
