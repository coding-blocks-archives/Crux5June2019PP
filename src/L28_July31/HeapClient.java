package L28_July31;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 31-Jul-2019
 *
 */

public class HeapClient {

	public static void main(String[] args) {

		Heap heap = new Heap();

		heap.add(50);
		heap.display();
		heap.add(30);
		heap.display();
		heap.add(5);
		heap.display();
		heap.add(10);
		heap.display();
		heap.add(3);
		heap.display();

		while (!heap.isEmpty()) {
			System.out.println(heap.remove());
			heap.display();
		}

	}
}
