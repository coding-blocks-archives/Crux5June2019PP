package L26_July29.GenericClass;

import java.util.ArrayList;
import java.util.LinkedList;

import L26_July29.GenericFxn.Car;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Jul-2019
 *
 */

public class Demo {

	public static void main(String[] args) {

		Pair<Pair<String, Integer>, Pair<Character, Boolean>> p = new Pair<>();

		p.a = new Pair<>();
		p.b = new Pair<>();

		p.a.a = "abc";
		p.a.b = 100;

		System.out.println(p.a.a);
		System.out.println(p.a.b);
		System.out.println(p.b.a);
		System.out.println(p.b.b);

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		list.add(new ArrayList<>());
		list.add(new ArrayList<>());
		list.add(new ArrayList<>());

		list.get(0).add(10);
		list.get(0).add(40);
		list.get(1).add(20);
		list.get(2).add(30);

		System.out.println(list);
		System.out.println(list.size());

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
