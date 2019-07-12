package L15_July12;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Jul-2019
 *
 */

public class TimeSpaceDemo {

	public static void main(String[] args) {

		// System.out.println(polynomial(5, 7));

		System.out.println(palindromicSScount("nnitin"));

	}

	public static int polynomial(int x, int n) {

		int sum = 0;

		int multiplier = x;

		for (int coeff = n; coeff >= 1; coeff--) {
			sum = sum + coeff * multiplier;
			multiplier = multiplier * x;
		}

		return sum;

	}

	public static int palindromicSScount(String str) {

		int count = 0;

		// odd length palindromic ss
		for (int axis = 0; axis <= str.length() - 1; axis++) {

			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {

				if (str.charAt(axis - orbit) == str.charAt(axis + orbit)) {
					count++;
				} else {
					break;
				}
			}
		}

		// even length palindromic ss
		for (double axis = 0.5; axis <= str.length() - 1; axis++) {

			for (double orbit = 0.5; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {

				if (str.charAt((int) (axis - orbit)) == str.charAt((int) (axis + orbit))) {
					count++;
				} else {
					break;
				}
			}
		}

		return count;

	}

	
}
