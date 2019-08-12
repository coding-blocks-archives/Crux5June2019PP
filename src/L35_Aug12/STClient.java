package L35_Aug12;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Aug-2019
 *
 */

public class STClient {

	public static void main(String[] args) {

		int[] arr = { -2, 8, 9, 10, 6, 5, 4 };
		SegmentTree st = new SegmentTree(arr, new STMin());

		st.display();

		System.out.println(st.query(2, 5));

		st.update(4, 16);

		st.display();
		System.out.println(st.query(2, 5));
	}
}
