package excelHandleByPageObject;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClassLogin {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String filepath = System.getProperty("user.dir") + "//DataDriven//ScanOnline_LoginData_DataDrivenTest.xlsx";
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		int rows = PageObjectClass.getRowCount(filepath, "Sheet1");
		for (int i = 1; i <= rows; i++) {
			String username = PageObjectClass.getCellData(filepath, "Sheet1", i, 0);
			String password = PageObjectClass.getCellData(filepath, "Sheet1", i, 1);
			driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);

			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
			// driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
			driver.navigate().refresh();

		}

	}

}
