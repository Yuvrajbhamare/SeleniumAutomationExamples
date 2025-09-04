package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo1 
{

	@Test
	void ApplicationName()
	{
		String Exp_Title="OpenCart";
		String Actaul_Title="OpenCart";
		//Assert.assertEquals(Actaul_Title, Exp_Title);
		                   //OR
		if(Exp_Title.equals(Actaul_Title))
		{
			System.out.println("Test case Passed");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Test case Failed");
			Assert.assertTrue(false);
		}
	}
	
}
