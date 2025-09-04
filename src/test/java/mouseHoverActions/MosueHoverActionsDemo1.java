package mouseHoverActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MosueHoverActionsDemo1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://vinothqaacademy.com/mouse-event/");

		// Mouse Hover
		// WebElement feedback1=driver.findElement(By.xpath("//div[@class='collapse
		// navbar-collapse pull-right']//*[contains(text(),'About Me & Feedback')]"));
		// WebElement feedback2=driver.findElement(By.xpath("//div[@class='collapse
		// navbar-collapse pull-right']//*[contains(text(),'Placed Students
		// Feedback')]"));
		// Actions Act = new Actions(driver);
		// Act.moveToElement(feedback1).moveToElement(feedback2).build().perform();
		// Actions Act=new Actions(driver);
		// Act.moveToElement(feedback1).moveToElement(feedback2).click(feedback2).build().perform();

		// Right Click
		/*
		 * JavascriptExecutor jse= (JavascriptExecutor)driver; WebElement
		 * rightClick=driver.findElement(By.xpath("//button[@id='rightclick']"));
		 * jse.executeScript("arguments[0].click();",rightClick);
		 * //jse.executeScript("arguments[0].scrollIntoView(true);",rightClick); Actions
		 * Act = new Actions(driver);
		 * 
		 * Act.contextClick(rightClick).build().perform();
		 */

		// Double Click
		// Actions Act= new Actions(driver);
		// WebElement
		// doubleClick=driver.findElement(By.xpath("//button[@id='dblclick']"));
		// Act.doubleClick(doubleClick).build().perform();

		// Drag and Drop

		// WebElement
		// dragable=driver.findElement(By.xpath("//div[@id='draggableElement']"));
		// WebElement
		// dropable=driver.findElement(By.xpath("//div[@id='droppableElement']"));

		// Actions Act = new Actions(driver);
		// Act.dragAndDrop(dragable, dropable).build().perform();
		WebElement button = driver.findElement(By.xpath("//input[@id='textbox']"));
		Actions Act = new Actions(driver);
		Action myAction = Act.click(button).build();
		myAction.perform();

	}

}
