package com.binco.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
//import com.binco.utilities.parameter;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;






public class basepage {
	
	public WebDriver driver;
	private static String PAGE_URL="http://demo.thebinco.com";
	
	public void setaccount() throws IOException {
	  
	  
	    Properties obj = new Properties();					
	    FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");									
	    obj.load(objfile);		
	    driver.findElement(By.id(obj.getProperty("username"))).sendKeys(obj.getProperty("Uname"));
	    driver.findElement(By.id(obj.getProperty("password"))).sendKeys("123456");
	    driver.findElement(By.xpath(obj.getProperty("login"))).click();
	    
	}
	
	@Parameters({"Uname","pass"})
	public void setaccount1(String Uname,String pass) throws IOException {
		  
		  
	    Properties obj = new Properties();					
	    FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");									
	    obj.load(objfile);		
	    driver.findElement(By.id(obj.getProperty("username"))).sendKeys(Uname);
	    driver.findElement(By.id(obj.getProperty("password"))).sendKeys(pass);
	    driver.findElement(By.xpath(obj.getProperty("login"))).click();
	    
	}
	
	public void setaccount2(String Uname,String pass) throws IOException {
		  
		  
	    Properties obj = new Properties();					
	    FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");									
	    obj.load(objfile);		
	    driver.findElement(By.id(obj.getProperty("username"))).sendKeys(Uname);
	    driver.findElement(By.id(obj.getProperty("password"))).sendKeys(pass);
	    driver.findElement(By.xpath(obj.getProperty("login"))).click();
	    
	}


	
	public basepage(WebDriver driver){
	    this.driver=driver;
	    driver.get(PAGE_URL);
	    //Initialise Elements
	    PageFactory.initElements(driver, this);
	}
	

}
