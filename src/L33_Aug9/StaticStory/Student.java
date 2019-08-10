package L33_Aug9.StaticStory;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 09-Aug-2019
 *
 */

public final class Student {

	String name;
	final int rollNo;
	static int nos;

	public Student(String name) {
		nos++;
		rollNo = nos;

		this.name = name;

	}

	// NON STATIC FXN ? VARIABLE ACCESS ? YES
	public final int getRollNo() {
		return this.rollNo;
	}

	// STATIC FXN -> THIS ? NO
	// STATIC FXN -> NON STATIC VARIABLE ? NO
	// STATIC FXN -> STATIC VARIABLE ? YES
	public static int getNOS() {
		return nos;
	}

}
