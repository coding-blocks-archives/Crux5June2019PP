package L16_July16;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 16-Jul-2019
 *
 */

public class QClient {

	public static void main(String[] args) throws Exception {

		Queue q = new Queue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);

		q.display();

		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

		q.enqueue(60);
		q.enqueue(70);

		q.display();

	}
}
