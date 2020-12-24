package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {	
	public WebDriver driver;
	
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		prop= new Properties();
		FileInputStream fls= new FileInputStream("D:\\Automation\\CRMAutomationFramework\\crmAutomation\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fls);
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			//execute the code
			
		}
		else if (browserName.equals("firefox"))
		{
			driver = new FirefoxDriver();
			//execute the code
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		 
	}
	
}
