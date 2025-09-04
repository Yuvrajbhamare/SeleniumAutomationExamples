package systemSetProperty1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage3 
{
//constructor
	WebDriver driver;
	
	public LoginPage3(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
//Locators
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement loginbtn;
	
	
	@FindBy(xpath="//input[@id='usernamelogin']")
	WebElement username;
	
	@FindBy(xpath="//span[@id='basic-addon2']")
	WebElement GoBtn;
	
	@FindBy(xpath="//input[@id='passwordlogin']")
	WebElement pw;
	
	//ActionMethods

	public void loginbtnM()
	{
		loginbtn.click();
	}
	
	public void loginbtusernametextM(String email)
	{
		username.sendKeys(email);
	}
	
	public void GobtnM()
	{
		GoBtn.click();
	}
	
	public void passwodM(String password)
	{
		pw.sendKeys(password);
	}
	
}
