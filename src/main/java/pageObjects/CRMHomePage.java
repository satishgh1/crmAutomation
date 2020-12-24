package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMHomePage {

	public WebDriver driver;
	public WebDriverWait wait;
	
	By hometitle = By.xpath("//span[contains(text(),'Home')]");
	By searchaccount = By.xpath("//input[@aria-label='Search this view']");
	By startsearch = By.xpath("//button[@aria-label='Start search']");
	
			
	public CRMHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public WebElement getHometitle () {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(hometitle));
		return driver.findElement(hometitle);	
		
	}
	public WebElement getSearchAccountField() {
		return driver.findElement(searchaccount);	
	}
	
	public WebElement getstartsearch() {
		return driver.findElement(startsearch);
		
	}
}