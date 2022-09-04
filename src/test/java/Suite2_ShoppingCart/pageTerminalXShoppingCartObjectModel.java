package Suite2_ShoppingCart;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;

import org.apache.commons.compress.archivers.sevenz.CLI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.CharMatcher;

import utils.BasePage;

public class pageTerminalXShoppingCartObjectModel extends BasePage {

	public pageTerminalXShoppingCartObjectModel(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub

	}
	List<WebElement> itemsInCart;
	double sum=0;
	String sumString;
	By byForBabyButton;
	By byForBabyGirllButton;
	By byForOneItemButton;
	By byForSizeButton;
	By byForAddToCartButton;
	By byForCartButton;
	By byForCartButtonInner;
	By byForNameItem;
	By byForNameItemInTheCart;
	By byForHomePage;
	By byForItem1;
	By byForItem2;
	By byForItem3;
	By byForSalePage;
	By byForAllPrice;
	By byForSumPrices;
	By byForNumberInCartIcon;
	By byForRemoveItem;
	By byForErrorSize;
	
	
	void initByes() {
		byForBabyButton = By.cssSelector("[class=\"item_1lit\"] [href=\"/baby\"]");
		byForBabyGirllButton = By.cssSelector("[class=\"banner_1ql0\"] [href=\"/baby/baby-girls\"]");
		byForOneItemButton = By.cssSelector("[class=\"listing-product_3mjp\"]:nth-child(2) a");
		byForSizeButton=By.cssSelector("[class=\"size_1bXM\"] [data-test-id=\"qa-size-item\"]:nth-child(1)");
		byForNameItem=By.cssSelector("[data-test-id=\"qa-pdp-name\"]");
		byForAddToCartButton=By.cssSelector("[data-test-id=\"qa-add-to-cart-button\"]");
		byForCartButton=By.cssSelector("[data-test-id=\"qa-link-minicart\"]");
		byForNameItemInTheCart=By.cssSelector("[class=\"brand-name_1FwF\"] a");
		byForHomePage=By.cssSelector("[href=\"/\"]");
		byForSalePage=By.cssSelector("[class=\"item_1lit\"] [href=\"/on-sale\"]");
		byForItem1=By.cssSelector("[class=\"listing-product_3mjp\"]:nth-child(8) a");
		byForItem2=By.cssSelector("[class=\"listing-product_3mjp\"]:nth-child(2) a");
		byForItem3=By.cssSelector("[class=\"listing-product_3mjp\"]:nth-child(3) a");
		byForAllPrice=By.cssSelector("[class=\"row_2tcG bold_2wBM price-final_13zw\"]");
		byForSumPrices=By.cssSelector("[data-test-id=\"qa-order-totals-total-order\"]");
		byForCartButtonInner=By.cssSelector("[data-test-id=\"qa-minicart-cart-button\"]");
		byForNumberInCartIcon=By.cssSelector("[class=\"item-count_3Yeu\"]");
		byForRemoveItem=By.cssSelector("[class=\"icon_u36n remove_wqPe tx-link_29YD\"]");
		byForErrorSize=By.cssSelector("[class=\"error-text_lEFf\"]");


	}


	public boolean testTheProductAddedToCartIsInTheCart() {
		getDriver().get("https://www.terminalx.com/");
		initByes();
		waitUntilelementToBeClickable(byForBabyButton);
	    click(byForBabyButton);
		waitUntilVisibilityElemntLocated(byForBabyGirllButton);
	    waitUntilelementToBeClickable(byForBabyGirllButton);
	    click(byForBabyGirllButton);
	    enterItemToCart(byForOneItemButton);
		String namaItem=getText(byForNameItem);
		click(byForCartButton);
		waitUntilelementToBeClickable(byForCartButtonInner);
		click(byForCartButtonInner);
		waitUntilVisibilityElemntLocated(byForNameItemInTheCart);
		System.out.println(getText(byForNameItemInTheCart));
		System.out.println(namaItem);
		return getText(byForNameItemInTheCart).equals(namaItem);
	}
	
	public boolean CheckingSumAllPricesEqualsTheAmountPayable()
	{
		//go to sale page 
		click(byForSalePage);
		//add tow item to the cart
		enterItemToCart(byForItem1);
		click(byForSalePage);
		enterItemToCart(byForItem2);
		click(byForSalePage);
		enterItemToCart(byForItem3);
		click(byForCartButton);
		waitUntilelementToBeClickable(byForCartButtonInner);
		click(byForCartButtonInner);
	     return	sumAllPricesEqualsTheAmount();
	
	}

	public boolean checkIfTheNumberOfItemInTheCartMathToNumberOnTheIcon()
	{
		click(byForHomePage);
		return Integer.parseInt(getText(byForNumberInCartIcon))==itemsInCart.size();
	}

	public boolean checkIfRemoveItemFromACartWork()
	{
		click(byForCartButton);
		waitUntilelementToBeClickable(byForCartButtonInner);
		click(byForCartButtonInner);
		waitUntilVisibilityElemntLocated(byForRemoveItem);
		String s=getText(byForNameItemInTheCart);
		System.out.println(s);
		click(byForRemoveItem);
        waitNumberOfElementsToBeLessThan(byForRemoveItem,itemsInCart.size());
		itemsInCart=findElemnts(byForNameItemInTheCart);
		System.out.println(itemsInCart.size());
		for (WebElement webElement : itemsInCart) {
			if(getText(webElement).equals(s))
				return false;
		}
		return true;
	}
	public boolean CheckingSumAllPricesEqualsTheAmountPayableAfterRemoveOneItem()
	{
		try {
			waitToUrl();
		} catch (Exception e) {
			// TODO: handle exception
		}
	     waitUntilVisibilityElemntLocated(byForSumPrices);
	     waitTextToBe(byForSumPrices, sumString);
	     return	sumAllPricesEqualsTheAmount();

	}
	private void enterItemToCart(By locator)
	{
		waitUntilVisibilityElemntLocated(locator);
		waitUntilelementToBeClickable(locator);
		click(locator);	
		try {
			waitUntilVisibilityElemntLocated(byForSizeButton);
			waitUntilelementToBeClickable(byForSizeButton);
			click(byForSizeButton);
		} catch (Exception e) {
			// TODO: handle exception
		}

		click(byForAddToCartButton);
	}

    private static final DecimalFormat df = new DecimalFormat("0.00");

	private boolean sumAllPricesEqualsTheAmount()
	{

		sum=0;
		waitUntilvisibilityOfAllElementsLocatedBy(byForAllPrice);
		itemsInCart=findElemnts(byForAllPrice);
		for (WebElement webElement : itemsInCart) {
			sum+=numberFromString(getText(webElement));
		}
		String st=String.format("%.2f", sum);
		sum=Double.parseDouble(st);
	//	sum=Math.round(sum);
		waitUntilVisibilityElemntLocated(byForSumPrices);		
        sumString=getText(byForSumPrices);
        System.out.println("sumString"+getText(byForSumPrices));
		System.out.println("sum:"+sum);
		System.out.println(numberFromString(getText(byForSumPrices)));
	//	System.out.println("sum  ewb:"+Math.round(numberFromString(getText(byForSumPrices))));
		return sum==numberFromString(getText(byForSumPrices))||sum>Math.round(numberFromString(getText(byForSumPrices)))
				&&sum<numberFromString(getText(byForSumPrices))+1||
				sum<numberFromString(getText(byForSumPrices))&&sum>numberFromString(getText(byForSumPrices))-1;
	}
	
	
}
