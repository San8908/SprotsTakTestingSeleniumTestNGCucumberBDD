package com.sportstaktest.PageObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SportsTakCricketPage {
	
	public WebDriver driver;
	
	public SportsTakCricketPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(@class,'news-load')]//img")
	WebElement LoadingIcon;
	
	@FindBy(xpath="//div[@class='backbutton']//span[text()='Back']")
	WebElement Backbutton;
	
	@FindBy(xpath="//h2[contains(@class,'MuiTypography-body1')]")
	List<WebElement>links;
	
	@FindBy(xpath="//span[text()='Light']//ancestor::button")
	WebElement LightButton;
	
	@FindBy(xpath="//span[text()='Dark']//ancestor::button")
	WebElement DarkButton;
	
	@FindBy(xpath="(//body)[1]")
	WebElement Body;
	
	public void scrollToPage(int pageNo) throws InterruptedException {
		
		System.out.println("Entering into Method: scrollToPage");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		for(int i=1;i<=pageNo;i++) {
			je.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(5000);
		}
		System.out.println("Exiting from Method: scrollToPage");
	}
	
	public void getLinksAndVerifyOnPage(int pageNo) throws InterruptedException, IOException {
		
		System.out.println("Entering into Method: getLinksAndVerifyOnPage");
		int startPoint = (pageNo-1)*10;
		String xpath = "(//h2[contains(@class,'MuiTypography-body1')]//ancestor::a)";
		List<WebElement>links = driver.findElements(By.xpath(xpath));
		scrollToPage(pageNo);
		for(int i=startPoint;i<links.size();i++) {
			String url = driver.findElement(By.xpath(xpath+"["+ i + "]")).getAttribute("href");
			checkIfTheLinkIsWorking(url);
		}
		System.out.println("Exiting from Method: getLinksAndVerifyOnPage");
	}
	
	public void checkIfTheLinkIsWorking(String Url) throws IOException  {
		
		System.out.println("Entering into Method: checkIfTheLinkIsWorking");
		URL url = new URL(Url);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setConnectTimeout(5000);
		httpConn.connect();
		if(httpConn.getResponseCode()>=400)
			System.out.println("Link is Broken :"+ Url);
		else
			System.out.println("Link is not Broken :"+ Url);
		
		System.out.println("Exiting from Method: checkIfTheLinkIsWorking");
	}
	
	public void changeBackGroundColTo(String ColName) throws InterruptedException  {
		
		System.out.println("Entering into Method: changeBackGroundColTo");
		
		if(ColName.equalsIgnoreCase("Dark")) {
			if(DarkButton.isDisplayed()) {
				DarkButton.click();
				Thread.sleep(2000);
				String Bodycol = Body.getCssValue("background");
				if(Bodycol.contains("(37, 37, 38)")) {
					System.out.println("The background col has been changed to : " +ColName);
				}
			}
			else
				System.out.println("The "+ ColName + "colour button is not present or current page theme is "+ ColName);
		}
		else {
			if(LightButton.isDisplayed()) {
				LightButton.click();
				Thread.sleep(2000);
				String Bodycol = Body.getCssValue("background");
				if(Bodycol.contains("(241, 242, 246)")) {
					System.out.println("The background col has been changed to : " +ColName);
				}
			}
			else
				System.out.println("The "+ ColName + "colour button is not present or current page theme is "+ ColName);
		}
		
		System.out.println("Exiting from Method: changeBackGroundColTo");
		
	}
}
