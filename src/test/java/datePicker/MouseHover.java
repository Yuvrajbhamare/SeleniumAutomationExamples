package datePicker;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MouseHover {
	WebDriver driver;

	@Test
	public void MoveToElements() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// WebElement
		// inputBox=driver.findElement(By.xpath("//input[@placeholder='Username']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("arguments[0].setAttribute('value','YuvrajBBB')",
		// inputBox);
		// jse.executeScript("window.scrollBy(0,3000)","");
		// jse.executeScript("window.scrollBy(0,3000)", "");
		System.out.println(jse.executeScript("return window.pageOffset;"));

	}

}