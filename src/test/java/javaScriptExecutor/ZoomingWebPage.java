package javaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomingWebPage {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
	
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		//Zooming page at 50 %
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Thread.sleep(2000);
		js.executeScript("document.body.style.zoom='50%'");

	}

}
