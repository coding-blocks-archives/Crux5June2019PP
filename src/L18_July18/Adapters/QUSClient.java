package L18_July18.Adapters;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Jul-2019
 *
 */

public class QUSClient {

	public static void main(String[] args) throws Exception {
		
		QueueUsingStackDeqEff queue = new QueueUsingStackDeqEff() ;
		
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		
		queue.display();

		System.out.println(queue.dequeue());		
		queue.display();
		
		queue.enqueue(60);
		
		queue.display();
	}
}
