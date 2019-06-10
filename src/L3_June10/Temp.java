package L3_June10;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Jun-2019
 *
 */

public class Temp {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int minF = scn.nextInt();
		int maxF = scn.nextInt();
		int step = scn.nextInt();

		int temp = minF;

		while (temp <= maxF) {

			int c = (int) ((5.0 / 9) * (temp - 32));
			System.out.println(temp + "\t" + c);

			temp = temp + step;
		}

	}
}





