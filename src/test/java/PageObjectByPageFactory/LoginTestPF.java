package PageObjectByPageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTestPF {
	WebDriver driver;

	@BeforeClass
	void setUp() {
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}

	@Test
	public void LoginCheck()
	{
	LoginPagePF lpf = new LoginPagePF(driver);
		
			lpf.ClickLogin();
			lpf.SetEmail("Yuvrajbhamare17@gmail.com");
			lpf.ClickGoButton();
			lpf.setPassword("Admin@20211");
			lpf.clickOnSignIn();
		}

	}

