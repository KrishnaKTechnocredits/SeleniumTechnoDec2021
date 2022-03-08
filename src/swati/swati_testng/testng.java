package swati.swati_testng;

import org.testng.annotations.Test;

public class testng {

	@Test(groups="smoke")
	public void first() {
		System.out.println("Hi");
	}

	@Test(groups="sanity")
	public void second() {
		System.out.println("Hello");
	}

	@Test(groups="smoke")
	public void example() {
		System.out.println("Techno");
	}

}
