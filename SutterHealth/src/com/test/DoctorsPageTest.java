package com.test;

import static org.testng.AssertJUnit.assertEquals;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseWebTest;
import com.pages.DoctorsPage;
import com.pages.HomePage;
import com.util.Utility;

public class DoctorsPageTest extends BaseWebTest{
	DoctorsPage dp;
	
	@BeforeClass
	public void start(){
		logger = Logger.getLogger(DoctorsPageTest.class);
		dp= new DoctorsPage(driver);
		
	}
	@Test(priority=1)
	public void testDropDown(){
		String act=dp.dropDownList();
		String exp ="Sutter Health Doctors";
		assertEquals(exp, act);
	}
	@Test(priority=2)
	public void acceptingResults(){
		int act =dp.acceptingPatientsList();
		int exp=14;
		assertEquals(exp, act);
		logger.info("Priority2 Test");
		
	}
	@Test(priority=3)
	public void testChildWindowTitke(){
		String act= dp.childWindowTitle();
		String exp ="Health plans accepted by George Besser";
		assertEquals(exp, act);
		logger.info("Priority3 Test");
	}
	//Using ITestResult to capture screen shot for failed testcases
	@AfterMethod
	public void end(ITestResult result){
         if(ITestResult.FAILURE==result.getStatus()){
        	 Utility.captureScreenShots(driver, result.getName());
         }
	}

}
