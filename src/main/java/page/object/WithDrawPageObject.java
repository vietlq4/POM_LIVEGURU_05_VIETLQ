package page.object;

import org.openqa.selenium.WebDriver;
import commons.AbstracPage;

public class WithDrawPageObject extends AbstracPage {
	WebDriver driver;
	public WithDrawPageObject(WebDriver mappingdriver) {
		driver= mappingdriver;
	}

}
