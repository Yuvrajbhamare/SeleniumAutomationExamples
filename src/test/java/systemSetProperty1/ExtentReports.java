package systemSetProperty1;

//public class ExtentReports implements ITestListener {
// public ExtentSparkReporter sparkReporter;
// public ExtentReports extent;
// public ExtentTest test;

// String repName;

/*
 * public void onStart(ITestContext testcontext) { String timestamp = new
 * SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); repName =
 * "Test-Report-" + timestamp + ".html"; // Specified location of Report which
 * will be generated sparkReporter = new ExtentSparkReporter(".\\Reports\\" +
 * repName); // Title of the Report
 * sparkReporter.config().setDocumentTitle("SCAN ONLINEAUTOMATION REPORT");
 * sparkReporter.config().setReportName("FUNCTIONAL TESTING");
 * sparkReporter.config().setTheme(Theme.STANDARD); extent = new
 * ExtentReports(); extent.attachReporter(sparkReporter);
 * extent.setSystemInfo("APPLICATION", "SCAN ONLINE");
 * extent.setSystemInfo("MODULE", "END TO END TESTING");
 * extent.setSystemInfo("USERNAME", System.getProperty("user.name"));
 * extent.setSystemInfo("ENVIRONMENT", "QA"); // Getting data from XML String os
 * = testcontext.getCurrentXmlTest().getParameter("os");
 * extent.setSystemInfo("Operating System", os); String browser =
 * testcontext.getCurrentXmlTest().getParameter("browser");
 * extent.setSystemInfo("browser", browser); // If Group run List<String>
 * includedGroups = testcontext.getCurrentXmlTest().getIncludedGroups(); if
 * (!includedGroups.isEmpty()) { extent.setSystemInfo("Groups",
 * includedGroups.toString()); } }
 * 
 * public void onTestSuccess(ITestResult result) { test =
 * extent.createTest(result.getTestClass().getName()); // To display groups in
 * report test.assignCategory(result.getMethod().getGroups());
 * test.log(Status.PASS, result.getName() + "got successfully executed"); }
 * 
 * public void OnTestFailure(ITestResult result) { test =
 * extent.createTest(result.getTestClass().getName());
 * test.assignCategory(result.getMethod().getGroups()); test.log(Status.FAIL,
 * result.getName() + "got Failed"); test.log(Status.INFO,
 * result.getThrowable().getMessage()); try {
 * 
 * String imgPath = new BaseClass().captureScreen(result.getName());
 * test.addScreenCaptureFromPath(imgPath); } catch (IOException e1) {
 * e1.printStackTrace(); } }
 * 
 * public void OnTestSkipped(ITestResult result) { test =
 * extent.createTest(result.getTestClass().getName());
 * test.assignCategory(result.getMethod().getGroups()); test.log(Status.SKIP,
 * result.getName() + "Got Skipped"); test.log(Status.INFO,
 * result.getThrowable().getMessage()); }
 * 
 * public void OnFinish(ITestContext testContext) { extent.flush();
 * 
 * // This is to automatically open the report in the URI after the
 * exectution,this // is not mandatory,you can comment this also String
 * pathExtentReport = System.getProperty("user.dir") + "\\Reports\\" + repName;
 * File extentReport = new File(pathExtentReport);
 * 
 * try { Desktop.getDesktop().browse(extentReport.toURI()); } catch (IOException
 * e) {
 * 
 * e.printStackTrace(); } }
 * 
 * }
 */