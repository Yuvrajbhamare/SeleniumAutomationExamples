package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest 
{
	WebDriver driver;
	@BeforeClass
	void SetUp()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
	}
	@Test
	void test() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.ClickLogin();
		lp.setEmail("yuvrajbhamare17@gmail.com");
		lp.ClickOnGoButton();
		Thread.sleep(2000);
		lp.setPwd("Admin@2049");
		lp.ClickOnSignIn();
		Assert.assertEquals(driver.getTitle(),"OraneHRM Page" );
	}
	void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	

}
