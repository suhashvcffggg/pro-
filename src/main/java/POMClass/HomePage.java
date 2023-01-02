package POMClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	static WebDriver driver;
	@FindBy(xpath="//input[@class='_3704LK']") private WebElement searchbox;
	@FindBy(xpath="//div[@class='_4rR01T']") private WebElement products;
	@FindBy(xpath="//div[@class='_30jeq3 _1_WHN1']") private List<WebElement> price;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public boolean getVisibility() {
		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(searchbox));
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	public void searchProduct() {
		searchbox.sendKeys("realme");
		searchbox.sendKeys(Keys.ENTER);
	}
	public boolean visiblePrice() {
		try {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(products));
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	public String getPriceOfEachProduct() {
		List<String> pricelist=new ArrayList<>();
		for(WebElement k:price) {
			pricelist.add(k.getText().replace("₹", "").replace(",", ""));
		}
		Collections.sort(pricelist);
		return pricelist.get(0);
		
	}
	public void shiftToPage(int a) {
		driver.findElement(By.xpath("//a[@class='ge-49M' and text()='"+a+"']")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='ge-49M _2Kfbh8' and text()='"+a+"']"))));
		}
}
