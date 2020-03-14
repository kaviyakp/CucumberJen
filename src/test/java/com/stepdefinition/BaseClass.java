package com.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	WebDriver driver;

	public WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kavi\\eclipse-workspace\\Sample\\Drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    screenshot();
	    return driver;
	}
	public void loadUrl(String url) {
		driver.get(url);
		screenshot();
	}
	public void type(WebElement element , String name) {
		element.sendKeys(name);
		screenshot();
	}
	public void btnClick(WebElement element) {
		element.click();
		screenshot();
	}
	public void selectByIndex(WebElement element, int index) {
		new Select(element).selectByIndex(index);
		screenshot();
	}
	public void selectByAttribute(WebElement element, String name) {
		new Select(element).selectByValue(name);
		screenshot();
	}
	public void selectByText(WebElement element, String name) {
		new Select(element).selectByVisibleText(name);
		screenshot();
	}
	public void typejs(WebElement element, String name) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','"+name+"')",element );
		screenshot();
	}
	public String generateRandomdate() {
		return new SimpleDateFormat("EEE_MMM_dd_yyyy_hhmmss").format(new Date());

	}
	public String getTextByAttribute(WebElement element) {
		return element.getAttribute("value");

	}
	public String getTitle() {
		return driver.getTitle();

	}
	public void screenshot() {
		File s = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destLoc = new File("C:\\Users\\kavi\\eclipse-workspace\\CucumberPrgm\\ScreenShots"+generateRandomdate()+".png");
		try {
			FileUtils.copyFile(s,destLoc);
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}
	public void quitBrowse() {
		driver.quit();

	}

}
