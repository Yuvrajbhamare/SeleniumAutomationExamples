package keyBoardActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActions {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://text-compare.com/");
		//Entering Test to Box 1
		driver.findElement(By.xpath("//textarea[@name='text1']")).sendKeys("WELCOME TO SELENIUM");
		Actions Act = new Actions(driver);
		
		
		//CONTRAOL A
		Act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		
		//CONTROL C
		Act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		//TAB KEY
		Act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		//CONTROL V
		Act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		
		
		
		
		
	
		

	}

}
