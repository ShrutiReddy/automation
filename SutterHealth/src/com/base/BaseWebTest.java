package com.base;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.util.Configuration;
import com.util.ExcelData;
import com.util.Utility;
//import com.util.ExcelUtils;

/**
 * Created by shruti 
 */
public abstract class BaseWebTest extends BaseTest {

    public WebDriver driver;
    public ExcelData excelData;

   // public Logger logger;

    @BeforeSuite
    public void beforeSuite() {
    	excelData  = new ExcelData();
        
        try{
        switch ( config.Browser) {
        case InternetExplorer:
            driver =new InternetExplorerDriver();
            break;
        case Firefox:
            driver = new FirefoxDriver();
            break;
        case Chrome:
            driver =new ChromeDriver();
            break;
        }
    }catch (Exception ex) {
        logger.error(ex);
    }
        
 
    	
    }

    @AfterSuite
    public void afterSuite() {
  driver.quit();
    }

}