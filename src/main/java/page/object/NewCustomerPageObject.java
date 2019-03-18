package page.object;

import org.openqa.selenium.WebDriver;
import commons.AbstracPage;
import interfaces.pagesUI.NewCustomerPageUI;

public class NewCustomerPageObject extends AbstracPage {
	WebDriver driver;
	public NewCustomerPageObject(WebDriver mappingdriver) {
		driver= mappingdriver;
	}
   public WithDrawPageObject openWithDrawPage() {
	   waitForControlVisible(driver, NewCustomerPageUI.WITHDRAW_LINK);
	   clickToElement(driver,NewCustomerPageUI.WITHDRAW_LINK);
	   return PageFactoryManager.openWithDrawPage(driver);
   }
}
