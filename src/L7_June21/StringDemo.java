package L7_June21;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 21-Jun-2019
 *
 */

public class StringDemo {

	public static void main(String[] args) {

		String str = "hello";
		System.out.println(str);

		// length
		System.out.println(str.length());

		// charAt
		System.out.println(str.charAt(2));
		System.out.println(str.charAt(str.length() - 1));

		// substring
		System.out.println(str.substring(1, 4)); // ell
		System.out.println(str.substring(2, 5)); // llo
		// System.out.println(str.substring(3,1)); // error
		System.out.println(str.substring(2, 2)); // ""
		System.out.println(str.substring(2)); // llo

		// concatenate
		String s1 = "hi";
		String s2 = "bye";
		String s3 = s1 + s2;
		System.out.println(s1 + ", " + s2 + ", " + s3);
		String s4 = s1.concat(s2);
		System.out.println(s1 + ", " + s2 + ", " + s4);

		// indexOf
		System.out.println(str.indexOf("eL"));

		// starts with
		System.out.println(str.startsWith("Hel"));
		System.out.println(str.startsWith("hel"));

		// equals and ==
		s1 = "Hello";
		s2 = s1;
		s3 = "Hello";
		s4 = new String("Hello");

		System.out.println((s1 == s2) + ", " + s1.equals(s2)); // true true
		System.out.println((s1 == s3) + ", " + s1.equals(s3)); // true true
		System.out.println((s1 == s4) + ", " + s1.equals(s4)); // false true

		String s10 = "habclo";

		str = str.replace("el", "abc"); // habclo
		System.out.println(str == s10);

		appendString();

	}

	public static void appendString() {

		long start = System.currentTimeMillis();
		int n = 10000000;

		// String str = "";
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			// str += i;
			sb.append(i);
		}

		long end = System.currentTimeMillis();
		System.out.println(end - start);

	}

}
