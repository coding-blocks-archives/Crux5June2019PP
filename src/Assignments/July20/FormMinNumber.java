package Assignments.July20;

public class FormMinNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		form("IDDD");
	}

	public static void form(String str) {

		int[] res = new int[str.length() + 1];

		int num = 1;

		for (int i = 0; i <= str.length(); i++) {

			if (i == str.length() || str.charAt(i) == 'I') {

				res[i] = num;
				num++;

				for (int j = i - 1; j >= 0 && str.charAt(j) != 'I'; j--) {

					res[j] = num++;
				}

			}
		}

		for (int val : res) {

			System.out.print(val);
		}

	}

}
