package com.test;

import static org.testng.AssertJUnit.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.base.BaseWebTest;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.util.Utility;

public class HomePageTest extends BaseWebTest {
	
	HomePage hp;
	
	
	@BeforeClass
	public void start(){
		logger = Logger.getLogger(HomePageTest.class);
		 hp = new HomePage(driver);
	}
	
	
	@Test
	public void checkOpenEnrollmentLinks(){
	
		List<WebElement> openEnrolList = hp.countOpenEnrollmentLinks();
		List<String> exp = new ArrayList();
		List<String> act = new ArrayList();
		
		Utility.captureScreenShots(driver, "enrollmentlist");
		//logger.debug("error");
		
		
		exp.add("Health Plans Accepted");
		exp.add("How to Get Started");
		exp.add("Sutter Health Plus");
	 
		for(WebElement w:openEnrolList){
			act.add(w.getText());
			
		}
		Utility.captureScreenShots(driver, "Afterenrollmentlist");
		assertEquals(exp, act);
		
		
	}

}
