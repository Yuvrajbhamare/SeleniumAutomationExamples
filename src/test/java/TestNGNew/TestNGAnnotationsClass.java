package TestNGNew;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGAnnotationsClass {

	@BeforeClass
	void Login() {
		System.out.println("User Logged In");
	}

	@Test(priority = 1)
	void search() {
		System.out.println("User search completed");
	}

	@Test(priority = 2)
	void Advancedsearch() {
		System.out.println("User Advanced search completed");
	}

	@AfterClass
	void logout() {
		System.err.println("User Logged Out Successfully");
	}
}
