package com.sportstaktest.StepDef;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.sportstaktest.Listeners.ExtentReportListener;
import com.sportstaktest.PageObject.SportsTakCricketPage;
import com.sportstaktest.PageObject.SportsTakHomePage;
import com.sportstaktest.PageObject.SportsTakWebStoriesPage;
import com.sportstaktest.Utility.BrowserUtility;
import com.sportstaktest.Utility.PropertiesFileReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SportsTakTest extends ExtentReportListener {
	
	PropertiesFileReader obj= new PropertiesFileReader();  
	private WebDriver driver=null;
	@Given("Open chrome browser and enter URL")
	public void open_chrome_browser_and_enter_URL() throws IOException, InterruptedException {
		
		ExtentTest logInfo=null;
		try {
			test = extent.createTest(Feature.class, "Validating and verifying the functionality of Sportstak");							
			test=test.createNode(Scenario.class, "Validating and verifying the functionality of Sportstak");						
			logInfo=test.createNode(new GherkinKeyword("Given"), "Open chrome browser and enter URL");
			
			Properties properties=obj.getProperty();   
			String browserName = properties.getProperty("browser.name");
			String url = properties.getProperty("browser.baseURL");
			driver = BrowserUtility.OpenBrowser(driver, browserName, url);	
			
			logInfo.pass("Opened chrome browser and entered url");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));			
			
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}	
		
	}
	
	@Then("Click on each thumbnail and verify that links are not broken on Home")
	public void click_on_each_thumbnail_and_verify_that_links_are_not_broken_on_Home() throws Exception {
		
		ExtentTest logInfo=null;
		try {
									
			logInfo=test.createNode(new GherkinKeyword("Then"), "Click on each thumbnail and verify that links are not broken on Home" );
			new SportsTakHomePage(driver).getLinksAndVerify();
			
			logInfo.pass("Clicked on each thumbnail and verifyed that links are not broken on Home");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}
	    
	}

	@And("Click on \"([^\"]*)\"$")
	public void click_on(String tabName) {
		
		ExtentTest logInfo=null;
		try {
									
			logInfo=test.createNode(new GherkinKeyword("And"), "click on tab"+tabName );
			switch(tabName) {
			case "Cricket":
				new SportsTakHomePage(driver).clickOnTab(tabName);
				break;
			case "Web Stories":
				new SportsTakHomePage(driver).clickOnTab(tabName);
				break;
			default:
				System.out.println("No such tab exists.");
			}
			logInfo.pass("Clicked on the channel name");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}
		
	}

	@Then("scroll to the page {string} and click on the links and verify the links are not broken.")
	public void scroll_to_the_page_and_click_on_the_links_and_verify_the_links_are_not_broken(String pageNo) throws NumberFormatException, InterruptedException, IOException {
		
		ExtentTest logInfo=null;
		try {
									
			logInfo=test.createNode(new GherkinKeyword("Then"), "scroll to the page"+pageNo+"and click on the links and verify the links are not broken." );
			new SportsTakCricketPage(driver).scrollToPage(Integer.parseInt(pageNo));
			new SportsTakCricketPage(driver).getLinksAndVerifyOnPage(Integer.parseInt(pageNo));
			
			logInfo.pass("clicked on the links and verifyed the links are not broken.");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}
		
	}

	@And("Change the theme from {string} to {string}.")
	public void change_the_theme_from_to_or_vice_versa(String col1, String col2) throws InterruptedException {
	    
		ExtentTest logInfo=null;
		try {
									
			logInfo=test.createNode(new GherkinKeyword("And"), "Change the theme from" + col1 + "to "+col2+" or vice versa." );
			new SportsTakCricketPage(driver).changeBackGroundColTo(col2);
			
			logInfo.pass("Changed the theme from" + col1 + "to "+col2+" or vice versa.");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}
		
		
	}

	@And("Capture the text on each Web Stories on page {string}.")
	public void capture_the_text_on_each_Web_Stories_on_page(String pageNo) throws InterruptedException {
		
		ExtentTest logInfo=null;
		try {
									
			logInfo=test.createNode(new GherkinKeyword("And"), "Capture the text on each Web Stories on page "+pageNo );
			new SportsTakWebStoriesPage(driver).captureTextOnWebStoriesOnPage(pageNo);
			
			logInfo.pass("Captured the text on each Web Stories on page "+pageNo);
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}
	    
	}

	@And("Click on {string} webstory displayed.")
	public void click_on_webstory_displayed(String webStoryNo) throws InterruptedException {
		
		ExtentTest logInfo=null;
		try {
									
			logInfo=test.createNode(new GherkinKeyword("And"), "Click on "+webStoryNo+" webstory displayed.");
			new SportsTakWebStoriesPage(driver).clickOnWebStory(webStoryNo);
			
			logInfo.pass("Clicked on "+webStoryNo+" webstory displayed.");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}
		
	}

	@Then("click on the next webstory and return to the homepage.")
	public void click_on_the_next_webstory_and_return_to_the_homepage() {
		
		ExtentTest logInfo=null;
		try {
									
			logInfo=test.createNode(new GherkinKeyword("Then"), "click on the next webstory and return to the homepage.");
			new SportsTakWebStoriesPage(driver).switchBrowserTabAndClickOnNextStory();
			
			logInfo.pass("clicked on the next webstory and returned to the homepage.");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}
		System.out.println("Closing the browser.");
		driver.quit();
		System.out.println("Closed the browser.");
	}

}
