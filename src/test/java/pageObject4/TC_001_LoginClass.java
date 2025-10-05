package pageObject4;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_001_LoginClass {

	WebDriver driver;

	@BeforeClass
	public void openApp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@Test
	public void Login() {
		Loginpage lp = new Loginpage(driver);
		lp.usernameM("Admin");
		lp.PasswordM("admin123");
		lp.Login_BtnM();

	}
}
