package mouseHoverActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingSliders {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.globalsqa.com/demo-site/sliders/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		Actions Act=new Actions(driver);
		//REMEMBER: THESE BELOW CODES WILL NOT HANDLED BECAUSE,PROPER URL NOT FOUND,AND AS PAR PAWAN SIR BELOW SLIDERS WILL BE HANDLED BY JAVASCRIPTEXECUTOR
		//BELOW CODE IS FOR NORMAL SLIDERS ONLY
		//Minimum slider
		WebElement min_slider=driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default ui-state-hover ui-state-active']"));
		System.out.println("Location of min_slider:"+min_slider.getLocation());
	    Thread.sleep(3000);
	    Act.dragAndDropBy(min_slider,8, 4).perform();
	    System.out.println("Location of min_slider:"+min_slider.getLocation());
		//maximum slider
	     WebElement max_slider=driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default ui-state-hover ui-state-active']"));
		System.out.println("Location of min_slider:"+min_slider.getLocation());
	    Thread.sleep(3000);
	    Act.dragAndDropBy(max_slider,-8, 4).perform();
	    System.out.println("Location of min_slider:"+max_slider.getLocation());

	}

}
