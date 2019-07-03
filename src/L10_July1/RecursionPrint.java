package L10_July1;

import L9_June28.RecursionGet;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 01-Jul-2019
 *
 */

public class RecursionPrint {

	public static void main(String[] args) {
		// printSS("abc", "");
		// printKPC("145", "");
		// permutationNoDuplicates2("abca", "");
		// validParenthesis(3, 0, 0, "");
		// System.out.println(boardPath(0, 10, ""));

		// System.out.println(mazePath(0, 0, 2, 2, ""));

		System.out.println(lexicoCounting(9, 1000));
	}

	public static void printSS(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSS(roq, ans); // no
		printSS(roq, ans + ch); // yes

	}

	public static void printKPC(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		String code = RecursionGet.getCode(ch);

		for (int i = 0; i < code.length(); i++) {
			printKPC(roq, ans + code.charAt(i));
		}

	}

	public static void printPermutation(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			printPermutation(roq, ans + ch);
		}

	}

	public static void printPermutation2(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		for (int i = 0; i <= ans.length(); i++) {
			printPermutation2(roq, ans.substring(0, i) + ch + ans.substring(i));

		}

	}

	public static void validParenthesis(int n, int open, int close, String ans) {

		if (open == n && close == n) {
			System.out.println(ans);
			return;
		}

		if (open > n || close > n || close > open) {
			return;
		}

		validParenthesis(n, open, close + 1, ans + ")");
		validParenthesis(n, open + 1, close, ans + "(");

	}

	public static void permutationNoDuplicates(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			int c = 0;

			for (int j = i + 1; j < ques.length(); j++) {
				if (ch == ques.charAt(j)) {
					c++;
				}
			}

			if (c == 0)
				permutationNoDuplicates(roq, ans + ch);
		}

	}

	public static void permutationNoDuplicates2(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		boolean[] visited = new boolean[256];

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			if (visited[ch])
				continue;

			visited[ch] = true;

			permutationNoDuplicates2(roq, ans + ch);
		}

	}

	public static int boardPath(int curr, int end, String ans) {

		if (curr == end) {
			System.out.println(ans);
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		int c = 0;
		for (int dice = 1; dice <= 6; dice++) {
			c += boardPath(curr + dice, end, ans + dice);
		}

		return c;

	}

	public static int mazePath(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int ch = mazePath(cr, cc + 1, er, ec, ans + "H");
		int cv = mazePath(cr + 1, cc, er, ec, ans + "V");

		return ch + cv;

	}

	public static int lexicoCounting(int curr, int end) {

		if (curr > end) {
			return 0;
		}

		int c = 0;

		System.out.println(curr);

		int i = 0;

		if (curr == 0)
			i = 1;

		for (; i <= 9; i++) {
			c += lexicoCounting(curr * 10 + i, end);
		}

		return c + 1;
	}

}
