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
		list.addFirst(30);
		list.addLast(40);
		list.display();
		list.addAt(50, 1);
		list.display();

		System.out.println(list.removeFirst());
		list.display();
		System.out.println(list.removeLast());
		list.display();
		System.out.println(list.removeAt(1));
		list.display();

	}
}
