package L34_Aug10;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Aug-2019
 *
 */

public abstract class DataStructure {

	int size;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public abstract void display();
}
