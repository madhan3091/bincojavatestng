package com.binco.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utility.*;
import com.binco.pages.signup;

public class Signtest extends ExtentRepo {
	
	private WebDriver driver;

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
	 public void signtest() throws InterruptedException, IOException {
		   
		   test = reports.createTest("verify the signin test");
		   signup sign = new signup(driver);
		   sign.signupaccount();
		   Thread.sleep(5000);

	}
	@Test(priority = 2)
	 public void signtest1() throws InterruptedException, IOException {
		   
		   test = reports.createTest("verify the signin negative test");
		   signup sign = new signup(driver);
		   sign.signupaccount1();
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
	

	
	
	
}
