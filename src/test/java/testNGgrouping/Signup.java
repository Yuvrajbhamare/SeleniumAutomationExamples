package testNGgrouping;

import org.testng.annotations.Test;

public class Signup 
{
	@Test(priority=1,groups= {"sanity"})
	void SignupByEmail()
	{
		System.out.println("This is SignupByEmail");
	}
		@Test(priority=2,groups= {"sanity"})
	void SignupByFaceBook()
	{
		System.out.println("This is ignupByFaceBook");
	}
		@Test(priority=3,groups= {"sanity"})
	void SignupBytwitter()
	{
		System.out.println("This is SignupBytwitter");
	}
}
