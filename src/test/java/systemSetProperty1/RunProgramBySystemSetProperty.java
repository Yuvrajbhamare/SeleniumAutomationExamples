package systemSetProperty1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunProgramBySystemSetProperty {
	public static void calenderCommonMethod(WebDriver driver, String month, String year, String date) {

		while (true) {
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String curretYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (currentMonth.equals(month) && curretYear.equals(year)) {
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		List<WebElement> alldates = driver.findElements(By.xpath("//td[@data-handler='selectDay']/a"));
		for (WebElement dt : alldates) {
			if (dt.getText().equals(date)) {
				dt.click();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/demo-site/datepicker/");
		WebElement ifrme1 = driver.findElement(
				By.xpath("//iframe[@class='demo-frame' and @src='../../demoSite/practice/datepicker/default.html']"));
		WebDriverManager.chromedriver().setup();
		driver.switchTo().frame(ifrme1);

		String date = "21";
		String month = "December";
		String year = "2025";
		driver.findElement(By.cssSelector("#datepicker")).click();
		calenderCommonMethod(driver, month, year, date);

	}

}
