package com.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.BaseTest;
import com.base.BasePage;

public class HomePage extends PortalPage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}


	public List<WebElement> countOpenEnrollmentLinks(){
		
		
		//driver.get("http://www.sutterhealth.org");
		//List<WebElement> links = new ArrayList<WebElement>();
		WebElement l = driver.findElement(By.className("sidebar"));
		
		List<WebElement> linklist = l.findElements(By.className("links"));
		System.out.println(linklist.size()); 
		
		WebElement openEn = linklist.get(0);
		
		List<WebElement> lis = openEn.findElements(By.xpath("li") );
		System.out.println("links: " + lis.size());
		
		for(WebElement w : lis){
			System.out.println("Name: " + w.getTagName() + "-" +w.getText());
		}
		
		return lis;
	}
	
	public  void endpage(){
		WebElement s=driver.findElements(By.className("")).
		s.getAttribute("").equals(anObject);
		
	
		
	}



}
