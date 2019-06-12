package L4_June12;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Jun-2019
 *
 */

public class FunctionDemo {

	static int num = 100;

	public static void main(String[] args) {

		System.out.println("Hi");

		System.out.println("----------- Part-1 -----------");
		addition();
		subtraction();

		System.out.println("----------- Part-2 -----------");
		int a = 60;
		int b = 40;
		additionParams(a, b);
		System.out.println(a);

		System.out.println("----------- Part-3 -----------");
		int val = 90;
		int res = additionReturn(val, b);
		System.out.println(res);

		System.out.println("----------- Part-4 -----------");
		System.out.println(num); // 100 -> global
		int num = 10;
		System.out.println(num); // 10 -> local
		System.out.println(FunctionDemo.num); // 100 -> global

		int one1 = 15;
		System.out.println(DemoGlobalScopes(one1));
		System.out.println(FunctionDemo.num);

		// Part 6 - Pass by value
		System.out.println("----------- Part-5 -----------");
		int one = 10, two = 20;
		System.out.println(one + ", " + two);
		Swap(one, two);
		System.out.println(one + ", " + two);

	}

	public static void Swap(int one, int two) {
		System.out.println(one + ", " + two);

		int temp = one;
		one = two;
		two = temp;

		System.out.println(one + ", " + two);
	}

	public static int DemoGlobalScopes(int another) {

		int num = 200;
		FunctionDemo.num = 500;
		int sum = another + num;
		return sum;
	}

	public static int additionReturn(int a, int b) {

		int sum = a + b;
		return sum;
	}

	public static void additionParams(int a, int b) {

		a = 10;
		System.out.println(a);
		int sum = a + b;
		System.out.println(sum);
	}

	// fxn definition
	public static void addition() {

		int a = 2;
		int b = 3;
		int sum = a + b;

		System.out.println(sum);
		subtraction();

		System.out.println("hello");
	}

	public static void subtraction() {

		int a = 20;
		int b = 3;
		int sub = a - b;
		System.out.println(sub);

	}

}
