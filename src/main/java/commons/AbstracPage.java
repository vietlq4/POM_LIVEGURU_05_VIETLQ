package commons;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import interfaces.pagesUI.AbstractPageUI;
import page.object.MyAccountObject;
import page.object.PageFactoryManager;

public class AbstracPage {
	private int timeout = 50;
	private WebDriverWait wait;
// ************* Driver  ******************         
	public void openAnyUrl(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void backToPreviousPage(WebDriver driver) {
		driver.navigate().back();

	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	// ************* END Driver ******************
	public void clickToElement(WebDriver driver, String locator) {
		WebElement ele = driver.findElement(By.xpath(locator));
		ele.click();
	}

	public void clickToElement(WebDriver driver, String locator, String... valueDynamic) {
		locator = String.format(locator, (Object[]) valueDynamic);
		WebElement ele = driver.findElement(By.xpath(locator));
		ele.click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		WebElement ele = driver.findElement(By.xpath(locator));
		ele.clear();
		ele.sendKeys(value);
	}

	public void sendkeyToElement(WebDriver driver, String locator, String valueInput, String... valueDynamic) {
		locator = String.format(locator, (Object[]) valueDynamic);
		System.out.println("sendkeyToElement locator " + locator);
		WebElement ele = driver.findElement(By.xpath(locator));
		ele.clear();
		ele.sendKeys(valueInput);
	}

	public void selecItemInDropdown(WebDriver driver, String locator, String item) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(item);
	}

	public void selectCustomDropdownList(WebDriver driver, String locator, String itemsList, String itemvalue) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = driver.findElement(By.xpath(locator));
		((JavascriptExecutor) driver).executeScript("arguments.scrollIntoView(true);", element);
		element.click();
		List<WebElement> allItems = driver.findElements(By.xpath(itemsList));
		wait.until(ExpectedConditions.visibilityOfAllElements(allItems));

		for (WebElement items : allItems) {
			System.out.println("List items : " + items.getText());
			if (items.getText().trim().equals(itemvalue)) {
				// Scroll to item
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", items);
				items.click();
				break;
			}
		}
	}

	public String getFirstItemSelected(WebDriver driver, String locator) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();
	}

	public String getAttribute(WebDriver driver, String locator, String attributeName) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}

	public String getTextElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}
	public String getTextElement(WebDriver driver, String locator,String ...valueDynamic) {
		locator = String.format(locator, (Object[]) valueDynamic);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public int getSizeElement(WebDriver driver, String locator) {
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}

	public void checkToCheckBox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}

	}

