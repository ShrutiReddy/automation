package com.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.*;

public class Utility {
	
	public static void captureScreenShots(WebDriver driver,String ScreenShotName){
		
		try{
		 TakesScreenshot ts = (TakesScreenshot)driver;
		 
		 File source =ts.getScreenshotAs(OutputType.FILE);
		 
		 FileUtils.copyFile(source, new File("./ScreenShots/"+ScreenShotName+".png"));
		 
		 System.out.println("ScreenShot taken");
		}catch(WebDriverException e){
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
