package takesscreenshots;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BlockingAdsOnWebPage {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		File file = new File("C:\\AutomationFiles\\SelectorsHub-Chrome-Web-Store.crx");
		options.addExtensions(file);
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://staging.www.sscconsolidation.com/home");
	}

}
