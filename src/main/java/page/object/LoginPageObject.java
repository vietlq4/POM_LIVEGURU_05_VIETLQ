package page.object;

import org.openqa.selenium.WebDriver;

import commons.AbstracPage;

public class LoginPageObject extends AbstracPage{
WebDriver driver;
public LoginPageObject(WebDriver mappingdriver) {
	driver= mappingdriver;
}
 
}
