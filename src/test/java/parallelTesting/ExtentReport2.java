package parallelTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExtentReport2 
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

		@DataProvider(name = "dp")
		Object[][] logindata() {
			Object Data[][]={
				{ "yuvrajbhamare11@gmail.com", "Admin@123" },
				{ "yuvrajbhamare12@gmail.com", "Admin@1234" },
				{ "yuvrajbhamare14@gmail.com", "Admin@125" },
			};
			return Data;

		}
		
		//if want multiple data providers into multiple methods,we can create,juts we need to give different names to data provider methods like name=dp,name=dp1,name=dp3 etc
		//if want Data provider data based on the choice,for first and last data only
		@DataProvider(name = "dp2",indices= {0,2})
		Object[][] logindata2() {
			Object Data[][]={
				{ "yuvrajbhamare11@gmail.com", "Admin@123" },//0
				{ "yuvrajbhamare12@gmail.com", "Admin@1234" },//1
				{ "yuvrajbhamare14@gmail.com", "Admin@125" },//2
			};
			return Data;
		}
		
	}





//button[normalize-space()='Login']
//a[normalize-space()='Office']
//a[@class='nav-link track-menu']


