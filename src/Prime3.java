
/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 05-Jun-2019
 *
 */

public class Prime3 {

	public static void main(String[] args) {

		int n = 9;

		int div = 2;

		while (div <= n - 1) {

			if (n % div == 0) {
				break;
			}

			div = div + 1;
		}

		if (div == n) {
			System.out.println("Prime");
		} else {
			System.out.println("Not Prime");
		}

	}
}
