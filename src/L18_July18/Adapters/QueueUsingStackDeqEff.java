package L18_July18.Adapters;

import L17_July17.DynamicStack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Jul-2019
 *
 */

public class QueueUsingStackDeqEff {

	DynamicStack primaryS = new DynamicStack();

	public void enqueue(int item) throws Exception {

		try {
			DynamicStack helperS = new DynamicStack();

			while (primaryS.size() != 0) {
				helperS.push(primaryS.pop());
			}

			helperS.push(item);

			while (helperS.size() != 0) {
				primaryS.push(helperS.pop());
			}
		} catch (Exception e) {
			throw new Exception("Queue is Full.");
		}

	}

	public int dequeue() throws Exception {

		try {
			return primaryS.pop();
		} catch (Exception e) {
			throw new Exception("Queue is Empty.");
		}
	}

	public int getFront() throws Exception {

		try {
			return primaryS.peek();
		} catch (Exception e) {
			throw new Exception("Queue is Empty.");
		}

	}

	public void display() {
		primaryS.display();
	}

}
