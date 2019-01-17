package com.binco.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.binco.dataprovider.parameter;
import com.binco.pages.basepage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utility.CaptureScreenShot;

public class Logintest {
	ExtentReports reports;
	ExtentHtmlReporter htmlReporter;
	ExtentTest test;
	WebDriver driver;
	
	@BeforeTest
	public void startTest() {
		reports = new ExtentReports();

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//test-output//extentreport.html");
		reports.attachReporter(htmlReporter);

		reports.setSystemInfo("Machine", "Madhan");
		reports.setSystemInfo("Env", "Windows 8.1");
		reports.setSystemInfo("Build", "Integration");
		reports.setSystemInfo("Browser", "Chrome");
	}
	
	
	@BeforeMethod
	public void setup(){
	       //use FF Driver
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\madhan\\Downloads\\chromedriver_win321\\chromedriver.exe");
	       driver = new ChromeDriver();
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   }
	
	
	@Test(priority = 1)
	 public void logintest() throws InterruptedException, IOException {
		   
		   test = reports.createTest("verify the login test");
		   basepage base = new basepage(driver);
		   base.setaccount();
		   Thread.sleep(5000);

	}
	@Test(priority = 2)	
	@Parameters({"Uname","pass"})
	 public void logintest1(String Uname,String pass) throws InterruptedException, IOException {
		   
		  test = reports.createTest("verify the login test2");
		   basepage base = new basepage(driver);
		   base.setaccount1(Uname,pass);
		   Thread.sleep(5000);

	}
	@Test(dataProvider="loginProvider",dataProviderClass=parameter.class,priority = 3)
	 public void logintest2(String Uname,String pass) throws InterruptedException, IOException {
		   
		   test = reports.createTest("verify the login test 3");
		   basepage base = new basepage(driver);
		   base.setaccount2(Uname,pass);
		   Thread.sleep(5000);

	}
	
	
	@AfterMethod
	public void aftertest(ITestResult result)throws IOException{
		
		String screenShot = CaptureScreenShot.captureScreen(driver, CaptureScreenShot.generateFileName(result));

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
			test.log(Status.FAIL,result.getThrowable());
			test.fail("Screen Shot : " + test.addScreenCaptureFromPath(screenShot));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
			test.pass("Screen Shot : " + test.addScreenCaptureFromPath(screenShot));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.skip("Test Case : " + result.getName() + " has been skipped");
		}
 
		reports.flush();
		driver.close();
	}
	
	@AfterTest
	public void endTest() {
		
		reports.flush();
	}

}
