package TestClass;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClass.Base1;
import POMClass.HomePage;
import POMClass.LoginPage;

public class VerifyUserCanSearchTheProduct {
	static WebDriver driver;
	HomePage hp;
	ExtentHtmlReporter htmlreporter;
	ExtentReports reports;
	ExtentTest extenttest;
	
	@BeforeClass
	public void beforeClass() {
		htmlreporter=Base1.getExtentHtmlReports("reports.html");
		reports=Base1.getExtentReports();
		extenttest=Base1.getExtentTest("VerifyUserCanLogin");
		driver=Base1.getDriver();
	}
	@BeforeMethod
	public void beforeMethod() {
		hp=new HomePage(driver);
	}
	@Test(priority=1)
	public void searchProducts() {
		hp.searchProduct();
		Assert.assertTrue(hp.visiblePrice());
	}
	@Test(priority=2)
	public void getProductPriceOfEachPage() {
		List<String> lowprice=new ArrayList<>();
		for(int i=1;i<=10;i++) {
			if(i!=1) {
				hp.shiftToPage(i);
			}
			hp=new HomePage(driver);
			lowprice.add(hp.getPriceOfEachProduct());
		}
		System.out.println(lowprice);
	}
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			extenttest.log(Status.PASS, "test name: "+result.getName());
		}else
			if(result.getStatus()==ITestResult.FAILURE) {
				extenttest.log(Status.FAIL, "test name: "+result.getName());
			}else
				if(result.getStatus()==ITestResult.SKIP) {
					extenttest.log(Status.SKIP, "test name: "+result.getName());
				}
	}
	@AfterClass
	public void afterClass() {
		reports.flush();
	}
}
