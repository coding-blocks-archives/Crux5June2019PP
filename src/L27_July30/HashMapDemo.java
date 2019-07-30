package L27_July30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Jul-2019
 *
 */

public class HashMapDemo {

	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap<>();

		// put : O(1)
		map.put("India", 100);
		map.put("China", 20);
		map.put("Aus", 300);

		System.out.println(map);

		map.put("China", 40);

		System.out.println(map);

		// get : O(1)
		System.out.println(map.get("India"));
		System.out.println(map.get("US"));

		// contains : O(1)
		System.out.println(map.containsKey("India"));
		System.out.println(map.containsKey("US"));

		// remove : O(1)
		System.out.println(map.remove("China"));
		System.out.println(map);
		System.out.println(map.remove("UK"));

		// keyset
		// way 1
		Set<String> keys = map.keySet();

		for (String key : keys) {
			System.out.println(key + "->" + map.get(key));
		}

		// way 2
		for (String key : map.keySet()) {
			System.out.println(key + "->" + map.get(key));
		}

		// way 3
		ArrayList<String> list = new ArrayList<>(map.keySet());

		for (String val : list) {
			System.out.println(val + "->" + map.get(val));
		}

	}
}
