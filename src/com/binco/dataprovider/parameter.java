package com.binco.dataprovider;

import org.testng.annotations.DataProvider;

public class parameter {
	@DataProvider(name="loginProvider")
    public static Object[][] getDataFromDataprovider(){
        return new Object[][] {
            { "madhan@thebinco.com", "123456" }
            //{ "santhana@thebinco.com", "12345" },
            //{ "santhana", "123456" }
        };  
}}