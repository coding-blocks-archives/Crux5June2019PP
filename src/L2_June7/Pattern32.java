package L2_June7;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Jun-2019
 *
 */

public class Pattern32 {

	public static void main(String[] args) {

		int n = 5;

		int nst = 1;
		int val = 1;
		int row = 1;

		while (row <= 2 * n - 1) {

			int cst = 1;
			while (cst <= nst) {

				if (cst % 2 == 0)
					System.out.print("*");
				else
					System.out.print(val);

				cst = cst + 1;
			}

			// prep
			System.out.println();
			if (row <= n - 1) {
				nst = nst + 2;
				val = val + 1;
			} else {
				nst = nst - 2;
				val = val - 1;
			}

			row = row + 1;
		}

	}
}
