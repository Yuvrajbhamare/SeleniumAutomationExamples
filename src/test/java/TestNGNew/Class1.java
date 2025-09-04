package TestNGNew;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Class1 
{
	@Test
void m1()
{
	System.out.println("M1 from class1");
}
@BeforeMethod
void m2()
{
	System.out.println("BeforeMethod from class1");
}
}
