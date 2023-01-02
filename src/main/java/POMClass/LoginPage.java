package POMClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	static WebDriver driver;
	
	@FindBy(xpath="(//input[@type='text'])[2]") private WebElement mobileno;
	@FindBy(xpath="//button[text()='Request OTP']") private WebElement reqotp;
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']") private WebElement cut;
	//@FindBy(xpath="//button[text()='Verify']") private WebElement verify;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
//	public void entermobile() {
//		mobileno.sendKeys("9637529769");
//	}
//	public void clickrequestotp() {
//		reqotp.click();
//	}
//	public void clickOnVerify() {
//		verify.click();
//	}
	public void cutHiddenDivision() {
		cut.click();
	}
	
}
