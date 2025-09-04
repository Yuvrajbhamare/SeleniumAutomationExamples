package ssl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SecuredSocketLock {
	public static void main(String[] args) {
		// ChromeOptions options = new ChromeOptions();
		// OR
		// EdgeOptions options=new EdgeOptions();
		// OR
		FirefoxOptions options = new FirefoxOptions();
		options.setAcceptInsecureCerts(true);
		// WebDriver driver=new EdgeDriver(options);
		WebDriver driver = new FirefoxDriver(options);
		driver.get("https://expired.badssl.com/");

	}
}
