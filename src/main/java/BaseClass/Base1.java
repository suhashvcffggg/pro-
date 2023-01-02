package BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base1 {
	static WebDriver driver;
	static ExtentHtmlReporter htmlreporter;
	static ExtentReports reports;
	static ExtentTest extenttest;
	
	public static WebDriver getDriver() {
		if(driver==null) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("https://www.flipkart.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		return driver;
	}
	public static ExtentHtmlReporter getExtentHtmlReports(String reportname) {
		if(htmlreporter==null) {
			htmlreporter=new ExtentHtmlReporter(reportname);
		}
		return htmlreporter;
	}
	public static ExtentReports getExtentReports() {
		if(reports==null) {
			reports=new ExtentReports();
			reports.attachReporter(htmlreporter);
		}
		return reports;
	}
	public static ExtentTest getExtentTest(String testname) {
		if(extenttest==null) {
		extenttest=reports.createTest(testname);
		}
		return extenttest;
	}

}
