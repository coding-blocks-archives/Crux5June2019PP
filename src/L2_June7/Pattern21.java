package L2_June7;

import org.omg.Messaging.SyncScopeHelper;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 07-Jun-2019
 *
 */

public class Pattern21 {

	public static void main(String[] args) {

		int n = 13;

		int nst = 1;
		int nsp = 2 * n - 3;

		int row = 1;

		while (row <= n) {

			// work
			// stars
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			// spaces
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp + 1;
			}

			cst = 1;
			
			if(row == n)
				cst = 2 ;
			
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			// prep
			System.out.println();

			nst = nst + 1;
			nsp = nsp - 2;

			row = row + 1;
		}

	}
}
