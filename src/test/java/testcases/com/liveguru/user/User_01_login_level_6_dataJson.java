package testcases.com.liveguru.user;

import com.fasterxml.jackson.core.io.JsonEOFException;
import commons.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.object.*;
import testData.Account;
import testData.getAccountData;

import java.io.IOException;


public class User_01_login_level_6_dataJson extends AbstractTest {

      
	@Parameters({ "browser", "url","dataAccount" })
	@BeforeClass
	public void beforeClass(String browserName, String url,String dataAccount) throws IOException {
		driver = openMultiBrowser(browserName, url);
		System.out.println("browser : " + driver.toString());
		homePage = PageFactoryManager.openHomePageObject(driver);
        GetAccountData = getAccountData.get(dataAccount);
	}


    @Test
    public void TC_01_Register() {
        log.info("TC_01_Register - Step 01 :Open my account page ");
        myAccountPage = homePage.getMyAccountPage(driver);

        log.info("TC_01_Register - Step 02 :click To Button Create an Account");
        myAccountPage.clickToDynamicButton(driver, "Create an Account");
        registerPage = PageFactoryManager.openRegiterPage(driver);

        log.info("TC_01_Register - Step 03 :sendkey at filed firstname ");
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
		 myAccountPage.sendKeyToDynamicTextBox(driver, GetAccountData.getuserName(), "login[username]");
		 myAccountPage.sendKeyToDynamicTextBox(driver, GetAccountData.getPassword(), "login[password]");
		 myAccountPage.clickToDynamicButton(driver, "Login");
		 myDashboardPage = PageFactoryManager.getMyDashboardPage(driver);
		 Assert.assertTrue( myDashboardPage.isMyDashboardPageDisplayed());
		 
			}

    @Test
    public void TC_03_verifyProductInfoMobile() {

        mobilePage= (MobilePageObject) myDashboardPage.getDynamicFromCommonLink(driver, "Mobile");
        mobilePage = PageFactoryManager.getMobilePage(driver);
        verifyTrue( mobilePage.isDynamicProductImageDisplayed(driver, "Xperia"));
        verifyTrue(mobilePage.isDynamicProductNameDisplayed(driver, GetAccountData.getname()));
        verifyTrue(mobilePage.isDynamicProductPriceDisplayed(driver, GetAccountData.getname(), GetAccountData.getPrice()));
        verifyTrue(mobilePage.isDynamicProductAddToCartButtonDisplayed(driver, GetAccountData.getname()));
    }
	@AfterClass
	public void afterClass() {
		driver.quit();

	}
	WebDriver driver;
	WebDriverWait wait;

	private HomePageObject homePage;
	private RegiterPageObject registerPage;
	private MobilePageObject mobilePage;
	private MyAccountObject myAccountPage;
	private MyDashboardPage myDashboardPage;
	private getAccountData GetAccountData;

	String emailInput = "LE" + randomNumber() + "@hello.com";


}