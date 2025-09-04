package takesscreenshots;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UsingExtensionsAndAdBlock {

	public static void main(String[] args) {
		/// HOW TO ENABLE EXTENSIONS IN RUN TIME AND USE EXTENSTION TO AD BLOCK (SOME
		/// TIMES AD COMES ON WEBPAGE)
		// Step 1:Add CRX Extractor to chrome browser(Manualy)
		// Step 2:Add required plugin or extension to chrome browser
		/// (Manualy)eg.Selectors Hub or Ad Block
		// Step 3:Capture crx file for that required plugin eg for selectors hub by
		/// right click (this right click activity will be on chrome webstore page it
		/// selsef)
		// Step 4:Pass crx file path in automation script by using ChromeOptions class

		ChromeOptions options = new ChromeOptions();
		File file = new File("C:\\AutomationFiles\\uBlock-Chrome-Web-Store.crx");
		options.addExtensions(file);
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://text-compare.com/");
	}

}
