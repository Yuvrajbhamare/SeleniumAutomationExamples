package practiceSet3;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class practice4

{
	@BeforeClass
	public void m1() {
		System.out.println("Beforeclass method m1");
	}

	@Test(priority = 2, groups = { "sanity" })
	public void m2() {
		System.out.println("method m2");
	}

	@Test(priority = 3, groups = { "sanity" })
	public void m3() {
		System.out.println("method m3");
	}

	@Test(priority = 4, groups = { "regression", "sanity" })
	public void m4() {
		System.out.println("method m4");
	}

	@Test(priority = 5)
	public void m5() {
		System.out.println("method m5");
	}

	@AfterClass
	public void m6() {
		System.out.println("Afterclass method m6");
	}

}