package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMLoginPage {
	public WebDriver driver;
	public WebDriverWait wait;
	
	By password = By.id("passwordInput");
	By signin = By.xpath("//span[@id='submitButton']");
	By verify = By.id("idSubmit_SAOTCC_Continue");
	By staysignin = By.xpath("//div[contains(text(),'Stay signed in?')]");
	By dontshowcheckbox = By.xpath("//input[@id='KmsiCheckboxField']");
	By signinYes = By.xpath("//input[@id='idSIButton9']");
	
	public CRMLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getpwd() {
		return driver.findElement(password);
		
	}
	
	public WebElement getsignin() {
		return driver.findElement(signin);
	}

	public WebElement getVerify() {
		return driver.findElement(verify);
		
	}
	
	public WebElement getstaysignin() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(staysignin));
		return driver.findElement(staysignin);		
	}
	
	public WebElement getdontshowcheckbox() {
		return driver.findElement(dontshowcheckbox);
	}
	
	public WebElement getsigninYes() {
		return driver.findElement(signinYes);
		
	}
}
