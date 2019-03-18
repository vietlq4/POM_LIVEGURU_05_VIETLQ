package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commons.AbstracPage;
import interfaces.pagesUI.HomePageUI;


public class HomePageObject extends AbstracPage {
	WebDriver driver;
	public HomePageObject(WebDriver mappingdriver) {
		driver= mappingdriver;
	}
	

}
