package TestNGNew;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNG_Practice {

	WebDriver driver;

	@Test(priority = 1)
	public void openapp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://staging.www.shipco.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void Login() throws InterruptedException {
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//input[@id='usernamelogin']")).sendKeys("yuvrajbhamare11@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@id='basic-addon2']")).click();
		// driver.findElement(By.xpath("//input[@id='passwordlogin']")).sendKeys("yuvrajbhamare11@gmail.com");
		driver.findElement(By.xpath("//input[@id='passwordlogin']")).sendKeys("Admin@2044");
		System.out.println("Username and password entered successfully");

	}

	@Test(priority = 3)
	public void Submit() {
		driver.findElement(By.xpath("//span[@id='signInBtn']")).click();
		boolean val1 = driver
				.findElement(By.xpath("//div[@id='profile-box-modal-cognito']//select[@class='form-control']"))
				.isDisplayed();
		System.out.println("Go button is Diplayed:" + val1);
		// if(val1==)
	}
}
