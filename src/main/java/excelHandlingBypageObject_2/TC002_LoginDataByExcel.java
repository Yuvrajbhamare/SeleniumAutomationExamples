package excelHandlingBypageObject_2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC002_LoginDataByExcel {

	WebDriver driver;

	@Test
	public void LoginData() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String filepath = System.getProperty("user.dir") + "//DataDriven//DataDrivenTest.xlsx";
		int rows = ExcelUtils2.getRowCount(filepath, "Sheet26july");

		for (int r = 0; r <= rows; r++) {

			driver.findElement(By.xpath("//input[@placeholder='Username']")).clear();
			driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();

			String username = ExcelUtils2.getCelldata(filepath, "Sheet26july", r, 0);
			String password = ExcelUtils2.getCelldata(filepath, "Sheet26july", r, 1);

			driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);

			driver.navigate().refresh();

		}

	}

}
