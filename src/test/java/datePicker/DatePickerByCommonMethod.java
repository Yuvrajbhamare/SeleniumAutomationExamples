package datePicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerByCommonMethod {

	
	public static void selectmonthyeardata(WebDriver driver,String Month,String Year,String Date)
	{

		while (true) {
			String currentmonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentyear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (currentyear.equals(Year) && currentmonth.equals(Month)) {
				break;
			}
			driver.findElement(By.xpath("//*[contains(text(),'Next')]")).click();
		}
		

		List<WebElement> alldates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td"));
		for (WebElement dt : alldates) {
			if (dt.getText().equals(Date)) {
				dt.click();
				break;
			}
		}
	}
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame(0);
		
		//String Year = "2025";
		//String Month = "July";
		//String Date = "23";
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		

		selectmonthyeardata(driver,"August","2026","25");
		                  //OR
		//selectmonthyeardata(driver ,Month,Year,Date);

	}

}
