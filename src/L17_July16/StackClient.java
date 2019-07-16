package L17_July16;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 16-Jul-2019
 *
 */

public class StackClient {

	public static void main(String[] args) throws Exception {

		Stack s = new Stack();
		s.push(10) ;
		s.push(20) ;
		s.push(30) ;
		s.push(40) ;
		s.push(50) ;
		s.push(60) ;
		s.display();
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		
		
		s.push(60);
		
		s.display();
		
	}
}















