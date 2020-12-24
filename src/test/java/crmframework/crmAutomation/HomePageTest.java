package crmframework.crmAutomation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AppLandingPage;
import pageObjects.CRMAccounts;
import pageObjects.CRMHomePage;
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
	
		driver.get(prop.getProperty("url"));
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
		driver.switchTo().frame("AppLandingPage");
		AppLandingPage ap = new AppLandingPage(driver);
		ap.getddm().click();
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
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
