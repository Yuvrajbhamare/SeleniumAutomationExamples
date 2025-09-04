package keyBoardActions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoard_MouseActionTogether {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		// Entering Test to Box 1
		// if want to open new link on another tab on same window,and dont want to loose
		// home page
		// here we uses keyboard action+mouse action to click the link
		WebElement reglink = driver.findElement(By.linkText("Register"));
		Actions Act = new Actions(driver);
		Act.keyDown(Keys.CONTROL).click(reglink).keyUp(Keys.CONTROL).perform();
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<String> windowids = new ArrayList(driver.getWindowHandles());// using direct List collection here instead
																			// of Set and getting windowhandled
		driver.switchTo().window(windowids.get(1));// switching to child window
		driver.switchTo().window(windowids.get(0));// switching to Home page

	}

}
