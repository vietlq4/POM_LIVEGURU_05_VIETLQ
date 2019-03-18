package testcases.com.bankguru.user;

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
import page.object.NewCustomerPageObject;
import page.object.PageFactoryManager;
import page.object.RegiterPageObject;
import page.object.WithDrawPageObject;

public class User_01_login_level_4_ApplyOOP extends AbstractTest {
	WebDriver driver;
	WebDriverWait wait;
	private String userID, password, loginPageUrl, Emailadress;
	// khai bao login page
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegiterPageObject registerPage;
	private DeleteAccountPageObject deleteAccountPage;
	private WithDrawPageObject withDrawPage;
	private NewCustomerPageObject newCustomerPage ;
	// private RegiterPageObject registerPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		//driver tu open multi browser 
		driver = openMultiBrowser(browserName, url);
		// khoi tao
		loginPage = PageFactoryManager.openLoginPage(driver);
		
	}

	@Test
	public void TC_01_Register() {

		loginPageUrl = loginPage.getLoginPageUrl();
//  	  //Click here link to open Register Page
		registerPage  = loginPage.clickHereLinkToOpenRegisterPage();
//  	  //input random email
		registerPage.inputEmailID();
//  	  //click button signin 
		registerPage.clickToSubmitButton();
//  	  //Get text of User and pass
		userID = registerPage.getUserID();
		password = registerPage.getPassword();
//    	
	}

	@Test
	public void TC_02_Login() {
		loginPage = registerPage.openLoginPage(loginPageUrl);
		loginPage.inputUserNameTextbox(userID);
		loginPage.inputPassWorkTextbox(password);
		loginPage.clickLoginButton();
		homePage = new HomePageObject(driver);
	Assert.assertTrue(homePage.isHomePageDisplayed());
	}
	@Test
	public void TC_03_OpenMutiPage() {
		//home page => new customer page
		newCustomerPage = homePage.openNewCustomerPage();
		//newCustomerPage => withdraw
		withDrawPage = newCustomerPage.openWithDrawPage();
		//withDrawPage.
	}
	@AfterClass
	public void afterClass() {
		driver.quit();

	}

}