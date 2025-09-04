package systemSetProperty1;

import java.io.File;
import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropDownCalender {

	static Month ConvertMonth(String month) {
		HashMap<String, Month> monthmap = new HashMap<String, Month>();
		monthmap.put("Jan", Month.JANUARY);
		monthmap.put("Feb", Month.FEBRUARY);
		monthmap.put("Mar", Month.MARCH);
		monthmap.put("Apr", Month.APRIL);
		monthmap.put("May", Month.MAY);
		monthmap.put("Jun", Month.JUNE);
		monthmap.put("Jul", Month.JULY);
		monthmap.put("Aug", Month.AUGUST);
		monthmap.put("Sep", Month.SEPTEMBER);
		monthmap.put("Oct", Month.OCTOBER);
		monthmap.put("Nov", Month.NOVEMBER);

		Month vmonth = monthmap.get(month);

		if (vmonth == null) {
			System.out.println("Invalid month");
		}
		return vmonth;
	}

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		File file = new File(
				"C:\\Users\\Lenovo\\Downloads\\AutomationFilesCRX2\\CRX-Extractor-Downloader-Chrome-Web-Store.crx");
		options.addExtensions(file);
		ChromeDriver driver = new ChromeDriver(options);
		// WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.globalsqa.com/demo-site/datepicker/#DropDown%20DatePicker");

		String requiredMonth = "Mar";
		String requiredYear = "2028";
		String requireddate = "8";

		driver.findElement(By.xpath("//li[@id='DropDown DatePicker']")).click();
		WebElement iframe1 = driver.findElement(By.xpath(
				"//iframe[@class='demo-frame' and @src='../../demoSite/practice/datepicker/dropdown-month-year.html']"));
		driver.switchTo().frame(iframe1);

		driver.findElement(By.id("datepicker")).click();
		// selecting year
		WebElement selectYear = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select myselect2 = new Select(selectYear);
		myselect2.selectByVisibleText(requiredYear);

		// selecting month
		while (true) {
			String DisplayMonth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")).getText();

			Month expectedmonth = ConvertMonth(requiredMonth);
			Month currentmonth = ConvertMonth(DisplayMonth);

			// compare
			int result = expectedmonth.compareTo(currentmonth);

			if (result < 0)// past
			{
				driver.findElement(By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']")).click();
			} else if (result > 0)// future
			{
				driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")).click();
			} else {
				break;
			}

			// selecting date
			List<WebElement> Alldates = driver
					.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td//a"));

			for (int i = 0; i < Alldates.size(); i++) {
				if (Alldates.get(i).getText().equals(requireddate)) {
					Alldates.get(i).click();
				}
			}
		}

	}
}
