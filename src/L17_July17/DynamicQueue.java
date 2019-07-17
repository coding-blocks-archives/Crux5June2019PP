package L17_July17;

import L16_July16.Queue;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Jul-2019
 *
 */

public class DynamicQueue extends Queue {

	@Override
	public void enqueue(int item) throws Exception {

		if (isFull()) {

			// create a new array of twice size
			int[] na = new int[2 * data.length];

			// copy the old elements
			for (int i = 0; i < size(); i++) {
				int idx = (i + front) % data.length;
				na[i] = data[idx];
			}

			// reference
			data = na;
			front = 0;

		}

		super.enqueue(item);

	}

}
