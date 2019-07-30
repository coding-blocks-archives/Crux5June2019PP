package L27_July30;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Jul-2019
 *
 */

public class SetDemo {

	public static void main(String[] args) {

		Set<Integer> set = new HashSet<>();

		set.add(10);
		set.add(20);
		set.add(10);
		set.add(10);

		System.out.println(set);

		set.remove(10);
		System.out.println(set);

		System.out.println(set.contains(200));

	}
}
