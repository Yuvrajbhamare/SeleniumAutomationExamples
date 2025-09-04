package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertNotEquals 
{

	@Test
	void method1()
	{
		Assert.assertNotEquals("123", "123");
		//Assert.assertTrue(true);//Passed
		//Assert.assertTrue(false);//Failed
		//Assert.assertFalse(false);//Passed
		//Assert.assertFalse(true);//Failed
		//Assert.fail();//Blindly fails method directly
	}
	
	//OtherAsserts
	
}
