package SVGElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGElements {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		driver.manage().window().maximize();
		// HANDLING SVG ELEMENTS:SVG MEANS ICONS;SVG CAN BE HANDLE BY SELECTORS HUB ONLY
		// USING text() method also possible
		driver.findElement(By.xpath("//span[normalize-space()='Admin']")).click();

	}

}
