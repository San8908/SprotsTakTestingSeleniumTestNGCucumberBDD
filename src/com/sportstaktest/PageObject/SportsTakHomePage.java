package com.sportstaktest.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class SportsTakHomePage {
	
	WebDriver driver;
	int count=1;
	
	public SportsTakHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='backbutton']//span[text()='Back']")
	WebElement Backbutton;
	
	@FindBy(xpath="//button[@aria-label='Cricket' and @role='tab']")
	WebElement CricketTab;
	
	@FindBy(xpath="//a[text()='Web Story']")
	WebElement WebStoryTab;
	
	
	public void getLinksAndVerify() throws Exception
	{
		
		System.out.println("Entering into Method: getLinksAndVerify");
		String xpath = "(//h2[contains(@class,'MuiTypography-body1') and contains(@class,'DetailsCardSide')])";
		List<WebElement>links = driver.findElements(By.xpath(xpath));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		System.out.println("Total links "+ links.size());
		for(int i=1;i<links.size();i++) {
			String index = Integer.toString(i);
			String mainXpath = xpath+"["+ index + "]";
			WebElement element = driver.findElement(By.xpath(mainXpath));
			je.executeScript("arguments[0].scrollIntoView();", element);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mainXpath)));
			je.executeScript("arguments[0].click();", element);
			checkIfTheLinkIsWorking();
		}
		System.out.println("Exiting from Method: getLinksAndVerify");
		
	}
	
	public void checkIfTheLinkIsWorking() throws InterruptedException {
		
		System.out.println("Entering into Method: checkIfTheLinkIsWorking");
		
		Assert.assertTrue(Backbutton.isDisplayed(),"Link is not working");
		System.out.println(count+" Link is working");
		Backbutton.click();
		count++;
		
		System.out.println("Exiting from Method: checkIfTheLinkIsWorking");
	}
	
	public void clickOnTab(String tabName) {
		
		System.out.println("Entering into Method: clickOnTab");
		
		switch(tabName) {
		case "Cricket":
			CricketTab.click();
			break;
		case "Web Stories":
			WebStoryTab.click();
			break;
		default:
			System.out.println("No such tab exists.");
		}
		
		System.out.println("Exiting from Method: clickOnTab");
	}
}
