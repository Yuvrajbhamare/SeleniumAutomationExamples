package systemSetProperty1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutosuggestiveDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement searcjBox=driver.findElement(By.xpath("//textarea[@role='combobox']"));
		searcjBox.sendKeys("India");
		
		try {
			
		WebElement staySignedOut=mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button' and normalize-space()='Stay signed out']")));
		staySignedOut.click();
		searcjBox = driver.findElement(By.xpath("//textarea[@role='combobox']"));
		searcjBox.clear();
		searcjBox.sendKeys("India");
		}
		
		catch(Exception e)
		{
		}
		List<WebElement>allText=mywait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li ")));
		
		for(WebElement selectText:allText)
		{
			if(selectText.getText().equals("India national cricket team"))
			{
				new Actions(driver).moveToElement(selectText).click().perform();
				break;
			}
		}
	
	}

}
