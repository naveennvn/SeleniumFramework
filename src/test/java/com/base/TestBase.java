package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.listener.EventListeners;
import com.utilities.ExcelReader;
import com.utilities.JSWaiter;
import com.utilities.TestUtil;

/**
 * Intilaizes the browser and creates the desired capabilities if execution is performed on Remote 
 * Give local[to execute in local machine] or Remote[to execute on sauce labs] in TestNG xml for each test as per the requirement 
 * 
 * @author repalan
 *
 */
public class TestBase {

	/*
	 * WebDriver - done Properties - done Logs - log4j jar, .log,
	 * log4j.properties, Logger ExtentReports DB Excel Mail ReportNG,
	 * ExtentReports Jenkins
	 * 
	 *  
	 */
	public static Logger log;
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(".//src//test//resources//excel//testdata.xlsx");
	public static WebDriverWait wait;
	public DesiredCapabilities cap=null;
	public EventFiringWebDriver _efDriver;
	public JSWaiter _jswait;

	/**
	 * Purpose - to initiate driver based on the browser,execution-type taken from testng.xml
	 * Author- Naveen
	 * 
	 */
	@Parameters({"Browser","ExecutionType"})
	@BeforeClass
	public void setUp(String browser,String executiontype,ITestContext context) throws FileNotFoundException {
		log=Logger.getLogger("devpinoyLogger");
		System.out.println(System.getProperty("user.dir"));
		if (driver == null) {

			try {
				fis = new FileInputStream(".//src//test//resources//properties//Config.properties");
				config.load(fis);
				log.debug("Config file loaded !!!");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(executiontype.contains("local"))
			{
				executeinlocal(browser,context);
			}

			else if (executiontype.contains("Remote"))
			{
				executeonRemote(browser,context);
			}
			_jswait=new JSWaiter(driver);
			_efDriver=new EventFiringWebDriver(driver);
			EventListeners _event=new EventListeners();
			driver=_efDriver.register(_event);
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			//wait = new WebDriverWait(driver, 5);
		}
	}

	private void executeonRemote(String browser,ITestContext context) {

		log.info("-----------------STARTED RUNNING SELENIUM TESTS ON CLOUD /GRID------------------");
		String USERNAME = "cdk-globalit";
		String ACCESS_KEY = "586141a1-a639-42ec-b67f-170268909d56";  
		String SauceLabsURL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
		if (browser.contains("firefox"))
		{
			cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.ANY);
			cap.setCapability("build", "Build-Number123");
			cap.setCapability("name", context.getName());

			try {
				driver = new RemoteWebDriver(new URL(SauceLabsURL),cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//driver.get("https://www-dit.connectcdk.com/a/unifiedcustomerportal/");

		}

		if (browser.contains("chrome"))
		{
			cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.ANY);
			cap.setCapability("name", context.getName());

			try {
				driver = new RemoteWebDriver(new URL(SauceLabsURL),cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}

	public void executeinlocal(String browser,ITestContext context)
	{
		log.info("-----------------STARTED RUNNING SELENIUM TESTS ON LOCAL MACHINE------------------");
		if (browser.contains("firefox")) {

			System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\executables\\gecko.exe");
			driver = new FirefoxDriver();

		} else if (browser.contains("chrome")) {

			System.setProperty("webdriver.chrome.driver",".\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
			log.debug("Chrome Launched !!!");
		} else if (browser.contains("ie")) {

			System.setProperty("webdriver.ie.driver",".\\src\\test\\resources\\executables\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			log.debug("IE Launched !!!");
		}
	}


	public String getBrowserName() {
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		return caps.getBrowserName();
	}


	public boolean isElementPresent(By by) {

		try {

			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {

			return false;

		}

	}

	public static void verifyEquals(String expected, String actual) throws IOException {

		try {

			Assert.assertEquals(actual, expected);

		} catch (Throwable t) {

			TestUtil.captureScreenshot();
			// ReportNG
			Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName
					+ " height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			// Extent Reports
			//test.log(LogStatus.FAIL, " Verification failed with exception : " + t.getMessage());
			//test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
		}

	}

/*After execution of all tests this is to quit the driver
 * gets executed after the execution of all tests
 */
	@AfterSuite
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}

		log.debug("test execution completed !!!");
	}
}
