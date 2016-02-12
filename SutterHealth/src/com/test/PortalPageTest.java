package com.test;

import static org.testng.AssertJUnit.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseWebTest;
import com.pages.LoginPage;
import com.pages.PortalPage;
import com.util.Utility;

public class PortalPageTest extends BaseWebTest{
	
	PortalPage pt;
	
	@BeforeClass
	public void start(){
		pt =  new PortalPage(driver);
	}
	
	@Test(priority=1)
	public void testTopPageLinks(){
		//pt.getLogInPage();
		List<WebElement> topPageLinks=pt.topUtilityLinks();
		List<String> exp = new ArrayList();
		List<String> act = new ArrayList();
		
		exp.add("Jobs");
		exp.add("News Blog");
		exp.add("Login to My Health Online");
		exp.add("Search");
		
		for(WebElement w:topPageLinks){
			act.add(w.getText());
			
		}
		//Utility.captureScreenShots(driver, "Afterenrollmentlist");
		assertEquals(exp, act);
		
		
		
	}
	@Test(priority=2)
	public void testHeaferList(){
		
		
		List<String> act = pt.topHeader();
		List<String> exp = new ArrayList();
		
		exp.add("Find a Doctor");
		exp.add("Locations");
		exp.add("Services");
		exp.add("For Patients");
		exp.add("Health Information");
		exp.add("Ways To Give");
		
		
		
		assertEquals(exp, act);
		//Assert.classassertTrue(act.size()=6);
	}
	@Test(priority=3)
	public void testFooterLinks(){
		List<WebElement> footLinks=pt.footerLinks();
		List<String> act= new ArrayList();
		List<String> exp= new ArrayList();
		
		exp.add("Vendor Resources");
		exp.add("Drug Guide");
		exp.add("Health Topics A-Z");
		exp.add("Patient Stories");
		exp.add("Web Site Listing for All Sutter Health Affiliates");
		exp.add("Calories burned");
		exp.add("What's your stress level?");
		exp.add("All tools & quizzes");
		exp.add("Tips for choosing a doctor");
		exp.add("Making the most of your doctor visit");
		exp.add("Tips for staying healthy");
		
		for(WebElement links: footLinks){
			act.add(links.getText());
		}
		assertEquals(exp, act);
		
	}

    @AfterMethod
    public void afterSuite(ITestResult result) {
    	if(ITestResult.FAILURE == result.getStatus()){
    		Utility.captureScreenShots(driver, result.getName());
    	}
    	

        
    }

}
