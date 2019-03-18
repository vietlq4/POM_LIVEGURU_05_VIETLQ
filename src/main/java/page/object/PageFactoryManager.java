package page.object;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

	public static  LoginPageObject openLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);

	}

	public static  DeleteAccountPageObject openDeleteAccountPage(WebDriver driver) {
		return new DeleteAccountPageObject(driver);
	}

	public static  EditCustomerPageObject openEditCustomerPage(WebDriver driver) {
		return new EditCustomerPageObject(driver);
	}

	public static  HomePageObject openHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static  NewCustomerPageObject openNewCustomerPage(WebDriver driver) {
		return new NewCustomerPageObject(driver);

	}
	public static  RegiterPageObject openRegiterPage(WebDriver driver) {
		return new RegiterPageObject(driver);

	}
	public static  WithDrawPageObject openWithDrawPage(WebDriver driver) {
		return new WithDrawPageObject(driver);

	}
	public static  MyAccountObject getMyAccountPage(WebDriver driver) {
		return new MyAccountObject(driver);
	}
	public static  MyDashboardPage getMyDashboardPage(WebDriver driver) {
		return new MyDashboardPage(driver);
	}
	public static  MobilePageObject getMobilePage(WebDriver driver) {
		return new MobilePageObject(driver);
	}
	public static  TVPageObject getTVPage(WebDriver driver) {
		return new TVPageObject(driver);
	}
}
