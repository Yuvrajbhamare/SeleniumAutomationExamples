package parallelTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParelleTesting {
	WebDriver driver;

	@BeforeClass
	@Parameters({ "browser" })
	void setup(String br) throws InterruptedException

	{
		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid Browser");
			return;
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://stagingb.www.sscconsolidation.com/home");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='usernamelogin']")).sendKeys("delete18june25@yopmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@id='basic-addon2']")).click();
		// driver.findElement(By.xpath("//input[@id='usernamelogin']")).sendKeys("YuvrajBhamare@gmail.com");
		driver.findElement(By.xpath("//input[@id='passwordlogin']")).sendKeys("Admin@2029");
		driver.findElement(By.xpath("//span[@id='signInBtn']")).click();
		driver.findElement(By.xpath(
				"//div[@id='profile-box-modal-cognito']//button[@class='btn btn-cta text-white'][normalize-space()='Go']"))
				.click();
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	void testlogo() {
		boolean status = driver
				.findElement(By
						.xpath("//img[@src='https://stagingb.www.sscconsolidation.com/include/images/SSC-Logo.webp']"))
				.isDisplayed();
		AssertJUnit.assertEquals(status, true);
	}

	@Test(priority = 2)
	void testTitle() {
		AssertJUnit.assertEquals(driver.getTitle(), "SSC Consolidation - Your Global Consolidator");
	}

	@Test(priority = 3)
	void testURL() {
		AssertJUnit.assertEquals(driver.getCurrentUrl(),
				"https://stagingb.www.sscconsolidation.com/website/home/index.php");
	}

	@AfterMethod
	@AfterClass
	void tearDown() {
		driver.quit();
	}

}
