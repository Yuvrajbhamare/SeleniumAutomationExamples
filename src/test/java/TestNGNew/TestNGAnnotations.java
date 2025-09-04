package TestNGNew;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations 
{
	@BeforeMethod
	 void Login()
	{
		System.out.println("User Logged In");
	}
	 @Test(priority=1)
	 void search()
	 {
		 System.out.println("User search completed");
	 }
	 @Test(priority=2)
	 void Advancedsearch()
	 {
		 System.out.println("User Advanced search completed");
	 }
	 @AfterMethod
	 void logout()
	 {
		 System.err.println("User Logged Out Successfully");
	 }
}
