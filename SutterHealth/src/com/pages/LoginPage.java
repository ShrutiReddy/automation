package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.BaseTest;
import com.base.BasePage;
import com.util.Configuration;

public class LoginPage extends PortalPage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	public String login(String username, String passwd) throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement loginlink=driver.findElement(By.xpath("//a[@title='Login to My Health Online']"));
		loginlink.click();
		Thread.sleep(3000);
		WebElement id = driver.findElement(By.xpath("//input[@id='Login']"));
		id.sendKeys(username);
		WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
		password.sendKeys(passwd);
		WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
		submit.click();
		WebElement error = driver.findElement(By.xpath("//div[@id='loginErrorMessage']"));
		String title = error.getText();
		return title;
		
		
	}
	
	public String logout(){
		driver.get("http://demo.open-emr.org:2101/openemr/interface/main/main_screen.php?auth=login&site=default");
		WebElement logout = driver.findElement(By.id("logout_link"));
		logout.click();
		String title = driver.getTitle();
		return title;
		
		
	}

}
