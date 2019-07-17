package L16_July16.ExceptionStory;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 16-Jul-2019
 *
 */

public class Client {

	public static void main(String[] args) {

		System.out.println("hi main");
		Person p = new Person();

		try {
			System.out.println("hi try");
			p.setAge(10);
			p.fun(-10);
			System.out.println("bye try");
		} catch (Exception e) {
			System.out.println("in exception");
		}

		// p.fun(-10);

		System.out.println(p.getAge());
		System.out.println("bye main");

		System.out.println(p);

	}
}
