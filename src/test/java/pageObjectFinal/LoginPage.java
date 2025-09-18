package pageObjectFinal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// locators
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username_loc;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password_loc;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement login_Btn_loc;

	// action methods

	public void username_method(String username) {
		username_loc.sendKeys(username);
	}

	public void password_method(String password) {
		password_loc.sendKeys(password);
	}

	public void Login_method() {
		login_Btn_loc.click();
	}

}
