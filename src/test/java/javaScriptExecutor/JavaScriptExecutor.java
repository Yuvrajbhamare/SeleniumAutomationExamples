package javaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		// Normally When ElementIntercepted Exception comes,use JE
		// WebElement checkb=driver.findElement(By.xpath("//input[@id='male']"));
		// Click action by JavascriptExecutor
		// JavascriptExecutor je=(JavascriptExecutor)driver;
		// je.executeScript("arguments[0].click();",checkb );
		// Sendkeys action by JavascriptExecutor
		// WebElement inputbox=driver.findElement(By.xpath("//input[@id='name']"));
		// WebElement checkbox=driver.findElement(By.xpath("//input[@id='male']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// Set value or send keys action by JSE

		// jse.executeScript("arguments[0].setAttribute('value','YUVRAJA V
		// BHAMARE')",inputbox );

		// Click Action by JSE

		// jse.executeScript("arguments[0].click()",checkbox);
		// jse.executeScript("window.scrollBy(0,3000)", "");
		// System.out.println(jse.executeScript("return window.pageOffset;"));
		// scroll page till the element is visible
		// WebElement input2=driver.findElement(By.xpath("//input[@name='input1']"));
		// jse.executeScript("arguments[0].scrollIntoView();",input2);

		// scroll Till the end of the page
		// jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		// Scroll till the top of the page
		jse.executeScript("window.scrollBy(0,-document.body.scrollHeight");

	}

}
