package L6_June17;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Jun-2019
 *
 */

public class Array2DDemo {

	public static void main(String[] args) {

		int[][] arr = new int[3][4];

		System.out.println(arr.length); // rows
		System.out.println(arr[0].length); // cols

		System.out.println(arr);

		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);

		System.out.println(arr[1][3]);
		arr[1][3] = 80;
		System.out.println(arr[1][3]);

		System.out.println(" -- JAGGED ARRAY -- ");
		int[][] jarr = new int[3][];
		System.out.println(jarr);

		System.out.println(jarr[0]);
		System.out.println(jarr[1]);
		System.out.println(jarr[2]);

		jarr[0] = new int[5];
		jarr[1] = new int[3];
		jarr[2] = new int[7];

		System.out.println(jarr[0]);
		System.out.println(jarr[1]);
		System.out.println(jarr[2]);

		System.out.println(jarr[0].length);
		System.out.println(jarr[1].length);
		System.out.println(jarr[2].length);

		for (int i = 0; i < jarr.length; i++) {

			for (int j = 0; j < jarr[i].length; j++) {

				System.out.print(jarr[i][j] + " ");
			}

			System.out.println();

		}

		for (int[] val : arr) {

			for (int val1 : val) {
				System.out.print(val1 + " ");
			}
			System.out.println();
		}

	}
}
