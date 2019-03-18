package commons;

import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractTest extends AbstracPage {
	WebDriver driver;
	protected final Log log;
	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

	public WebDriver openMultiBrowser(String browserName, String url) {
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\webdriver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\resources\\webdriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("headless")) {
			System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\webdriver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1920,1080");
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
	
}
