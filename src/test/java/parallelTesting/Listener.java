package parallelTesting;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener

{
	public void onStart(ITestContext context) 
	{
		System.out.println("Test Execution sccessfully started");
	}

	public void onTestStart(ITestResult result)
    {
		System.out.println("Test case successfully started"); 
	}

	public void  onTestSuccess(ITestResult result) 
	{
		System.out.println("Test case successfully passed"); 
	}

	public void  onTestFailure(ITestResult result) 
	{
		System.out.println("Test case failed");
	}

	public void  onTestSkipped(ITestResult result) 
	{
		System.out.println("Test case skipped"); 
	}
	public void  onFinish(ITestContext context) 
	{
		System.out.println("Test execution finished");
	}

}
