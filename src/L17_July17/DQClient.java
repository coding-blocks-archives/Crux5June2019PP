package L17_July17;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Jul-2019
 *
 */

public class DQClient {

	public static void main(String[] args) throws Exception {
		
		DynamicQueue dq = new DynamicQueue() ;
		
		dq.enqueue(10);
		dq.enqueue(10);
		dq.enqueue(10);
		dq.enqueue(10);
		dq.enqueue(10);
		dq.enqueue(10);
		
		dq.display();
	}
}
