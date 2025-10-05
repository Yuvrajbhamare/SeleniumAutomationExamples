package pageObject4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
//constructor
	WebDriver driver;

	Loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement usernameL;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement PasswordL;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement Login_btnL;

	public void usernameM(String username) {
		usernameL.sendKeys(username);
	}

	public void PasswordM(String password) {
		PasswordL.sendKeys(password);
	}

	public void Login_BtnM() {
		Login_btnL.click();
	}

}
