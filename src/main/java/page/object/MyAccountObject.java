package page.object;

import org.openqa.selenium.WebDriver;

import commons.AbstracPage;
import interfaces.pagesUI.LoginPageUI;

public class MyAccountObject extends AbstracPage{
WebDriver driver;
public MyAccountObject(WebDriver mappingdriver) {
	driver= mappingdriver;
}
 
}
