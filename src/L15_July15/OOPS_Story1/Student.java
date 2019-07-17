package L15_July15.OOPS_Story1;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 15-Jul-2019
 *
 */

public class Student {

	// data members
	String name = "ABC";
	int age = 100;

	// default constructor
	public Student() {

	}

	// parametrized constructor
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// parametrized constructor
	public Student(String name, int age, int rollno) {
		this.name = name;
		this.age = age;
	}

	public void introduceYourself() {
		System.out.println(name + " is " + age + " years old.");
	}

	public void sayHi(String name) {
		System.out.println(this.name + " says hi to " + name);

	}

}
