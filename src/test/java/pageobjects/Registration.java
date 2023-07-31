package pageobjects;


import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Registration {
	
	private String firstNameLocator = "input[name=\"firstname\"]";
	private String lastNameLocator = "input[name=\"lastname\"]";
	private String genderLocator = "input[value=\"Male\"]";
	private String expLocator = "input[value=\"2\"]";
	private String dateLocator = "input[type=\"text\"]";
	private String professionLocator = "input[value=\"Automation Tester\"]";
	private String autoToolsLocator = "input[value=\"Selenium Webdriver\"]";
	private String continentLocator = "select[name=\"continents\"]";
	private String commandLocator = "select[name=\"selenium_commands\"]";
	private String photoLocator = "input[name=\"photo\"]";
	private String submitLocator = "button[name=\"submit\"]";
	
	private WebDriver driver;
	private JavascriptExecutor js;
	
	@Given("Land on the page")
	public void firststep() throws IOException, InterruptedException {
		driver = Base.setUp();
		driver.manage().window().maximize();
		driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
		Thread.sleep(5000);
		Assert.assertEquals("Selenium - Automation Practice Form | Tutorialspoint", driver.getTitle());
	}
	
	@When("fill all details")
	public void fillDetails() throws IOException {
		driver.findElement(By.cssSelector(firstNameLocator)).sendKeys("Vinay");
		driver.findElement(By.cssSelector(lastNameLocator)).sendKeys("Jain");
		driver.findElement(By.cssSelector(genderLocator)).click();
		driver.findElement(By.cssSelector(expLocator)).click();
		driver.findElements(By.cssSelector(dateLocator)).get(2).sendKeys("30-07-2023");
		
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)", "");
		driver.findElement(By.cssSelector(professionLocator)).click();
		driver.findElement(By.cssSelector(autoToolsLocator)).click();
		
		Select select = new Select(driver.findElement(By.cssSelector(continentLocator)));
		select.selectByIndex(0);
		
		Select se = new Select(driver.findElement(By.cssSelector(commandLocator)));
		se.selectByIndex(0);
		js.executeScript("window.scrollBy(0,200)", "");		
		driver.findElement(By.cssSelector(photoLocator)).sendKeys("/home/priya/Downloads/1666697598682.jpg");
	}
	
	@Then("submit the form")
	public void submitForm() throws IOException {
		driver.findElement(By.cssSelector(submitLocator));
		Base.tearDown();
	}

}
