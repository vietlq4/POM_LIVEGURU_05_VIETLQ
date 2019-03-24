package commons;

import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest extends AbstracPage {
	protected final Log log;
	private final String workingDir = System.getProperty("user.dir");
	WebDriver driver;
	
	
	
	
	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

	public WebDriver openMultiBrowser(String browserName, String url) {
		if (browserName.equals("chrome")) {
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			WebDriverManager.chromedriver().version("72.0").setup();
			driver = new ChromeDriver();
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--incognito");
//			options.addArguments("--disable-extensions");
//			options.addArguments("disable-inforbars");
//			options.addArguments("start-maximized");
//			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//			driver = new ChromeDriver(capabilities);
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, workingDir + "//FirefoxLog.txt");
			FirefoxOptions options = new FirefoxOptions();
			driver = new FirefoxDriver(options);
		} else if (browserName.equals("headless")) {
			   WebDriverManager.chromedriver().setup();
			 ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("start-maximized");
			driver = new ChromeDriver(options);
		}
		openAnyUrl(driver, url);

		return driver;
	}
	public int randomNumber()
    {
  	  Random rand =new Random();
  	  int n= rand.nextInt(999999)+1;
  	  return n;
    }
	private boolean checkPassed(boolean condition) {
    	boolean pass = true;
		try {
			if (condition == true)
				log.info("===PASSED===");
			else
				log.info("===FAILED===");
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;
			log.info(e.getMessage());
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
//			 Add status (true/ false) to Report (ReportNG)
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkPassed(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true)
				log.info("===PASSED===");
			else
				log.info("===FAILED===");
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			log.info(e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
		} catch (Throwable e) {
			pass = false;
			log.info(e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}
}
	

