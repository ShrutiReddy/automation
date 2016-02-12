package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.BaseTest;
import com.base.BasePage;

public class PortalPage extends BasePage {

	public PortalPage(WebDriver driver) {
		super(driver);
		logger = Logger.getLogger(PortalPage.class);

	}

/*	public void getLogInPage() {
		String url = BaseTest.config.BaseUrl;
		driver.get(url);

	}*/

	public String getTitle() {

		return driver.getTitle();
	}

	public void sutterLogoPresent() {
		driver.findElement(By.xpath("//img[@alt='Sutter Health']"));
	}

	public List<WebElement> topUtilityLinks() {
		WebElement tbar = driver.findElement(By.xpath("//div[@id='header']"));
		List<WebElement> topLinks = tbar.findElements(By
				.xpath("//ul[@id='navUtility']/li"));
		System.out.println(topLinks.size());

		for (WebElement links : topLinks) {
			System.out.println("TextName = " + links.getText());

		}
		return topLinks;
	}

	public List<String> topHeader() {
		// WebElement header =
		// driver.findElement(By.xpath("//ul[@id='navPrimary']"));

		List<WebElement> headerList = driver.findElements(By
				.xpath("//ul[@id='navPrimary']/li"));
		System.out.println(headerList.size());

		List<String> linkNames = new ArrayList<String>();
		for (WebElement head : headerList) {
			//System.out.println("HeaderList text name = " + head.getText());
			logger.info( "HeaderList text name = " + head.getText()  );
			linkNames.add( head.getText() );
		}
		return linkNames;

	}
 public List<WebElement> footerLinks(){
	 List<WebElement> footer = driver.findElements(By.xpath("//div[@id='tab1']/dl/ul/li"));
	 System.out.println(footer.size());
	 
	 for(WebElement foot:footer){
		 System.out.println("The title of all the footer links are: "+foot.getText());
		 
	 }
	 return footer;
 }
	public String isLogoPresent() {

		WebElement menu = driver.findElement(By
				.xpath("//strong[text()='Hide Menu']"));
		return menu.getText();

	}
	

	public WebElement container() {
		WebElement contain = driver.findElement(By.className("dr_container"));
		return contain;

	}

	public Boolean messageTable() {
		return driver.findElements(
				By.xpath("/html/body/table[2]/tbody/tr/td/table[1]")).size() <= 6;

	}

}
