package L26_July29.GenericClass;

import L26_July29.GenericFxn.Car;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Jul-2019
 *
 */

public class Demo {

	public static void main(String[] args) {

		// Pair<String, Integer> p = new Pair<>();

		LinkedListGeneric<Car> ll = new LinkedListGeneric<>();

		Car[] carr = new Car[5];
		carr[0] = new Car(100, 40, "Black");
		carr[1] = new Car(300, 2, "White");
		carr[2] = new Car(40, 56, "Grey");
		carr[3] = new Car(80, 89, "Red");
		carr[4] = new Car(90, 3, "Yellow");

		ll.addFirst(carr[0]);
		ll.addLast(carr[1]);
		ll.addLast(carr[2]);
		ll.addLast(carr[3]);
		ll.addFirst(carr[4]);

		ll.display();

	}
}
