package practiceSet3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//This is without pageFactory
public class LoginPage extends BasePage {
//Constructor

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	// Locators

	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement BtnLogin;
	@FindBy(xpath = "//input[@id='usernamelogin']")
	WebElement Email2;
	@FindBy(xpath = "//span[@id='basic-addon2']")
	WebElement Gobtn;
	@FindBy(xpath = "//input[@id='passwordlogin']")
	WebElement pwd;
	@FindBy(xpath = "//span[@id='signInBtn']")
	WebElement LgnBtn2;

	// ActionMethods

	public void clickLogin() {
		BtnLogin.click();
	}

	public void EnterEmail(String Email) {
		Email2.sendKeys(Email);
	}

	public void ClickOnGo() {
		Gobtn.click();
	}

	public void EnterPassword(String pw) {
		pwd.sendKeys(pw);
	}

	public void LoginBtn22() {
		LgnBtn2.click();
	}
}
