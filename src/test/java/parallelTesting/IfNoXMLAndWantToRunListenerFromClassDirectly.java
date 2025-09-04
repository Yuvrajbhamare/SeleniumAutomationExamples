package parallelTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(parallelTesting.Listener.class)
@Listeners(parallelTesting.Listener.class)
public class IfNoXMLAndWantToRunListenerFromClassDirectly 
{
	
		WebDriver driver;
		@BeforeClass
		public void openapp() throws InterruptedException {
			driver = new ChromeDriver();
			driver.get("https://staging.www.shipco.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			Thread.sleep(3000);
		}

		@Test(dataProvider = "dp")
		void Login(String email, String password) throws InterruptedException {
			driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='usernamelogin']")).sendKeys(email);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[@id='basic-addon2']")).click();
			driver.findElement(By.xpath("//input[@id='passwordlogin']")).sendKeys(password);
			System.out.println("Username and password entered successfully");
	        driver.findElement(By.xpath("//span[@id='signInBtn']")).click();
			Thread.sleep(3000);
			boolean val1 = driver.findElement(By.xpath("//div[@id='profile-box-modal-cognito']//select[@class='form-control']")).isDisplayed();
			System.out.println("Go button is Displayed: " + val1);
	        // Logout or navigate back if needed here
			driver.navigate().refresh(); // Optional, to reset state
			Thread.sleep(2000);
		}
		@AfterClass
		void tearDown() {
			driver.quit(); // Better than close()
		}


}