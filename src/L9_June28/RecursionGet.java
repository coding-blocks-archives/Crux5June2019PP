package L9_June28;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 28-Jun-2019
 *
 */

public class RecursionGet {

	public static void main(String[] args) {

		// System.out.println(getSS("abc"));
		// System.out.println(getKPC("145"));
		// System.out.println(coinToss(3));
		// System.out.println(permutation("abc"));
		System.out.println(mazePath(0, 0, 2, 2));
	}

	public static ArrayList<String> getSS(String str) {

		// base case
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		// smaller problem
		ArrayList<String> rr = getSS(ros);

		ArrayList<String> mr = new ArrayList<>();

		// self work
		for (String val : rr) {
			mr.add(val); // no
			mr.add(ch + val); // yes
		}

		return mr;

	}

	public static ArrayList<String> getSSAscii(String str) {

		// base case
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		// smaller problem
		ArrayList<String> rr = getSSAscii(ros);

		ArrayList<String> mr = new ArrayList<>();

		// self work
		for (String val : rr) {
			mr.add(val); // no
			mr.add(ch + val); // yes
			mr.add((int) ch + val); // ascii
		}

		return mr;

	}

	public static ArrayList<String> getKPC(String str) {

		// base case
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getKPC(ros);

		ArrayList<String> mr = new ArrayList<>();

		String code = getCode(ch); // abc

		for (int i = 0; i < code.length(); i++) { // a b c

			for (String val : rr) { // jl jm jn jo kl km kn ko
				mr.add(code.charAt(i) + val);
			}
		}

		return mr;

	}

	public static String getCode(char ch) {

		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";

	}

	public static ArrayList<String> coinToss(int n) {

		if (n == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> rr = coinToss(n - 1);

		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {

			mr.add("H" + val);
			mr.add("T" + val);
		}

		return mr;

	}

	public static ArrayList<String> permutation(String str) {

		// base case
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = permutation(ros);

		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {

			for (int i = 0; i <= val.length(); i++) {

				String ans = val.substring(0, i) + ch + val.substring(i);
				mr.add(ans);
			}
		}

		return mr;
	}

	public static ArrayList<String> mazePath(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		// horizontal
		if (cc + 1 <= ec) {
			ArrayList<String> rrh = mazePath(cr, cc + 1, er, ec);

			for (String val : rrh) {
				mr.add("H" + val);
			}
		}

		// vertical
		if (cr + 1 <= er) {
			ArrayList<String> rrv = mazePath(cr + 1, cc, er, ec);

			for (String val : rrv) {
				mr.add("V" + val);
			}
		}
		
		return mr;
	}

}
