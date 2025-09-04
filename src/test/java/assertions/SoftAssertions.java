package assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertions 
{

	@Test
	void SoftAssert1()
	{
		System.out.println("Statement 1.......");
		System.out.println("Statement 2.......");
		System.out.println("Statement 3.......");
		System.out.println("Statement 4.......");
		System.out.println("Statement 5.......");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(1, 2);
		System.out.println("Statement 6.......");
		System.out.println("Statement 7.......");
		sa.assertAll();
	}
}
