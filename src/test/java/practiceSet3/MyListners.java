package practiceSet3;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListners implements ITestListener
{
	public void onTestStart(ITestResult result) 
	{
	    System.out.println("onTestStart");
	  }

	 
	public void onTestSuccess(ITestResult result) {
	    System.out.println("This is onTestSuccess");
	  }

	public void onTestFailure(ITestResult result) {
		 System.out.println("This is onTestFailure");
	  }

	 
	public void onTestSkipped(ITestResult result) {
		 System.out.println("This is onTestSkipped");
	  }

	 
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		 System.out.println("onTestFailedButWithinSuccessPercentage");
	  }

	
	  public void onTestFailedWithTimeout(ITestResult result) 
	  {
	    onTestFailure(result);
	    System.out.println("onTestFailedWithTimeout");
	  }

	
	  public void onStart(ITestContext context) {
		  System.out.println("Test Execution started successfully");
	  }

	  
	  public void onFinish(ITestContext context) {
		  System.out.println("onFinish");
	  }
}