//	================ Wait ========================
	public void waitForControlVisible(WebDriver driver, String locator) {
		 wait = new WebDriverWait(driver, timeout);
		 System.out.println("waitForControlVisible locator " + locator);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
   
	public void waitForControlVisible(WebDriver driver, String locator, String... valueDynamic) {
		//locator = String.format(locator, (Object[]) valueDynamic);
		String xpath = String.format(locator, (Object[]) valueDynamic);
		System.out.println("waitForControlVisible locator " + xpath);
		wait = new WebDriverWait(driver, timeout);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
     
	
	// ================Wait end==============
	public boolean isControlUndisplayed(WebDriver driver, String locator) {
		Date date = new Date();
		System.out.println("Started time = " + date.toString());
		overrideGlobalTimeout(driver, shorTimeout);
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		if (elements.size() == 0) {
			date = new Date();
			System.out.println("End time = " + date.toString());
			overrideGlobalTimeout(driver, timeout);
			return true;
		} else {
			date = new Date();
			System.out.println("End time = " + date.toString());
			overrideGlobalTimeout(driver, timeout);
			return false;
		}
	}

	public boolean isControlUndisplayed(WebDriver driver, String locator, String... value) {
		Date date = new Date();
		System.out.println("Started time = " + date.toString());
		overrideGlobalTimeout(driver, shorTimeout);
		locator = String.format(locator, (Object[]) value);
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		if (elements.size() == 0) {
			date = new Date();
			System.out.println("End time = " + date.toString());
			overrideGlobalTimeout(driver, timeout);
			return true;
		} else {
			date = new Date();
			System.out.println("End time = " + date.toString());
			overrideGlobalTimeout(driver, timeout);
			return false;
		}
	}

	public boolean isControlDisplayed(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlDisplayed(WebDriver driver, String locator, String valueDynamic) {
		locator = String.format(locator, valueDynamic);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlDisplayed(WebDriver driver, String locator, String... locatorValues) {
		locator = String.format(locator, (Object[]) locatorValues);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public int randomNumber() {
		Random rand = new Random();
		int n = rand.nextInt(999999) + 1;
		return n;
	}

	public void overrideGlobalTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	private int shorTimeout = 5;

	// ===================== Action Dynamic start =====================
	public void clickToDynamicButton(WebDriver driver, String titleButton) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_BUTTON, titleButton);
		clickToElement(driver, AbstractPageUI.DYNAMIC_BUTTON, titleButton);
	}

	public void sendKeyToDynamicTextBox(WebDriver driver, String inputValue, String titleButton) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, titleButton);
		sendkeyToElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX, inputValue, titleButton);

	}
	public boolean isDynamicProductImageDisplayed(WebDriver driver, String imgName) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PRODUCT_IMAGE, imgName);
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_PRODUCT_IMAGE, imgName);

	}
	public boolean isDynamicProductNameDisplayed(WebDriver driver, String productName) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PRODUCT_NAME, productName);
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_PRODUCT_NAME, productName);

	}
	public boolean isDynamicProductPriceDisplayed(WebDriver driver, String productPrice,String expectPrice) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PRODUCT_PRICE, productPrice);
		String actualPrice= getTextElement(driver, AbstractPageUI.DYNAMIC_PRODUCT_PRICE,productPrice);
		System.out.println("actualPrice"+actualPrice+"************"+"expectPrice"+expectPrice+"******************");
		return expectPrice.trim().equals(actualPrice.trim());
	}
	public boolean isDynamicProductAddToCartButtonDisplayed(WebDriver driver, String productName) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PRODUCT_ADD_TO_CART_BUTTON, productName);
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_PRODUCT_ADD_TO_CART_BUTTON, productName);
	
	}

	// ===================== Action Dynamic END =====================

	// ===================== get page start =====================
//	 public AbstracPage getDynamicPageFromButton(WebDriver driver,String PageName){
//		 waitForControlVisible(driver, AbstractPageUI.DYNAMIC_BUTTON,PageName);
//		 clickToElement(driver, AbstractPageUI.DYNAMIC_BUTTON,PageName);
//		 
//		 return null;
//	 }
	public AbstracPage getDynamicPageFromHeaderAccount(WebDriver driver, String PageName) {
		//waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LABEL, "Account");
		clickToElement(driver, AbstractPageUI.DYNAMIC_LABEL, "Account");
		//waitForControlVisible(driver, AbstractPageUI.DYNAMIC_HEADER_ACCOUNT, PageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_HEADER_ACCOUNT, PageName);
		return null;
	}

	public MyAccountObject getMyAccountPage(WebDriver driver) {
		//waitForControlVisible(driver, AbstractPageUI.DYNAMIC_FOTTER_LINK, "My Account");
		clickToElement(driver, AbstractPageUI.DYNAMIC_FOTTER_LINK, "My Account");
		return PageFactoryManager.getMyAccountPage(driver);
	}

	public AbstracPage getDynamicFromCommonLink(WebDriver driver, String PageName) {
		// at the moment we using DYNAMIC_COMMON_LINK if in the future have any change
		// we can using xpath DYNAMIC_LINK_ON_SIDEBAR
		//waitForControlVisible(driver, AbstractPageUI.DYNAMIC_COMMON_LINK, PageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_COMMON_LINK, PageName);
		switch (PageName) {
		case "Mobile":
			return PageFactoryManager.getMobilePage(driver);
		case "TV":
			return PageFactoryManager.getMobilePage(driver);
		default:
			return PageFactoryManager.openHomePageObject(driver);
		}
	}

	// ===================== get page start =====================

}
