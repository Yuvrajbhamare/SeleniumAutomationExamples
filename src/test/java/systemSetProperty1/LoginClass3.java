package systemSetProperty1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginClass3 

{
WebDriver driver;
@BeforeClass
public void Openaap()
{
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://uat.www.sscconsolidation.com/home");
}

@Test
public void login()
{
	LoginPage3 lp=new LoginPage3(driver);
	lp.loginbtnM();
	lp.loginbtusernametextM("yuvrajbhamare11@gmail.com");
	lp.GobtnM();
	lp.passwodM("Admin@2029");
	
}
}
