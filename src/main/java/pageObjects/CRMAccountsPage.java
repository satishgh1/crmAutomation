package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRMAccountsPage {

	public WebDriver driver;
	
	By accountnewbtn = By.xpath("//span[contains(text(),'New')]");
	By accountNametxtbx = By.xpath("//input[@id='id-276390f9-8bbf-4452-8f24-636b0ccaee2c-1-name8-name.fieldControl-text-box-text']");
	By phn = By.xpath("//input[@aria-label='Phone']");		
	By address = By.xpath("//h2[contains(text(),'Address')]");
	By acctypetxtbx = By.xpath("//input[@id='xxc_typecode_ledit']");
	By acctypeexpandbtn = By.xpath("//button[@aria-label='Toggle menu']");
	By acctype = By.xpath("//div[contains(text(),'Buyer')]");
	By street1 = By.xpath("//input[@aria-label='Street 1']");
	By state = By.xpath("//input[@aria-label='State/Province']");
	By countrytxtbx = By.xpath("//input[@aria-label='Country']");
	By city = By.xpath("//input[@aria-label='City']");
	By zip = By.xpath("//input[@aria-label='ZIP/Postal Code']");
	By cntryexpandbtn = By.xpath("//button[@aria-label='Toggle Dropdown']");
	By countryname = By.xpath("//body/div[@id='_dropdown']/div[3]");
	By accsavenclosebtn = By.xpath("//button[@aria-label='Save & Close']");
	
	
	public CRMAccountsPage(WebDriver driver) {

		this.driver = driver;
	}
	
	public WebElement getAccountnametxtbx() {
		
		return driver.findElement(accountNametxtbx);
	}
	
	public WebElement getAccountNewbtn()
	{
		return driver.findElement(accountnewbtn);
	}
	
	public WebElement getPhone()
	{
		return driver.findElement(phn);
	}
	
	public WebElement getAddress()
	{
		return driver.findElement(address);
	}
	
	public WebElement getAccTypetxtbx()
	{
		return driver.findElement(acctypetxtbx);
	}
	
	public WebElement getAcctypeExpandbtn()
	{
		return driver.findElement(acctypeexpandbtn);
	}
	
	public WebElement getAccType()
	{
		return driver.findElement(acctype);
	}
	
	public WebElement getStreet1()
	{
		return driver.findElement(street1);
	}
	
	public WebElement getState()
	{
		return driver.findElement(state);
	}
	
	public WebElement getCity()
	{
		return driver.findElement(city);
	}
	
	public WebElement getZipcode()
	{
		return driver.findElement(zip);
	}
	
	public WebElement getCountrytxbx()
	{
		return driver.findElement(countrytxtbx);
	}
	
	public WebElement getCountrydrpbtn()
	{
		return driver.findElement(cntryexpandbtn);
	}
	
	public WebElement getCountryName()
	{
		return driver.findElement(countryname);
	}
	
	public WebElement getAccSaveCloseBtn()
	{
		return driver.findElement(accsavenclosebtn);
	}
	
}
