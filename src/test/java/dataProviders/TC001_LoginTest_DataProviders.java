package dataProviders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_LoginTest_DataProviders

{
	WebDriver driver;

	@BeforeClass
	@Parameters({ "browser", "Url" })
	public void openApp(String br, String Url) {

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
			System.out.println("Incorrect broswer");
			return;
		}

		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(dataProvider = "dp")
	public void login(String username, String password) throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();

		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		driver.navigate().refresh();
		Thread.sleep(3000);

	}

	@DataProvider(name = "dp")
	Object[][] logindata() {
		return new Object[][] { { "Admin", "admin123" }, { "Yuvraj2", "Pass2344" }, { "yuvraj3", "Pass345" } };

	}

}
