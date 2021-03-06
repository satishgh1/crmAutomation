package crmframework.crmAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.AppLandingPage;
import pageObjects.CRMAccountsPage;
import pageObjects.CRMAddMarketingRelationshipOwner;
import pageObjects.CRMHomePage;
import pageObjects.CRMIncentiveTab;
import pageObjects.CRMLandingPage;
import pageObjects.CRMLoginPage;
import resources.base;

public class HomePageTest extends base {
	
	public WebDriverWait wait;
	public String accnameText;
	
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();		
	}
	
	@Test(priority=1)
	public void crmhomepage() throws IOException, InterruptedException {
		
		//this test case will validate the Login to CRM Application
		//verify Select Demand Driver App from Published page 
		//verify CRM Home page launched
		
		driver.get(prop.getProperty("url")); //CRM App
		driver.manage().window().maximize();
		CRMLandingPage lap = new CRMLandingPage(driver);
		lap.getLogin().sendKeys(prop.getProperty("username"));
		lap.getnext().click();
		
		CRMLoginPage lp= new CRMLoginPage(driver);
		lp.getpwd().click();
		lp.getpwd().sendKeys(prop.getProperty("password"));
		lp.getsignin().click();
		//Wait to enter the verification code from Mobile
		Thread.sleep(30000);
		lp.getVerify().click();
		lp.getdontshowcheckbox().click();
		lp.getsigninYes().click();
		//to wait on Published App Landing page
		Thread.sleep(30000);
		driver.switchTo().frame("AppLandingPage");
		AppLandingPage alp = new AppLandingPage(driver);
		//select Demand Driver application on Landing Page
		alp.getddm().click();
		
		CRMHomePage hp1 = new CRMHomePage(driver);
		hp1.getHometitle().isDisplayed();
		System.out.println("Login to CRM successfully");		
	}
	
	@Test(priority=2)
	public void verifyCreateAccount() throws InterruptedException
	{
		//Select Accounts menu from left navigation bar
		CRMHomePage hp = new CRMHomePage(driver);
		hp.getAccountTab().click();
		//Wait till Active Accounts page is displayed
		new WebDriverWait (driver,20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'New')]")));
		
		CRMAccountsPage ap = new CRMAccountsPage(driver);
		//Click on 'New' button
		ap.getAccountNewbtn().click();
		//Wait till new account page is displayed
		new WebDriverWait (driver,20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@title='New Account']")));
		
		//Fill all the mandatory fields to create new account
		//Enter Account Name
		WebElement accountName = driver.findElement(By.xpath("//input[@id='id-276390f9-8bbf-4452-8f24-636b0ccaee2c-1-name8-name.fieldControl-text-box-text']"));
		accountName.click();
		accnameText = "Cyb_NewAcc06";
		accountName.sendKeys(accnameText);
		
		//Enter Phone no.
		ap.getPhone().click();
		ap.getPhone().sendKeys(prop.getProperty("phone"));
		Thread.sleep(5000);
		
		//Scroll up the page till Address field
		Actions action = new Actions(driver);
		action.moveToElement(ap.getAddress()).perform();
		
		//Select account type
		ap.getAccTypetxtbx().click();
		ap.getAcctypeExpandbtn().click();
		ap.getAccType().click();
		ap.getAddress().click();
		
		//Scroll down on the page
		action.keyDown(Keys.CONTROL).sendKeys(Keys.DOWN).perform();
		action.keyDown(Keys.CONTROL).sendKeys(Keys.DOWN).release().perform();
		
		Thread.sleep(5000);
		//Enter Street1 address
		ap.getStreet1().sendKeys(prop.getProperty("street1"));
		
		//Enter City
		ap.getCity().click();
		ap.getCity().sendKeys(prop.getProperty("city"));
				
		//Enter state
		ap.getState().click();
		ap.getState().sendKeys(prop.getProperty("state"));
		
		//Enter zipcode
		ap.getZipcode().click();
		ap.getZipcode().sendKeys(prop.getProperty("zipcode"));
		
		//Enter country
		ap.getCountrytxbx().click();
		ap.getCountrydrpbtn().click();
		ap.getCountryName().click();
		
		//Click on Save and Close button
		ap.getAccSaveCloseBtn().click();
		//Wait till Active Accounts page is displayed
		new WebDriverWait (driver,20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Active Accounts']")));
		
		//Verify the newly created account
		hp.getSearchAccountField().click();
		hp.getSearchAccountField().sendKeys(accnameText);
		hp.getstartsearch().click();
		Thread.sleep(10000);
		WebElement validateAccName = driver.findElement(By.xpath("//a[contains(text(),'"+accnameText+"')]"));
		if (validateAccName.isDisplayed()) {
			System.out.println("New Account is created successfully");
		}
		else {
			System.out.println("Failed to create a new account");
		}
		
		//Clear the search term
		hp.getClearSearch().click();
	}
	
	@Test(priority=3)
	public void addTimeline() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		
		CRMAccountsPage ap1 = new CRMAccountsPage(driver);
		//Click on 'A' link to sort accounts starts with 'A'
		ap1.getALetterFilterLink().click();
		Thread.sleep(4000);	
			
		//Select the account name in list
		ap1.getAccountName().click();
		Thread.sleep(5000);
	
		//Click on create a timeline button
		ap1.getAddTimelineBtn().click();
		
		ap1.getApptmntActivityOptn().click();
		Thread.sleep(3000);
		
		ap1.getTimelineSujecttxbx().click();
		String subtext = "Cyb_TestAppointment";
		ap1.getTimelineSujecttxbx().sendKeys(subtext);
		
		ap1.getTimelineSavenClosebtn().click();
		Thread.sleep(5000);
		
		//Verify that added Timeline is reflected correctly
		WebElement timeline = driver.findElement(By.xpath("//*[text()='"+subtext+"']"));
		Assert.assertEquals(timeline.getText(), subtext);
		
		//Verify that expected Success message displayed
		Thread.sleep(3000);
		Assert.assertEquals("Your changes were saved.", ap1.getSuccessMsg().getText());
		
		//Navigate back to Active accounts list
		ap1.getAccPageBackBtn().click();
				
		Thread.sleep(3000);	
	}
	
	@Test(priority=4)
	public void AddIncentive() {

		CRMIncentiveTab inc = new CRMIncentiveTab(driver);
		// Click Incentives tab at existing account
		inc.getinctab().click();

		// Open New Incentive Form
		inc.getnewinc().click();

		// Select Contact at New Incentive Form
		inc.getconclick().click();
		inc.getconsearch().click();
		inc.getconselect().click();

		// Select Market at New Incentive Form
		inc.getmarclick().click();
		inc.getmarsearch().click();
		inc.getmarselect().click();

		// Select Referral Source at New Incentive Form
		inc.getrefclick().click();
		inc.getrefsearch().click();
		inc.getrefselect().click();

		// Enter Other Incentive Source at New Incentive Form
		inc.getosclick().click();
		inc.getosvalue().sendKeys("None");

		// Save and Close Incentive
		inc.getincsave().click();

		// Incentive Verification
		if (inc.accname().getText().contains("Cyb") && inc.conname().getText().contains("New") && inc.marname().getText().contains("Jan"))
		{
			System.out.println ("Incentive added successfully.");
		}
		else
		{
			System.out.println ("Incentive not added.");
		}
	}
	
	@Test(priority=5)
	public void addIncentiveDetails() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
				
		CRMAccountsPage ap2 = new CRMAccountsPage(driver);
		//Click on 'A' link to sort accounts starts with 'A'
		ap2.getALetterFilterLink().click();
		Thread.sleep(4000);	
			
		//Select the account name in list
		ap2.getAccountName().click();
		
		CRMIncentiveTab inc1 = new CRMIncentiveTab(driver);
		//Select 'Incentives' tab
		inc1.getinctab().click();
		
		//Click on 'New Incentive Details' button
		inc1.getIncDetaills().click();
		
		//Enter the data in Incentive field 
		inc1.getInctxtbx().click();
		inc1.getInctxtbx().sendKeys(Keys.ENTER); 
		
		inc1.getIncChangeView().click();
		inc1.getIncActiveIncs().click();
		Thread.sleep(2000);
		inc1.getIncName().click();
		
		//Enter the data in Incentive Category field
		inc1.getIncCattxtbx().click();
		inc1.getIncCattxtbx().sendKeys(prop.getProperty("incentivecategory"));
		inc1.getIncCatSearch().click();
		String IncCatagtitle = inc1.getIncCatName().getText();
		inc1.getIncCatName().click();
		inc1.getIncDetailsSavenClose().click();
		Thread.sleep(5000);
				
		//Verify that added Incentive details are reflected correctly
		if ((inc1.getValidateIncName().getText()).contains(IncCatagtitle)) {
			System.out.println("Incentive details get added successfully");
		}
		else {
			System.out.println("Fails to add Incentive Details");
		}
		
		//Verify that expected Success message displayed
		Thread.sleep(3000);
			System.out.println(inc1.getIncdtlsSuccessMsg().getText());
		Assert.assertEquals("Your changes were saved.", inc1.getIncdtlsSuccessMsg().getText());
		
		CRMAccountsPage ap3 = new CRMAccountsPage(driver);
		//Navigate back to Active accounts list
		ap3.getAccPageBackBtn().click();
		
		Thread.sleep(3000);
	}
	
	@Test(priority=6)
	public void relatedTab() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		
		CRMAccountsPage ap1 = new CRMAccountsPage(driver);
		//Click on 'A' link to sort accounts starts with 'A'
		ap1.getALetterFilterLink().click();
		Thread.sleep(4000);	

		//Select the account name in list
		ap1.getAccountName().click();
		Thread.sleep(5000);
		//click on Related Tab and select Activities option from list. 
		ap1.getRelatedTab().click();
		ap1.getSelectActivitiesRelated().click();
		Boolean displayActivityTab = ap1.getActivityTab().isDisplayed();
		System.out.println("Activities Tab Opened successfully:"+displayActivityTab);
	}
	
	@Test(priority=7)
	public void AddMarketingRelationshipOwner() {

		CRMAddMarketingRelationshipOwner amro = new CRMAddMarketingRelationshipOwner(driver);

		// Click arrow to open marketing relationship window
		amro.gethdbtn().click();

		// Click Marketing Relationship Owner lookup
		amro.getmarlookupclick().click();

		// Select Marketing Relationship Owner in lookup
		WebElement Owner = amro.getmarlookupselect();

		if (Owner.getText().contains("Bhavesh")) 
		{
			amro.getmarlookupselect().click();

		}

		// Save selected marketing relationship owner
		amro.getmarownersave().click();	

		// Verify selected marketing relationship owner
		if (amro.getmarownerverify().getText().contains("Bhavesh"))
		{
			System.out.println("Marketing Relationship Owner added successfully");
		}
		else
		{
			System.out.println("Marketing Relationship Owner not added successfully");
		}
	}

	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
