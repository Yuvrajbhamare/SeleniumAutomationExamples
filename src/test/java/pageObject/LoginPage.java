package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	WebDriver driver;
	//Constructor
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	//Locators
	By Btn_Login=By.xpath("//button[normalize-space()='Loginq']");
	By txt_Email=By.xpath("//input[@id='usernameloginq']");
	By go_button=By.xpath("//span[@id='basic-addon2q']");
	By txt_password=By.xpath("//input[@id='passwordloginq']");
	By btn_SignIn=By.xpath("//span[@id='signInBtn']q");

	
	//Action Methods
	public void ClickLogin()
	{
		driver.findElement(Btn_Login).click();
	}
	
	public void setEmail(String Email)
	{
		driver.findElement(txt_Email).sendKeys(Email);
	}
	
	public void ClickOnGoButton()
	{
		driver.findElement(go_button).click();
	}
	public void setPwd(String pwd)
	{
		driver.findElement(txt_password).sendKeys(pwd);
	}
	public void ClickOnSignIn()
	{
		driver.findElement(btn_SignIn).click();
	}
}
