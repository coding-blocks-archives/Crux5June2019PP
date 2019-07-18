package L18_July18.Adapters;

import L17_July17.DynamicQueue;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Jul-2019
 *
 */

public class StackUsingQueuePushEff {

	DynamicQueue primaryQ = new DynamicQueue();

	public void push(int item) throws Exception {

		try {
			primaryQ.enqueue(item);
		} catch (Exception e) {
			throw new Exception("Stack is Full.");
		}

	}

	public int pop() throws Exception {

		try {
			DynamicQueue helperQ = new DynamicQueue();

			while (primaryQ.size() != 1) {
				helperQ.enqueue(primaryQ.dequeue());
			}

			int temp = primaryQ.dequeue();
			primaryQ = helperQ;

			return temp;
		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}

	}

	public int peek() throws Exception {

		try {
			DynamicQueue helperQ = new DynamicQueue();

			while (primaryQ.size() != 1) {
				helperQ.enqueue(primaryQ.dequeue());
			}

			int temp = primaryQ.dequeue();
			helperQ.enqueue(temp);

			primaryQ = helperQ;

			return temp;
		} catch (Exception e) {
			throw new Exception("Stack is Empty.");
		}

	}

	public void display() throws Exception {
		System.out.println("------------------");
		displayReverse(0);
		System.out.println(".");
		System.out.println("------------------");
	}

	private void displayReverse(int count) throws Exception {

		if (count == primaryQ.size()) {
			return;
		}

		int temp = primaryQ.dequeue();
		primaryQ.enqueue(temp);

		displayReverse(count + 1);

		System.out.print(temp + " ");

	}
}
