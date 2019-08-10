package L33_Aug9.StaticStory;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 09-Aug-2019
 *
 */

public class Client {

	public static void main(String[] args) {

		Student s1 = new Student("A");
		Student s2 = new Student("B");
		Student s3 = new Student("B");

		System.out.println(s1.getRollNo());
		System.out.println(s2.getRollNo());

		System.out.println(Student.nos);
		System.out.println(Student.getNOS());

		System.out.println(Math.max(2, 3));
	}
}
