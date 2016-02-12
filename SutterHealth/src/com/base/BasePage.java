package com.base;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.util.Configuration;

/**
 * Created by svelupula on 8/14/2015.
 */
public abstract class BasePage {

    public Logger logger;
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        logger = Logger.getLogger(BasePage.class);
        this.driver = driver;
        
        getLogInPage();
    }
    
	public void getLogInPage(){
		String url = BaseTest.config.BaseUrl;
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
}
