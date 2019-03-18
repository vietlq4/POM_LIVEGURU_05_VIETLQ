package testcases.com.liveguru.user;

import java.util.jar.Attributes.Name;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstracPage;
import commons.AbstractTest;
import page.object.DeleteAccountPageObject;
import page.object.HomePageObject;
import page.object.LoginPageObject;
import page.object.MobilePageObject;
import page.object.MyAccountObject;
import page.object.MyDashboardPage;
import page.object.NewCustomerPageObject;
import page.object.PageFactoryManager;
import page.object.RegiterPageObject;
import page.object.WithDrawPageObject;

public class User_01_login_level_4_ApplyDynamic extends AbstractTest {
	WebDriver driver;
	WebDriverWait wait;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegiterPageObject registerPage;
	private MobilePageObject mobilePage;
	private MyAccountObject myAccountPage;
	private MyDashboardPage myDashboardPage;
	// private RegiterPageObject registerPage;
     
     String emailInput = "LE" + randomNumber() + "@hello.com";
     
      
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = openMultiBrowser(browserName, url);
		homePage = PageFactoryManager.openHomePageObject(driver);

	}

	@Test
	public void TC_01_Register() {
		System.out.println("waitForControlVisible locator "+emailInput);
		myAccountPage = homePage.getMyAccountPage(driver);
		myAccountPage.clickToDynamicButton(driver, "Create an Account");
		registerPage = PageFactoryManager.openRegiterPage(driver);
		registerPage.sendKeyToDynamicTextBox(driver, "viet", "firstname");
		registerPage.sendKeyToDynamicTextBox(driver, "Quoc", "middlename");
		registerPage.sendKeyToDynamicTextBox(driver, "LE", "lastname");
		registerPage.sendKeyToDynamicTextBox(driver, emailInput, "email");
		registerPage.sendKeyToDynamicTextBox(driver, "123123", "password");
		registerPage.sendKeyToDynamicTextBox(driver, "123123", "confirmation");
	    registerPage.clickToDynamicButton(driver, "Register");
		myDashboardPage = PageFactoryManager.getMyDashboardPage(driver);
		homePage = (HomePageObject) myDashboardPage.getDynamicPageFromHeaderAccount(driver, "Log Out");
		homePage =PageFactoryManager.openHomePageObject(driver);
		
	}

	@Test
	public void TC_02_Login() {
		 myAccountPage = homePage.getMyAccountPage(driver);
		 myAccountPage.sendKeyToDynamicTextBox(driver, emailInput, "login[username]");
		 myAccountPage.sendKeyToDynamicTextBox(driver, "123123", "login[password]");
		 myAccountPage.clickToDynamicButton(driver, "Login");
			}

	@Test
	public void TC_03_verifyProductInfoMobile() {
		mobilePage= (MobilePageObject) myAccountPage.getDynamicFromCommonLink(driver, "Mobile");
		mobilePage.isDynamicProductImageDisplayed(driver, "Xperia");
		mobilePage.isDynamicProductNameDisplayed(driver, "Sony Xperia");
		mobilePage.isDynamicProductPriceDisplayed(driver, "Sony Xperia", "$100.00");
		mobilePage.isDynamicProductAddToCartButtonDisplayed(driver, "Sony Xperia");
	}
	@Test
	public void TC_04_verifyProductInfoTV() {
		mobilePage= (MobilePageObject) myAccountPage.getDynamicFromCommonLink(driver, "TV");
		mobilePage.isDynamicProductImageDisplayed(driver, "Samsung LCD");
		mobilePage.isDynamicProductNameDisplayed(driver, "Samsung LCD");
		mobilePage.isDynamicProductPriceDisplayed(driver, "Samsung LCD", "$700.00");
		mobilePage.isDynamicProductAddToCartButtonDisplayed(driver, "Samsung LCD");
	}
	@AfterClass
	public void afterClass() {
		driver.quit();

	}

}