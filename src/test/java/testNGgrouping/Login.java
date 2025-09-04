package testNGgrouping;

import org.testng.annotations.Test;

public class Login 
{
	@Test(priority=1,groups= {"regression"})
void loginByEmail()
{
	System.out.println("This is login by Email");
}
	@Test(priority=2,groups= {"regression"})
void loginByFaceBook()
{
	System.out.println("This is login by facebook");
}
	@Test(priority=3,groups= {"regression"})
void loginBytwitter()
{
	System.out.println("This is login by twitter");
}
}
