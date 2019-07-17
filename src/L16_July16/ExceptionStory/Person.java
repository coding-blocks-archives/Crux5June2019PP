package L16_July16.ExceptionStory;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 16-Jul-2019
 *
 */

public class Person {

	private String name;
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws Exception {

		System.out.println("in set age");

		if (age < 0) {
			throw new Exception("Invalid Age");
		}

		this.age = age;
	}

	public void fun(int age) throws MyException {

		System.out.println("hi fun");

		if (age < 0) {
			throw new MyException("Invalid Age");
		}

		System.out.println("bye fun");
	}

	public String toString() {
		return name + " " + age;
	}
}
