package interfaces.pagesUI;

public class AbstractPageUI {
	public static final String DYNAMIC_FOTTER_LINK= "//div[@class='footer']//a[text()='%s']";
	public static final String DYNAMIC_COMMON_LINK= "//a[text()='%s']";
	public static final String DYNAMIC_BUTTON= "//*[@class='button' and @title='%s']";
	public static final String DYNAMIC_TEXTBOX = "//input[@name='%s']";
	public static final String DYNAMIC_HEADER_ACCOUNT= "//div[@id='header-account']//a[@title='%s']";
	public static final String DYNAMIC_LABEL= "//span[@class='label' and text()='%s']";
	public static final String DYNAMIC_LINK_ON_SIDEBAR= "//div[@class='col-left sidebar col-left-first']//span[text()='%s']";
	public static final String DYNAMIC_PRODUCT_IMAGE= "//a[@title='%s']/img";
	public static final String DYNAMIC_PRODUCT_NAME= "//h2[@class='product-name']/a[@title='%s']";
	public static final String DYNAMIC_PRODUCT_PRICE= "//h2[@class='product-name']/a[@title='%s']/parent::h2/following-sibling::div[@class='price-box']//span[@class='price']" ;
	public static final String DYNAMIC_PRODUCT_ADD_TO_CART_BUTTON ="//h2[@class='product-name']/a[@title='%s']/parent::h2/following-sibling::div[@class='actions']//span[text()='Add to Cart']";
	
}
