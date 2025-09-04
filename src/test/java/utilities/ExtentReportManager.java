package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	String repName;

	@Override
	public void onStart(ITestContext testcontext) {
		// Timestamp of Report
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report-" + timestamp + ".html";

		// Specified location of Report which will be generated
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);
		// Title of the Report
		sparkReporter.config().setDocumentTitle("PRACTICE AUTOMATION REPORT");
		sparkReporter.config().setReportName("FUNCTIONAL TESTING");
		sparkReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("APPLICATION", "SCAN ONLINE");
		extent.setSystemInfo("MODULE", "END TO END TESTING");
		extent.setSystemInfo("USERNAME", System.getProperty("user.name"));
		extent.setSystemInfo("ENVIRONMENT", "QA");

		// Getting data from XML
		String os = testcontext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		String browser = testcontext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("browser", browser);

		// If Group run

		List<String> includedGroups = testcontext.getCurrentXmlTest().getIncludedGroups();
		if (!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		// To display groups in report
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName() + "got successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName() + "got Failed");
		test.log(Status.INFO, result.getThrowable().getMessage());

		/*
		 * try {
		 * 
		 * String imgPath = new BaseClass().captureScreen(result.getName());
		 * test.addScreenCaptureFromPath(imgPath); } catch (IOException e1) {
		 * e1.printStackTrace(); }
		 */

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName() + "Got Skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}

	@Override
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
}
