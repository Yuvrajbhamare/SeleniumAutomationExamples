package systemSetProperty1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MouseHover {
	WebDriver driver;

	@BeforeClass
	@Parameters({ "browser", "URL" })
	public void launchapp(String br, String URL) {
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
			System.out.println("Invalid browser");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get(URL);
	}

	@Test(dataProvider = "dp", dependsOnMethods = { "launchapp" })
	public void logintoapp(String email, String password) throws InterruptedException {
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		WebElement username1 = driver.findElement(By.xpath("//input[@id='usernamelogin']"));
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(username1));
		username1.sendKeys(email);
		driver.findElement(By.xpath("//span[@id='basic-addon2']")).click();
		driver.findElement(By.xpath("//input[@id='passwordlogin']")).sendKeys(password);

		driver.navigate().refresh();

	}

	@DataProvider(name = "dp")
	Object[][] logindata() {
		return new Object[][] { { "yuvrajbhamare11@gmail.com", "Admin@123" },
				{ "yuvrajbhamare11@gmail.com", "Admin@134" }, { "yuvrajbhamare11@gmail.com", "Admin@194" },
				{ "yuvrajbhamare11@gmail.com", "Admin@164" }, };

	}

}
