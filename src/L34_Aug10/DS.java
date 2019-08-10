package L34_Aug10;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Aug-2019
 *
 */

public class DS extends Stack {

	@Override
	public int pop() {
		size++;

		System.out.println(isEmpty());
		return size;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

}
