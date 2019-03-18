package page.object;

import org.openqa.selenium.WebDriver;
import commons.AbstracPage;

public class MobilePageObject extends AbstracPage {
	WebDriver driver;
	public MobilePageObject(WebDriver mappingdriver) {
		driver= mappingdriver;
	}

}
