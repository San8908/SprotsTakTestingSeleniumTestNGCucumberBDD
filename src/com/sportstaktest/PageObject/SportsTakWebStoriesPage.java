package com.sportstaktest.PageObject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SportsTakWebStoriesPage {

	WebDriver driver;

	public SportsTakWebStoriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@aria-label='Next page']")
	WebElement NextWebStoryButton;

	public void captureTextOnWebStoriesOnPage(String pageNo) throws InterruptedException {
		
		System.out.println("Entering into Method: captureTextOnWebStoriesOnPage");
		
		int PageNo = Integer.parseInt(pageNo);
		scrollToPage(PageNo);
		List<WebElement> webStories = driver.findElements(By.xpath("//section[@class='webstories-title']//p"));
		for (int i = 0; i < webStories.size(); i++) {
			int WebStoryNumber = i+1;
			System.out.println("Web story " + WebStoryNumber + " text is: " + webStories.get(i).getText());
		}
		
		System.out.println("Exiting from Method: captureTextOnWebStoriesOnPage");
	}

	public void scrollToPage(int pageNo) throws InterruptedException {
		
		System.out.println("Entering into Method: scrollToPage");
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		for (int i = 1; i < pageNo; i++) {
			je.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(2000);
		}
		
		System.out.println("Exiting from Method: scrollToPage");
	}

	public void clickOnWebStory(String webStoryNo) throws InterruptedException {
		
		System.out.println("Entering into Method: scrollToPage");
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement WebStoryWebElement = driver
				.findElement(By.xpath("(//section[@class='webstories-title']//p)" + "[" + webStoryNo + "]"));
		je.executeScript("arguments[0].click();", WebStoryWebElement);
		
		System.out.println("Exiting from Method: scrollToPage");
		
	}
	
	public void clickOnNextWebStoryButton() {
		
		System.out.println("Entering into Method: clickOnNextWebStoryButton");
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", NextWebStoryButton);
		
		System.out.println("Exiting from Method: clickOnNextWebStoryButton");
	}
	
	public void switchBrowserTabAndClickOnNextStory() {
		
		System.out.println("Entering into Method: switchBrowserTabAndClickOnNextStory");
		
		Set<String> windowHandels = driver.getWindowHandles();
		Iterator<String> it = windowHandels.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		clickOnNextWebStoryButton();
		driver.switchTo().window(parentWindow);
		
		System.out.println("Exiting from Method: switchBrowserTabAndClickOnNextStory");
	}
	 

}
