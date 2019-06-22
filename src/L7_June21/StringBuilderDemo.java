package L7_June21;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 21-Jun-2019
 *
 */

public class StringBuilderDemo {

	public static void main(String[] args) {

		// string -> sb
		String s = "hello";

		StringBuilder sb = new StringBuilder(s);

		// length
		System.out.println(sb.length());
		System.out.println(sb);

		// append
		sb.append("hello");
		System.out.println(sb);

		// charAt
		System.out.println(sb.charAt(3));
		System.out.println(sb.charAt(sb.length() - 1));

		// susbtring
		System.out.println(sb.substring(2));

		// insert : n
		System.out.println(sb);
		sb.insert(2, "abc");
		System.out.println(sb.charAt(2));
		sb.insert(sb.length(), "xyz");
		System.out.println(sb);

		// set/update : constant
		sb.setCharAt(2, 'r');
		System.out.println(sb);

		// delete : n
		sb.deleteCharAt(0);
		System.out.println(sb);

		// stringbuilder -> string
		String str = sb.toString();
		System.out.println(str);
		
		System.out.println(changeCase("AbcDef"));

	}

	public static String changeCase(String str) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (Character.isUpperCase(ch)) {
				sb.append(Character.toLowerCase(ch));
			} else if (Character.isLowerCase(ch)) {
				sb.append(Character.toUpperCase(ch));
			}

		}

		return sb.toString();

	}
}
