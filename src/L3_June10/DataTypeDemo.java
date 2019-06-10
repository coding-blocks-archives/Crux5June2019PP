package L3_June10;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Jun-2019
 *
 */

public class DataTypeDemo {

	public static void main(String[] args) {

		byte by = 10;
		short sh = 10;
		int in = 10;
		long lo = 10;

		// case 1
		// by = sh ;
		// by = in ;
		// by = lo ;

		sh = by;
		// sh = in ;
		// sh = lo ;

		in = by;
		in = sh;
		// in = lo ;

		lo = by;
		lo = sh;
		lo = in;

		// case 2
		by = 20;

		// by = 0;
		// while (by < 127) {
		// System.out.println(by);
		// by = (byte) (by + 1);
		// }

		// case 3
		in = (int) 10000000000L;
		System.out.println(in);

		lo = 10000000000L;

		// case 4
		float fl = 4.5f;
		double db = 4.5;

		// fl = db ;
		db = fl;

		// case 5
		in = (int) fl;
		System.out.println(in);

		fl = in;
		System.out.println(fl);

		// case 6
		boolean bl = true;

		if (in != 0) {

		}

		if (bl) {

		} else {

		}

		// case 7
		char ch = 'a';
		System.out.println(ch);

		ch = 98;
		System.out.println(ch);

		ch = (char) (ch + 1);
		System.out.println(ch);

		// case 8
		System.out.println(10 + 20 + "Hello" + 10 + 20);
		System.out.println(2 + ' ' + 5);
		System.out.println(2 + " " + 5);
		System.out.println("Hello" + '\t' + "World");
		System.out.println("Hello" + "\t" + "World");
		System.out.println(2 + '\t');

	}
}









