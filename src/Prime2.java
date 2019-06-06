
/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 05-Jun-2019
 *
 */

public class Prime2 {

	public static void main(String[] args) {

		int n = 9;

		int div = 2;
		int flag = 0;

		while (div <= n - 1) {

			if (n % div == 0) {
				flag = 1;
				break;
			}

			div = div + 1;
		}

		if (flag == 0) {
			System.out.println("Prime");
		} else {
			System.out.println("Not Prime");
		}

	}
}
