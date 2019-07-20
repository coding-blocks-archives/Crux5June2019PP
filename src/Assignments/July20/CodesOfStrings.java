package may28;

import java.util.ArrayList;

public class CodesOfStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printCodes("1125", "");
		System.out.println(printCodes("1125"));

	}

	public static void printCodes(String ques, String ans) {

		if (ques.length() == 0) {

			System.out.println(ans);
			return;
		}

		// Ros
		String ros1 = ques.substring(1);

		// Converted in code
		String char1 = ques.substring(0, 1);
		int val1 = Integer.parseInt(char1);
		char res1 = (char) ('a' + val1 - 1);

		// Call
		printCodes(ros1, ans + res1);

		if (ques.length() >= 2) {

			String char2 = ques.substring(0, 2);
			int val2 = Integer.parseInt(char2);

			if (val2 < 27) {
				char res2 = (char) ('a' + val2 - 1);

				String ros2 = ques.substring(2);

				printCodes(ros2, ans + res2);
			}
		}
	}

	public static ArrayList<String> printCodes(String ques) {

		if (ques.length() == 0) {

			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		// Ros
		String ros1 = ques.substring(1);

		// Converted in code
		String char1 = ques.substring(0, 1);
		int val1 = Integer.parseInt(char1);
		char res1 = (char) ('a' + val1 - 1);

		// Call
		ArrayList<String> rr1 = printCodes(ros1);

		for (String r : rr1) {
			mr.add(res1 + r);
		}

		if (ques.length() >= 2) {

			String char2 = ques.substring(0, 2);
			int val2 = Integer.parseInt(char2);

			if (val2 < 27) {
				char res2 = (char) ('a' + val2 - 1);

				String ros2 = ques.substring(2);

				ArrayList<String> rr2 = printCodes(ros2);
				for (String r : rr2) {
					mr.add(res2 + r);
				}

			}
		}

		return mr;
	}

}
