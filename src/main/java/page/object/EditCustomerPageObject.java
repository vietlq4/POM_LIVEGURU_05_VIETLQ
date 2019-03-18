package page.object;

import org.openqa.selenium.WebDriver;
import commons.AbstracPage;

public class EditCustomerPageObject extends AbstracPage {
	WebDriver driver;
	public EditCustomerPageObject(WebDriver mappingdriver) {
		driver= mappingdriver;
	}

}
