package practiceSet3;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(practiceSet3.MyListners.class)
public class LoginTest {
	WebDriver driver;

	@BeforeClass
	public void OpenApp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://uat.www.sscconsolidation.com/home");

	}

	@Test(priority = 1)
	void Test() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.clickLogin();
		lp.EnterEmail("delete18june25@yopmail.com");
		Thread.sleep(2000);
		lp.ClickOnGo();
		lp.EnterPassword("Admin@2029");
		lp.LoginBtn22();
		SoftAssert Assert = new SoftAssert();
		Assert.assertEquals("Home Page ", driver.getTitle());
		System.out.println("Statement executed after Asert failing ");

	}

}
