package page.object;

import org.openqa.selenium.WebDriver;

import commons.AbstracPage;


public class MyAccountObject extends AbstracPage{
WebDriver driver;
public MyAccountObject(WebDriver mappingdriver) {
	driver= mappingdriver;
}
 
}
