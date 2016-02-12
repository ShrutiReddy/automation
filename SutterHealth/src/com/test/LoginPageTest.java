package com.test;

import static org.testng.AssertJUnit.assertEquals;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseWebTest;
import com.pages.LoginPage;

public class LoginPageTest extends BaseWebTest {
	LoginPage lp ;
	
	@BeforeClass
	public void start(){
		lp= new LoginPage(driver);
		
	}
	
	 @DataProvider(name = "users-data")
	    public Object[][] getUsers() throws Exception {
	        Object[][] data = excelData.readExcel();
	        return data;
	    }

	@Test(priority = 1,dataProvider = "users-data")
	public void testLogin(String uname, String passwd) throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String actual =lp.login(uname, passwd);
		String expected = "<Login unsuccessful.Problems Logging In?>";
                             
                                           
		assertEquals(expected, actual);
		
		
	}


	
/*	@Test(priority=2)
	public void testLogout(){
		String actual=lp.logout();
		
		

}*/
}
	


