package datePicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);

		// Storing expected dates in string variable
		String year = "2025";
		String Month = "July";
		String Date = "23";
		driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).click();
		while (true) {
			String Currentmonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String Currentyear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (Currentmonth.equals(Month) && Currentyear.equals(year)) {
				break;
			}
			driver.findElement(By.xpath("//*[contains(text(),'Next')]")).click();
		}
		List<WebElement> alldates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
				

		for (WebElement dt : alldates) {
			if (dt.getText().equals(Date)) {
				dt.click();
				break;
			}
		}
	}
}
