package takesscreenshots;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Takesscreenshot {
	public static void main(String args[]) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// TakesScreenshot ts = (TakesScreenshot)driver; File
		// sourcefile=ts.getScreenshotAs(OutputType.FILE); File
		// sourcefile1=ts.getScreenshotAs(OutputType.FILE); File targetfile1=new
		// File(System.getProperty("user.dir")+"\\SCREENSHOTNEW1.png"); File
		// targetfile=new
		// File(System.getProperty("user.dir")+"\\ScreenshotsNew\\Rail.png");
		// sourcefile.renameTo(targetfile);//Copy Source File to Target File
		// sourcefile1.renameTo(targetfile1);

		// capturing Screenshot of specific area of web page
		// this below code is giving error somehow,not found reason
		// WebElement rail =
		// driver.findElement(By.xpath("//div[@class='header-lower']"));
		// File sourcefile = rail.getScreenshotAs(OutputType.FILE);
		// File targetFile = new
		// File(System.getProperty("C:\\Users\\ybhamare\\eclipse-workspace\\SeleniumNecessaryCodesPractice\\ScreenshotsNew\\Rail.png"));
		// sourcefile.renameTo(targetFile);

	}
}
