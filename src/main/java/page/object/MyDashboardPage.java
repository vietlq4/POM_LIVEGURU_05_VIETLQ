package page.object;

import org.openqa.selenium.WebDriver;
import commons.AbstracPage;
import pages.ui.MyDashboardPageUI;

public class MyDashboardPage extends AbstracPage {
	WebDriver driver;
	public MyDashboardPage(WebDriver mappingdriver) {
		driver= mappingdriver;
	}
public boolean isMyDashboardPageDisplayed() {
	
	waitForControlVisible(driver,MyDashboardPageUI.MY_DASH_BOARD_LABEL);
	return isControlDisplayed(driver,MyDashboardPageUI.MY_DASH_BOARD_LABEL);
}
}
