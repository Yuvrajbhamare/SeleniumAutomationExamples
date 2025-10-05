package windowHandlings;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WindowHanding {
	WebDriver driver;

	@Test
	public void filesUpload() throws IOException, InterruptedException {

		// WebDriverManager.chromedriver().setup();
		// WebDriver driver = new ChromeDriver();

		// driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		FileOutputStream file = new FileOutputStream(
				System.getProperty("user.dir") + "\\DataDriven\\SetdataIntoSheet.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sheet1Oct25");
		XSSFRow row3 = sheet.createRow(3);
		row3.createCell(3).setCellValue("4000");
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("File is created");
	}

}
