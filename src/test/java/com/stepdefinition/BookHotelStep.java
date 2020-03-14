package com.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookHotelStep {
	WebDriver driver;
	@Given("User is on Adactin page")
	public void user_is_on_Adactin_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kavi\\eclipse-workspace\\Sample\\Drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://adactin.com/HotelApp/");
	    driver.manage().window().maximize();
	}

	@When("User enters {string} and {string}")
	public void user_enters_and(String user, String pass) {
		WebElement txtUser = driver.findElement(By.id("username"));
	    txtUser.sendKeys(user);
	    WebElement txtPwd = driver.findElement(By.id("password"));
	    txtPwd.sendKeys(pass);
	    
	}

	@When("User should click on Login button")
	public void user_should_click_on_Login_button() {
		WebElement btnLogin = driver.findElement(By.id("login"));
	    btnLogin.click();
	}

	@When("User Selects {string},{string},{string},{string},{string},{string},{string}")
	public void user_Selects(String ss1, String ss2, String ss3, String ss4, String ss5, String ss6, String ss7) {
		Select drplocation = new Select(driver.findElement(By.id("location")));
		drplocation.selectByVisibleText(ss1);
		Select drpHotel = new Select(driver.findElement(By.id("hotels")));
		drpHotel.selectByVisibleText(ss2);
		Select drpType = new Select(driver.findElement(By.id("room_type")));
		drpType.selectByVisibleText(ss3);
		Select drpNumOfRooms = new Select(driver.findElement(By.id("room_nos")));
		drpNumOfRooms.selectByVisibleText(ss4);
		WebElement txtInDate = driver.findElement(By.id("datepick_in"));
		txtInDate.sendKeys(ss5);
	    WebElement txtOutDate = driver.findElement(By.id("datepick_out"));
	    txtOutDate.sendKeys(ss6);
		Select drpAdult = new Select(driver.findElement(By.id("adult_room")));
		drpAdult.selectByVisibleText(ss7);
		
	}

	@When("User click on Search button")
	public void user_click_on_Search_button() {
		WebElement btnSearch = driver.findElement(By.id("Submit"));
		btnSearch.click();
	}

	@When("User should click on HotelName")
	public void user_should_click_on_HotelName() {
		WebElement btnRadio = driver.findElement(By.id("radiobutton_0"));
		btnRadio.click();
	}

	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		WebElement btnCont = driver.findElement(By.id("continue"));
		btnCont.click();
	}

	@When("User enters {string},{string},{string},{string},{string},{string},{string},{string}")
	public void user_enters(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
		WebElement txtFirst = driver.findElement(By.id("first_name"));
		txtFirst.sendKeys(s1);
	    WebElement txtLast = driver.findElement(By.id("last_name"));
	    txtLast.sendKeys(s2);
	    WebElement txtBill = driver.findElement(By.id("address"));
	    txtBill.sendKeys(s3);
	    WebElement txtCardNo = driver.findElement(By.id("cc_num"));
	    txtCardNo.sendKeys(s4);
	    Select drpCardType = new Select(driver.findElement(By.id("cc_type")));
	    drpCardType.selectByVisibleText(s5);
		Select drpExpMonth = new Select(driver.findElement(By.id("cc_exp_month")));
		drpExpMonth.selectByVisibleText(s6);
		Select drpExpYear = new Select(driver.findElement(By.id("cc_exp_year")));
		drpExpYear.selectByVisibleText(s7);
	    WebElement txtCvv = driver.findElement(By.id("cc_cvv"));
	    txtCvv.sendKeys(s8);
	}

	@Then("User click on Booknow button")
	public void user_click_on_Booknow_button() throws InterruptedException {
		WebElement btnBook = driver.findElement(By.id("book_now"));
		btnBook.click();
		Thread.sleep(5000);
		WebElement order = driver.findElement(By.id("order_no"));
		String orderNum = order.getAttribute("value");
		System.out.println("Your Order Number is :"+orderNum);
	}


}