package crmframework.crmAutomation;

import java.awt.List;
import java.io.IOException;

import org.openqa.selenium.WebElement;
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
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();		
	}
	
	@Test
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
		//Wait to enter the verification code form Mobile
		Thread.sleep(30000);
		lp.getVerify().click();
		lp.getdontshowcheckbox().click();
		lp.getsigninYes().click();
		Thread.sleep(30000);
		//to wait on Published App Landing page
		driver.switchTo().frame("AppLandingPage");
		AppLandingPage alp = new AppLandingPage(driver);
		//select Demand Driver application on Landing Page
		alp.getddm().click();
		CRMHomePage hp = new CRMHomePage(driver);
		hp.getHometitle().isDisplayed();
		System.out.println("Login to CRM successfully");		
	}
	
//	@Test
//	public void validateExistingAccount() {
//		
//		CRMHomePage hp = new CRMHomePage(driver);
//		hp.getSearchAccountField().click();
//		hp.getSearchAccountField().sendKeys("Cyb_QATest");
//		hp.getstartsearch().click();
//		CRMAccounts ca= new CRMAccounts(driver);
//		Assert.assertEquals("Cyb_QATest", ca.getAccountDBAname().getText());
//		
//	}
	
	@Test
	public void validateRelatedTabs() {
		// verify on selecting respective field is get opened or not on selecting option from Accounts -> Related
		CRMHomePage hp = new CRMHomePage(driver);
		//Select Accounts menu from left navigation bar
		hp.getAccountTab().click();
			
	}
	
	@Test
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
	
	@Test
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
