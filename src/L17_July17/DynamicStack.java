package L17_July17;

import L16_July16.Stack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Jul-2019
 *
 */

public class DynamicStack extends Stack {

	@Override
	public void push(int item) throws Exception {

		if (isFull()) {
			int[] na = new int[2 * data.length];

			for (int i = 0; i < data.length; i++) {
				na[i] = data[i];
			}

			data = na;

		}

		super.push(item);

	}

}
