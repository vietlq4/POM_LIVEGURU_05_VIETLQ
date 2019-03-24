package testcases.com.liveguru.user;

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
import page.object.RegiterPageObject;
import page.object.WithDrawPageObject;

public class User_01_login_level_3_ApplyAbstracTest extends AbstractTest {
	WebDriver driver;
	WebDriverWait wait;
	private String userID, password, loginPageUrl, Emailadress;
	private AbstracPage abstracPage;
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
		loginPage = new LoginPageObject(driver);
		// registerPage = new RegiterPageObject();
	}

	@Test
	public void TC_01_Register() {

		loginPageUrl = loginPage.getLoginPageUrl();
//  	  //Click here link to open Register Page
		loginPage.clickHereLinkToOpenRegisterPage();
//  	  //input random email
		registerPage = new RegiterPageObject(driver);
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
		registerPage.openLoginPage(loginPageUrl);
		loginPage = new LoginPageObject(driver); // nhan lai driver
		loginPage.inputUserNameTextbox(userID);
		loginPage.inputPassWorkTextbox(password);
		loginPage.clickLoginButton();
		homePage = new HomePageObject(driver);
	Assert.assertTrue(homePage.isHomePageDisplayed());
	}
	@Test
	public void TC_03_OpenMutiPage() {
		//home page => new customer page
		homePage.openNewCustomerPage();
		newCustomerPage = new NewCustomerPageObject(driver);
		//newCustomerPage => wwithdraw
		newCustomerPage.openWithDrawPage();
		withDrawPage = new WithDrawPageObject(driver);
	}
	@AfterClass
	public void afterClass() {
		driver.quit();

	}

}