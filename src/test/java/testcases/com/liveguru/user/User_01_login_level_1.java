package testcases.com.liveguru.user;



import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstracPage;

public class User_01_login_level_1 {
	WebDriver driver;
	WebDriverWait wait;
	private String userID, password, loginPageUrl;
	private AbstracPage abstracPage;
	
   @BeforeClass 
  public void beforeClass() {
	   System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\webdriver\\chromedriver.exe");
    	driver = new ChromeDriver();
    	abstracPage = new AbstracPage();
    	abstracPage.openAnyUrl(driver, "http://demo.guru99.com/v4/");
		
	
    	
    }
    @AfterClass
    public void afterclass() {
      	driver.quit();
      }
    @Test
	  public void TC_01_Register() {
    	  //Get loginpage url
  	  loginPageUrl = driver.getCurrentUrl();
  	  //Click here link to open Register Page
  	  abstracPage.clickToElement(driver, "//a[text()='here']");
  	  abstracPage.waitForControlVisible(driver, "//input[@name='emailid']");
  	  
  	  //input random email
  	  abstracPage.sendkeyToElement(driver, "//input[@name='emailid']", "online05"+randomNumber()+"@gmail.com");
  	  //click button signin 
      abstracPage.clickToElement(driver, "//input[@name='btnLogin']");

  	  //Get text of User and pass
  	   userID = abstracPage.getTextElement(driver, "//td[text()='User ID :']/following-sibling::td");
  	   password =abstracPage.getTextElement(driver, "//td[text()='Password :']/following-sibling::td");
  	   
	  }
    @Test
    public void TC_02_Login() {
  	  //Open Loginpage
      abstracPage.openAnyUrl(driver, loginPageUrl);
      abstracPage.waitForControlVisible(driver, "//input[@name='uid']");
  	  
      abstracPage.sendkeyToElement(driver, "//input[@name='uid']", userID);
      abstracPage.sendkeyToElement(driver, "//input[@name='password']", password);
      abstracPage.clickToElement(driver, "//input[@name='btnLogin']");
  	  
  	  Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")).isDisplayed());
    }
    public int randomNumber()
    {
  	  Random rand =new Random();
  	  int n= rand.nextInt(999999)+1;
  	  return n;
    }
     @AfterClass
    public void afterClass() {
    }
}