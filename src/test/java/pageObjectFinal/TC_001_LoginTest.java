package pageObjectFinal;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(parallelTesting.Listener.class)
public class TC_001_LoginTest

{
	WebDriver driver;

	@BeforeClass
	void openApp() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

	}

	@Test
	public void login() {
		LoginPage lp = new LoginPage(driver);
		lp.username_method("Admin");
		lp.password_method("admin123");
		lp.Login_method();
	}

}
