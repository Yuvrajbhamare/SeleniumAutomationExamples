package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class validationPage {
	WebDriver driver;

	// constructor
	validationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username_loc;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password_loc;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement login_loc;

	// action methods
	public void username(String username) {
		username_loc.sendKeys(username);
	}

	public void password(String password) {
		password_loc.sendKeys(password);
	}

	public void login() {
		login_loc.click();
	}

}
