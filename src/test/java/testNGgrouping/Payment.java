package testNGgrouping;

import org.testng.annotations.Test;

public class Payment 
{
	@Test(priority=1,groups= {"regression","sanity"})
void PaymentByDollar()
{
	System.out.println("This is PaymentByDollar");
}
	@Test(priority=2,groups={"regression","sanity"})
void PaymentByRupees()
{
	System.out.println("This is PaymentByRupees");
}
	@Test(priority=3,groups={"regression","sanity","functional"})
void paymentByDinar()
{
	System.out.println("This is paymentByDinar");
}
}

