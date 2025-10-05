package dataProviderConcept;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dataProviderConcept2

{
	WebDriver driver;

	@BeforeClass
	@Parameters({ "browser" })
	public void openApp(String br) {

		switch (br.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Invalid Broser passed");
			return;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test(dataProvider = "dp")
	public void LoginMethod(String username, String password) throws InterruptedException {

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		if (driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index")) {
			System.out.println("Logged in successfully with user:=>" + username);
			driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
			Assert.assertEquals(true, true);
		} else {
			System.out.println("Login failed with this user:=>" + username);
			Assert.assertEquals(true, true);

		}

	}

	@DataProvider(name = "dp")
	Object[][] logindata() {
		return new Object[][] { { "Admin", "admin123" }, { "Yuvrajun", "BhamPass" },
				{ "Usernametest2", "Passwordtest2" }, };

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
