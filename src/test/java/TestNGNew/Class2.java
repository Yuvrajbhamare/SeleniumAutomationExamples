package TestNGNew;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Class2 {

	@Test
	void m1() {
		System.out.println("M1 from class2");
	}

	@AfterMethod
	void m2() {
		System.out.println("AfterMethod from class2");
	}
}
