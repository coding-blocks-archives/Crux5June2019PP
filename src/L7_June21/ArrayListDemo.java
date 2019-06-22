package L7_June21;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 21-Jun-2019
 *
 */

public class ArrayListDemo {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		System.out.println(list); // []

		list.add(10);
		System.out.println(list); // [10]
		list.add(20);
		System.out.println(list); // [10, 20]
		list.add(30);
		System.out.println(list); // [10, 20, 30]
		list.add(40);
		System.out.println(list); // [10, 20, 30, 40]

		// size
		System.out.println(list.size());

		// get : 0 -> size-1 : constant
		System.out.println(list.get(0));
		System.out.println(list.get(list.size() - 1));

		// set : 0 -> size-1 : constant
		list.set(2, 100);
		System.out.println(list);

		// add at index : 0 -> size : n
		list.add(0, 200);
		System.out.println(list);

		// remove : 0 -> size-1 : n
		list.remove(1);
		System.out.println(list);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
