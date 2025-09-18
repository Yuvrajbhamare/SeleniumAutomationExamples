package pageObjectExcelDataDriver;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_001_ExcelDataInTC

{
	WebDriver driver;

	@Test
	public static void DataDriven() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String filepath = System.getProperty("user.dir") + "//DataDriven//DataDrivenTest.xlsx";
		int rows = ExcelUtils.getRowCount(filepath, "Sheet26july");
		for (int r = 0; r <= rows; r++) {
			driver.findElement(By.xpath("//input[@placeholder='Username']")).clear();
			driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();

			String username = ExcelUtils.getcellData(filepath, "Sheet26july", r, 0);
			String password = ExcelUtils.getcellData(filepath, "Sheet26july", r, 1);

			// passing data

			driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);

			driver.navigate().refresh();
			// button[normalize-space()='Login']
		}

	}
}
