package Assignments.July20;

public class DictionaryOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		prmt("cab", "", "cab");
		System.out.println("updated");
		prmt("cab", "", false);
	}

	public static void prmt(String ques, String ans, String orig) {

		if (ques.length() == 0) {

			if (ans.compareTo(orig) > 0)
				System.out.println(ans);

			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String ros = ques.substring(0, i) + ques.substring(i + 1);

			prmt(ros, ans + ch, orig);
		}

	}

	public static void prmt(String ques, String ans, boolean isLarger) {

		if (ques.length() == 0 && isLarger) {
			System.out.println(ans + " ");
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String ros = ques.substring(0, i) + ques.substring(i + 1);

			if (isLarger) {
				prmt(ros, ans + ch, true);
			} else if (ch > ques.charAt(0))
				prmt(ros, ans + ch, true);
			else if (ch == ques.charAt(0))
				prmt(ros, ans + ch, false);
		}

	}

}
