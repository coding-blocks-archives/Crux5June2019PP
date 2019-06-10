package L3_June10;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Jun-2019
 *
 */

public class Rotate {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int r = scn.nextInt();

		// no. of digits
		int temp = n ;
		int nod = 0;
		while (temp != 0) {
			nod = nod + 1;
			temp = temp / 10;
		}

		r = r % nod ;
		if(r < 0) {
			r = r + nod ;
		}
		
		// rotation // 123456
		int divisor = (int) Math.pow(10, r); // 10^4
		int rem = n % divisor; // 3456
		int quo = n / divisor; // 12

		int multiplier = (int) Math.pow(10, nod - r); // 10^2

		int ans = rem * multiplier + quo; // 345612

		System.out.println(ans);

	}
}
