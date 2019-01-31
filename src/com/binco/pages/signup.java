package com.binco.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class signup {
	
	public WebDriver driver;
	private static String PAGE_URL="http://demo.thebinco.com";
	
	public void signupaccount() throws IOException, InterruptedException {
		  
		  
	    Properties obj = new Properties();					
	    FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");									
	    obj.load(objfile);		
	    driver.findElement(By.linkText(obj.getProperty("signupbutton"))).click();
	    driver.findElement(By.id(obj.getProperty("firstname"))).sendKeys(obj.getProperty("fname"));
	    driver.findElement(By.id(obj.getProperty("lastname"))).sendKeys(obj.getProperty("lname"));
	    driver.findElement(By.id(obj.getProperty("emailid"))).sendKeys(obj.getProperty("email"));
	    Thread.sleep(3000);
	    driver.findElement(By.xpath(obj.getProperty("country"))).click();
	    driver.findElement(By.xpath("//*[contains(@class,'option ui-select-choices-row-inner')]")).click();
	    Thread.sleep(3000);
	    WebElement dropdown = driver.findElement(By.xpath(obj.getProperty("state")));
	    dropdown.click();
	    List<WebElement> options = driver.findElements(By.xpath("//*[contains(@class,'option ui-select-choices-row-inner')]"));
	    options.stream().filter(element->element.getText().matches("Cokato"))
	     				.forEach(element->element.click());
	    System.out.print(options);
	    
	    //driver.findElement(By.xpath(obj.getProperty("state"))).click();
	    //driver.findElement(By.xpath("//*[contains(@class,'option ui-select-choices-row-inner')]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.id(obj.getProperty("companyname"))).sendKeys(obj.getProperty("company"));
	    driver.findElement(By.xpath(obj.getProperty("continue"))).click();
	}
	
	
	public signup(WebDriver driver){
	    this.driver=driver;
	    driver.get(PAGE_URL);
	    //Initialise Elements
	    PageFactory.initElements(driver, this);
	}
	


}
