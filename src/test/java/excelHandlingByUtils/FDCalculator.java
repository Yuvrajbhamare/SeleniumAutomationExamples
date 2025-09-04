package excelHandlingByUtils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FDCalculator {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		String filepath=System.getProperty("user.dir")+"\\DataDriven\\CalData.xlsx";
		int rows=ExcelUtils.getRowCount(filepath, "Sheet1");
		
		for(int i=1;i<=rows;i++)
		{
			try {
		        driver.findElement(By.xpath("//button[text()='No thanks']")).click();
		    } catch (Exception e) 
			{		
			}
			// Clear old values
		    driver.findElement(By.xpath("//input[@id='principal']")).clear();
		    driver.findElement(By.xpath("//input[@id='interest']")).clear();
		    driver.findElement(By.xpath("//input[@id='tenure']")).clear();
			//reading data from excel
			String pric=ExcelUtils.getCellData(filepath, "Sheet1", i, 0);
			String rateofinterest=ExcelUtils.getCellData(filepath, "Sheet1", i, 1);
			String per1=ExcelUtils.getCellData(filepath, "Sheet1", i, 2);
			String per2=ExcelUtils.getCellData(filepath, "Sheet1", i, 3);
			String freq=ExcelUtils.getCellData(filepath, "Sheet1", i, 4);
			String exp_mvalue=ExcelUtils.getCellData(filepath, "Sheet1", i, 5);
			//pass above data into excel
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(pric);
			driver.findElement(	By.xpath("//input[@id='interest']")).sendKeys(rateofinterest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);
			Select perdrp=new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			perdrp.selectByVisibleText(per2);
			Select fredrp=new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			fredrp.selectByVisibleText(freq);
			//Clicked on calculate button
			driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();
			//validation of data
			// Wait and verify result
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='resp_matval']//strong")));
		    String act_mvalue = result.getText();

		    if(Double.parseDouble(exp_mvalue) == Double.parseDouble(act_mvalue)) {
		        System.out.println("Test Passed");
		        ExcelUtils.SetCellData(filepath,"Sheet1",i,7,"Passed");
		        ExcelUtils.FillGreenColour(filepath,"Sheet1",i, 7);  
		    } else {
		        System.out.println("Test Failed");   
		        ExcelUtils.SetCellData(filepath,"Sheet1",i,7,"Failed");
		        ExcelUtils.FillRedColour(filepath,"Sheet1",i,7);
		    }

		    Thread.sleep(2000);
		}
		}
		}