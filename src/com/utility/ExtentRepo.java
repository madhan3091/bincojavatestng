package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentRepo {
	public ExtentReports reports;
	public ExtentHtmlReporter htmlReporter;
    public ExtentTest test;
    public WebDriver driver;
	
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
	
	public ExtentRepo(WebDriver driver){
	    this.driver=driver;
	    //driver.get(PAGE_URL);
	    //Initialise Elements
	    PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	public ExtentRepo() {
		super();
	}

	@AfterTest
	public void endTest() {
		
		reports.flush();
	}
	

}
