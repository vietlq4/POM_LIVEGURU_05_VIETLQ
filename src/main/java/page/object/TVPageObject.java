package page.object;

import org.openqa.selenium.WebDriver;
import commons.AbstracPage;


public class TVPageObject extends AbstracPage {
	WebDriver driver;
	public TVPageObject(WebDriver mappingdriver) {
		driver= mappingdriver;
	}
	

}
