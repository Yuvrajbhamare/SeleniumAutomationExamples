package practiceSet2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExcelClass {
	WebDriver driver;
 @BeforeClass
 @Parameters({"browser","URL"})
	public void OpenApp(String br,String URL) 
	{
	 switch(br.toLowerCase())
	 {
	 case "chrome":driver=new ChromeDriver();
	 break;
	 case "edge":driver=new EdgeDriver();
	 break;
	 
	 case "firexox":driver=new FirefoxDriver();
	 break;
	 default :System.out.println("Invalid Browser");
	 return;
	 }

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.manage().window().maximize();
driver.get(URL);

	}
 
 @Test(dataProvider="dp")
 void Login(String email,String password) throws InterruptedException
 {

	 driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//input[@id='usernamelogin']")).sendKeys(email);
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//span[@id='basic-addon2']")).click();
	 driver.findElement(By.xpath("//input[@id='passwordlogin']")).sendKeys(password);
	 //driver.findElement(By.xpath("//span[@id='signInBtn']")).click();
	 //driver.findElement(By.xpath("//div[@id='profile-box-modal-cognito']//button[@class='btn btn-cta text-white'][normalize-space()='Go']")).click();
	//boolean dashBoard= driver.findElement(By.xpath("//a[@class='dashboard-btn']")).isDisplayed();
	//System.out.println("Dashboard is displayed:"+dashBoard);
	//Thread.sleep(2000);
	//driver.findElement(By.xpath("//a[@class='close-fx']")).click();
	//Thread.sleep(2000);
	//driver.findElement(By.xpath("//li[@class='last logout']//a[contains(text(),'Logout')]")).click();
	driver.navigate().refresh();
 
 }
 @AfterClass
	void tearDown() {
		driver.quit(); // Better than close()
	}
 @DataProvider(name="dp",indices= {0,2})
 Object[][]logindata()
 {
	Object  Data[][]=
			{
		{"17junecognito@yopmail.com","Admin@2036"},
		{"delete18june25@yopmail.com","Admin@2032"},
		{"19junecognito@yopmail.com","Admin@2033"},
			};
	 return Data;
			
	
 }
 
 
 
}
	
	