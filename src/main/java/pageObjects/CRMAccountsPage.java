package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMAccountsPage {

	
	public WebDriver driver;
	public WebDriverWait wait;
	
	
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
	By aletterfilterlink = By.xpath("//a[@id='A_link']");
	By accountname = By.xpath("//div[@data-id='cell-2-2']");
	By addtimelinebtn = By.xpath("//button[@aria-label='Create a timeline record.']");
	By appointmentactivityoptn = By.xpath("//li[@aria-label='Appointment Activity']");
	By timelinesubjecttxtbx = By.xpath("//input[@aria-label='Subject']");
	By timelinesavenclosebtn = By.xpath("//button[@data-id='quickCreateSaveAndCloseBtn']");
	By successmsg = By.xpath("//span[@data-id='notification-message']");
	By accpagebackbtn = By.xpath("//span[@class='symbolFont BackButton-symbol pa-ak ']");
	By relatedTab = By.xpath("//li[@title='Related']");
	By activitiesRelatedTab = By.xpath("//span[@id='navActivities_Related']"); // added xpath for activities option at Related Dropdown list
	By activityTab = By.xpath("//li[@title='Activities']");  // added xpath for activity tab 
	
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
	
	public WebElement getALetterFilterLink()
	{
		return driver.findElement(aletterfilterlink);
	}
	
	public WebElement getAccountName()
	{
		return driver.findElement(accountname);
	}
	
	public WebElement getAddTimelineBtn()
	{
		return driver.findElement(addtimelinebtn);
	}
	
	public WebElement getApptmntActivityOptn()
	{
		return driver.findElement(appointmentactivityoptn);
	}
	
	public WebElement getTimelineSujecttxbx()
	{
		return driver.findElement(timelinesubjecttxtbx);
	}
	
	public WebElement getTimelineSavenClosebtn()
	{
		return driver.findElement(timelinesavenclosebtn);
	}
	
	public WebElement getSuccessMsg()
	{
		return driver.findElement(successmsg);
	}
	
	public WebElement getAccPageBackBtn()
	{
		return driver.findElement(accpagebackbtn);
	}
	
	public WebElement getRelatedTab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(relatedTab));
		return driver.findElement(relatedTab);
	}
	
	public WebElement getSelectActivitiesRelated() {
		return driver.findElement(activitiesRelatedTab);
	}
	public WebElement getActivityTab() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(activityTab));
		return driver.findElement(activityTab);
	}
}
