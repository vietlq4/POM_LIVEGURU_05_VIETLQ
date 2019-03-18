package page.object;

import org.openqa.selenium.WebDriver;
import commons.AbstracPage;

public class DeleteAccountPageObject extends AbstracPage {
	WebDriver driver;
	public DeleteAccountPageObject(WebDriver mappingdriver) {
		driver= mappingdriver;
	}

}
