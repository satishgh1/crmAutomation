package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMHomePage {

	// this page is created for all the web elements available on CRM home page.
	public WebDriver driver;
	public WebDriverWait wait;
	
	By hometitle = By.xpath("//span[contains(text(),'Home')]");
	By searchaccount = By.xpath("//input[@aria-label='Search this view']");
	By startsearch = By.xpath("//button[@aria-label='Start search']");
	By accountTab = By.xpath("//span[contains(text(),'Accounts')]");
	By clearsearch = By.xpath("//button[@title='Clear search']");
				
	public CRMHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public WebElement getHometitle () {
		// webelement for home title on CRM home page. 
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(hometitle));
		return driver.findElement(hometitle);	
		
	}
	public WebElement getSearchAccountField() {
		//web element for the search account field
		return driver.findElement(searchaccount);	
	}
	
	public WebElement getstartsearch() {
		//web element for the click on search icon
		return driver.findElement(startsearch);		
	}
	
	public WebElement getAccountTab() {
		// web element for the Account tab at left find side pane.
		return driver.findElement(accountTab);
	}
	
	public WebElement getClearSearch() {
		// web element for the Account tab at left find side pane.
		return driver.findElement(clearsearch);
	}
	
}