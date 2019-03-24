package testcases.com.liveguru.user;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstracPage;
import commons.AbstractTest;
import page.object.LoginPageObject;


public class User_01_login_level_2  extends AbstractTest{
	WebDriver driver;
	WebDriverWait wait;
	private String userID, password, loginPageUrl,Emailadress;
	private AbstracPage abstracPage;
	// khai bao login page
	 private LoginPageObject loginPage;
	// private RegiterPageObject registerPage;
	

@Parameters({"browser","url"})
   @BeforeClass 
  public void beforeClass(String browserName,String url) { 
	driver =openMultiBrowser(browserName, url);
    	// khoi tao
    	loginPage = new LoginPageObject(driver);
    	//registerPage = new RegiterPageObject();
   } 	
@Test
    public void TC_01_Register() {
   
    	  //Get loginpage url
//    	loginPage.getLoginPageUrl();
//  	  //Click here link to open Register Page
//    	loginPage.clickHereLinkToOpenRegisterPage();
//    	/*Wait for email visible */
//    	registerPage.waitForEmailTextboxVisible();
//  	  //input random email
//    	registerPage.inputEmailAdress(Emailadress);
//  	  //click button signin 
//    	registerPage.clickSubmitButton();
//  	  //Get text of User and pass
//    	userID = registerPage.getUserIdText();
//    	password = registerPage.getPasswordText();
//    	
	  }
@Test
    public void TC_02_Login() {
    	loginPage.inputUserNameTextbox("kdsjhjdhsajk");
    	loginPage.inputPassWorkTextbox("dsfdsf");
    	loginPage.clickLoginButton();
        }
    
    
   
     @AfterClass
    public void afterClass() { 
       	driver.quit();
     
    }
     
}