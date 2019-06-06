import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 05-Jun-2019
 *
 */

public class Prime {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int div = 1 ;
		int fact = 0 ;
				
		while(div <= n) {
			
			if(n % div == 0) {
				fact= fact + 1 ;
			}
			
			div = div +1 ;
		}
		
		if(fact == 2) {
			System.out.println("Prime");
		}else {
			System.out.println("Not Prime");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
