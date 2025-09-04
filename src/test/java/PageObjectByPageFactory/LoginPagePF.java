package PageObjectByPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePF 
{
WebDriver driver;
	//constructor
	LoginPagePF(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Locators
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement Btn_Login;
	
	//@FindBy(xpath="//input[@id='usernamelogin']")
	                //OR,Rarely used approach
	@FindBy(how=How.XPATH,using="//input[@id='usernamelogin']")
	WebElement txt_Email;
	
	@FindBy(xpath="//span[@id='basic-addon2']")
	WebElement go_button;
	
	@FindBy(xpath="//input[@id='passwordlogin']")
	WebElement txt_password;
	
	
	@FindBy(xpath="//span[@id='signInBtn']")
	WebElement btn_SignIn;
	
	//Methods
	
	public void ClickLogin()
	{
		Btn_Login.click();
	}
	
	public void SetEmail(String email)
	{
		txt_Email.sendKeys(email);
	}
	
	public void ClickGoButton()
	{
		go_button.click();
	}
	public void setPassword(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	
	public void clickOnSignIn()
	{
		btn_SignIn.click();
	}
	
	
	
	
	
	
}
