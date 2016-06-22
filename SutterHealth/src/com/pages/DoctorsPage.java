package com.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.base.BasePage;

public class DoctorsPage extends BasePage {

	public DoctorsPage(WebDriver driver) {
		super(driver);
		
	}

	public String dropDownList() {
		try {
			driver.findElement(By.linkText("Find a Doctor")).click();

		} catch (Exception e) {
			logger.error("Element not found");

		}
		new Select(driver.findElement(By.cssSelector("select[id='primSpec']")))
				.selectByValue("1109");
		WebElement zip = driver.findElement(By.xpath("//input[@id='zip']"));
		zip.sendKeys("94568");
		WebElement submit = driver.findElement(By
				.cssSelector("input[id='ps_submit']"));
		submit.click();
		WebElement text = driver.findElement(By
				.xpath("//h1[text()='Sutter Health Doctors']"));
		String title = text.getText();
		return title;

	}

	public int acceptingPatientsList() {
		driver.findElement(By.linkText("Find a Doctor")).click();
		new Select(driver.findElement(By.cssSelector("select[id='primSpec']")))
				.selectByValue("1109");
		WebElement zip = driver.findElement(By.xpath("//input[@id='zip']"));
		zip.sendKeys("94568");
		WebElement id = driver.findElement(By
				.xpath("//input[@id='practiceStatus']"));
		id.click();
		WebElement submit = driver.findElement(By
				.cssSelector("input[id='ps_submit']"));
		submit.click();
		WebElement nextPage = driver.findElement(By.xpath("//a[text()='25']"));
		nextPage.click();
		// WebElement number=
		return driver.findElements(By.xpath("//span[text()='Accepting']"))
				.size();

	}

	public String childWindowTitle() {
		driver.findElement(By.linkText("Find a Doctor")).click();
		new Select(driver.findElement(By.cssSelector("select[id='primSpec']")))
				.selectByValue("1109");
		WebElement zip = driver.findElement(By.xpath("//input[@id='zip']"));
		zip.sendKeys("94568");
		WebElement submit = driver.findElement(By
				.cssSelector("input[id='ps_submit']"));
		submit.click();
		WebElement link = driver.findElement(By
				.linkText("George S. Besser, D.O."));
		link.click();
		WebElement healthPlan = driver.findElement(By
				.xpath("//img[@class='ps_healthplan_button']"));
		healthPlan.click();

		Set<String> pages = driver.getWindowHandles();

		Iterator<String> it = pages.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		
		driver.switchTo().window(childWindow);
		
		return driver.getTitle();

	}
}
