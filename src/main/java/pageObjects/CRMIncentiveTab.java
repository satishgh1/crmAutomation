package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMIncentiveTab {
<<<<<<< HEAD
	
	public WebDriver driver;
	public WebDriverWait wait;

	// Open incentive tab for existing account
	
	By inctab = By.xpath("//li[@data-id = 'tablist-tab_4']");
			
	// Add new incentive
			
	By addinc =	By.xpath("//button[@aria-label = 'New Incentive']");
	
	// Select Contact at Add Incentive form
	
=======
	public WebDriver driver;
	public WebDriverWait wait;

	// xpath for Open incentive tab for existing account
	By inctab = By.xpath("//li[@data-id = 'tablist-tab_4']");
			
	// xpath for Add new incentive		
	By addinc =	By.xpath("//button[@aria-label = 'New Incentive']");
	
	// Select Contact at Add Incentive form
>>>>>>> 5bb1e241bc1ccd65b4af59956efad0be368a161d
	By incconclick = By.xpath("//input[@aria-label = 'Contact, Lookup']");
	By incconsearch = By.xpath("//button[@aria-label = 'Search records for Contact, Lookup field']");
	By incconselect = By.xpath("//span[@data-id = 'xxc_contactid.fieldControl-emailaddress11_0_0']");
	
	// Select Market at Add Incentive form
<<<<<<< HEAD
	
=======
>>>>>>> 5bb1e241bc1ccd65b4af59956efad0be368a161d
	By incmarclick = By.xpath("//input[@aria-label = 'Market, Lookup']");
	By incmarsearch = By.xpath("//button[@aria-label = 'Search records for Market, Lookup field']");
	By incmarselect = By.xpath("//span[@data-id = 'xxc_marketid.fieldControl-xxc_channelid1_0_0']");
	
	// Select Referral Source at Add Incentive form
<<<<<<< HEAD
	
=======
>>>>>>> 5bb1e241bc1ccd65b4af59956efad0be368a161d
	By increfclick = By.xpath("//input[@aria-label = 'Referral Source, Lookup']");
	By increfsearch = By.xpath("//button[@aria-label = 'Search records for Referral Source, Lookup field']");
	By increfselect = By.xpath("//span[@data-id = 'xxc_referralsourceid.fieldControl-xxc_type1_0_0']");
	
	// Enter Other Incentive Source at Add Incentive form
<<<<<<< HEAD
	
=======
>>>>>>> 5bb1e241bc1ccd65b4af59956efad0be368a161d
	By incosclick = By.xpath("//input[@aria-label = 'Other Incentive Source']");
	By incosvalue = By.xpath("//input[@aria-label = 'Other Incentive Source']");
	
	// Save Incentive
<<<<<<< HEAD
	
	By incsave = By.xpath("//button[@aria-label = 'Save & Close']");
	
	// Verification
	
=======
	By incsave = By.xpath("//button[@aria-label = 'Save & Close']");
	
	// Verification
>>>>>>> 5bb1e241bc1ccd65b4af59956efad0be368a161d
	By incacc = By.xpath("//div[@title = 'Cyb_Acc1']");
	By inccon = By.xpath("//div[@title = 'New cyb']");
	By incmar = By.xpath("//div[@title = '2010 January 1 Daily']");
	
<<<<<<< HEAD
	public CRMIncentiveTab (WebDriver driver) {
		
=======
	public CRMIncentiveTab (WebDriver driver) {	
>>>>>>> 5bb1e241bc1ccd65b4af59956efad0be368a161d
		this.driver = driver;
	}
	
	public WebElement getinctab() {
<<<<<<< HEAD
		
=======
>>>>>>> 5bb1e241bc1ccd65b4af59956efad0be368a161d
		return driver.findElement(inctab);
	}
	
	public WebElement getnewinc() {
<<<<<<< HEAD
		
=======
>>>>>>> 5bb1e241bc1ccd65b4af59956efad0be368a161d
		return driver.findElement(addinc);
	}
	
	public WebElement getconclick() {
<<<<<<< HEAD
		
=======
>>>>>>> 5bb1e241bc1ccd65b4af59956efad0be368a161d
		return driver.findElement(incconclick);
	}
	
	public WebElement getconsearch() {
<<<<<<< HEAD
		
=======
>>>>>>> 5bb1e241bc1ccd65b4af59956efad0be368a161d
		return driver.findElement(incconsearch);
	}
	
	public WebElement getconselect() {
<<<<<<< HEAD
		
=======
>>>>>>> 5bb1e241bc1ccd65b4af59956efad0be368a161d
		return driver.findElement(incconselect);
	}
	
	public WebElement getmarclick () {
<<<<<<< HEAD
		
		 return driver.findElement(incmarclick);
	}
	
	public WebElement getmarsearch() {
		
=======
		 return driver.findElement(incmarclick);
	}
	
	public WebElement getmarsearch() {	
>>>>>>> 5bb1e241bc1ccd65b4af59956efad0be368a161d
		return driver.findElement(incmarsearch);
	}
	
	public WebElement getmarselect() {
<<<<<<< HEAD
		
=======
>>>>>>> 5bb1e241bc1ccd65b4af59956efad0be368a161d
		return driver.findElement(incmarselect);
	}
	
	public WebElement getrefclick () {
<<<<<<< HEAD
		
=======
>>>>>>> 5bb1e241bc1ccd65b4af59956efad0be368a161d
		 return driver.findElement(increfclick);
	}
	
	public WebElement getrefsearch() {
<<<<<<< HEAD
		
=======
>>>>>>> 5bb1e241bc1ccd65b4af59956efad0be368a161d
		return driver.findElement(increfsearch);
	}
	
	public WebElement getrefselect() {
<<<<<<< HEAD
		
=======
>>>>>>> 5bb1e241bc1ccd65b4af59956efad0be368a161d
		return driver.findElement(increfselect);
	}
	
	public WebElement getosclick() {
<<<<<<< HEAD
		
=======
>>>>>>> 5bb1e241bc1ccd65b4af59956efad0be368a161d
		return driver.findElement(incosclick);
	}
	
	public WebElement getosvalue() {
<<<<<<< HEAD
		
=======
>>>>>>> 5bb1e241bc1ccd65b4af59956efad0be368a161d
		return driver.findElement(incosvalue);
	}
	
	public WebElement getincsave() {
<<<<<<< HEAD
		
=======
>>>>>>> 5bb1e241bc1ccd65b4af59956efad0be368a161d
		return driver.findElement(incsave);
	}
	
	public WebElement accname() {
<<<<<<< HEAD
		
=======
>>>>>>> 5bb1e241bc1ccd65b4af59956efad0be368a161d
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(incacc));
		return driver.findElement(incacc);
	}
	
	public WebElement conname() {
<<<<<<< HEAD
		
=======
>>>>>>> 5bb1e241bc1ccd65b4af59956efad0be368a161d
		return driver.findElement(inccon);
	}
	
	public WebElement marname() {
<<<<<<< HEAD
		
		return driver.findElement(incmar);
	}
	
}

=======
		return driver.findElement(incmar);
	}

}
>>>>>>> 5bb1e241bc1ccd65b4af59956efad0be368a161d
