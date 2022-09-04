package Suite3_Search;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BasePage;

public class pageTerminalXFilterObjectModel extends BasePage {

	public pageTerminalXFilterObjectModel(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}
	List<WebElement> lst;
	By byForSaleButton;
	By byForFiftyPercent;
	By byForTenPercent;
	By byForTwoIinAhundred;
	By byForTextSaleInOneItem;
	By byForBrandButton;
	By byForADIDASOriginals;
	By byForFox;
	By byForGap;
	By byForTextBrandInOneItem;
	By byForSiseButton;
	By byForQuickView;
	By byForAllSiseText;
	By byForCloseQuick;
	By byForSize_2;
	By byForSize_NB;
	By byForImgToQuick;

	private void initByes() {
		byForSaleButton=By.cssSelector("li:nth-child(4) [class=\"icon-wrapper_1Tba\"]");
		byForFiftyPercent=By.cssSelector("li:nth-child(1)[class=\"filter-item_wzYv\"] a");
		byForTenPercent=By.cssSelector("li:nth-child(2)[class=\"filter-item_wzYv\"] a");
		byForTwoIinAhundred=By.cssSelector("li:nth-child(5)[class=\"filter-item_wzYv\"] a");
		byForTextSaleInOneItem=By.cssSelector("[class=\"stampa-sales_3ITt rtl_1_TU link_3vu6 tx-link_29YD\"]");
		byForBrandButton=By.cssSelector("li:nth-child(3) [class=\"icon-wrapper_1Tba\"]");
		byForADIDASOriginals=By.cssSelector("li:nth-child(18)[class=\"filter-item_wzYv brand_2f3C\"] a");
		byForFox=By.cssSelector("li:nth-child(5)[class=\"filter-item_wzYv brand_2f3C\"] a");
		byForGap=By.cssSelector("li:nth-child(11)[class=\"filter-item_wzYv brand_2f3C\"] a");
		byForTextBrandInOneItem=By.cssSelector("[class=\"right_1o65\"] span");
		byForSiseButton=By.cssSelector("li:nth-child(1) [class=\"icon-wrapper_1Tba\"]");
		byForSize_2=By.cssSelector("[class=\"filter-items_1wKn\"] li:nth-child(8) a");
		byForSize_NB=By.cssSelector("[class=\"filter-items_1wKn\"] li:nth-child(60)");
		byForImgToQuick=By.cssSelector("[class=\"container_ZFXs link-img_3tjH\"]");
		byForQuickView=By.cssSelector(" [class=\"btn-quick_3Pv7 btn-quick-view_2SXw\"]");;
		byForAllSiseText=By.cssSelector("[data-test-id=\"qa-size-item\"]");
		byForCloseQuick=By.cssSelector("[class=\"swipeable-panel-button-close_25Eb\"]");
		
	}
	public void setUp()
	{
		getDriver().get("https://www.terminalx.com/baby/baby-boys");
		initByes();
	}

     public boolean checkIfFilterSale_FiftyPercent()
     {
    	return checkIfFilterSale(byForFiftyPercent);
    	 
     }
     public boolean checkIfFilterSale_TwoIinAhundredt()
     {
    	return checkIfFilterSale(byForTwoIinAhundred);
    	 
     }
     public boolean checkIfFilterSale_TenPercent()
     {
    	return checkIfFilterSale(byForTenPercent);
     }
     
     
     public boolean checkIfFilterBrand_ADIDAS()
     {
    	return checkIfFilterBrand(byForADIDASOriginals);
    	 
     }
     public boolean checkIfFilterBrand_byForFox()
     {
    	return checkIfFilterBrand(byForFox);
    	 
     }
     public boolean checkIfFilterBrand_byForGap()
     {
    	return checkIfFilterBrand(byForGap);
    	 
     }
     
 //doesn't work all the way
     
     
//     public boolean checkIfFilterSize()
//     {
//    	 int degel=0;
// 		 getDriver().get("https://www.terminalx.com/baby/baby-boys");
// 		 waitUntilVisibilityElemntLocated(byForSiseButton);
// 		 click(byForSiseButton);
// 		 waitUntilVisibilityElemntLocated(byForSize_2);
// 		 click(byForSize_2);
// 		 try {
//			waitToUrl();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
// 		List<WebElement>lstSizes;
// 		List<WebElement>lstImges= findElemnts(byForImgToQuick);
//
// 		for (int i = 1; i < lstImges.size(); i++) {
// 			 Actions act= new Actions(getDriver());
// 			 act.moveToElement(lstImges.get(i-1)).perform();
// 			 byForQuickView=By.cssSelector("li:nth-child("+i+")"+" [class=\"btn-quick_3Pv7 btn-quick-view_2SXw\"]");
// 			 click(byForQuickView);
// 	 		 waitUntilvisibilityOfAllElementsLocatedBy(byForAllSiseText);
// 			 lstSizes= findElemnts(byForAllSiseText);
// 			 for (WebElement elem : lstSizes) {
// 				 System.out.println(getText(elem)+"--------"+getText(byForSize_2));
//				if(getText(elem).equals(getText(byForSize_2)))
//					degel=1;
//			}
// 			click(byForCloseQuick);
//		}
// 		if(degel==1)
// 			return true;
// 		else
// 			return false;
// 					

//     }
     
     
     private boolean checkIfFilterBrand(By locaor)
     {
 		 getDriver().get("https://www.terminalx.com/baby/baby-boys");
 		 waitUntilVisibilityElemntLocated(byForBrandButton);
    	 click(byForBrandButton);
    	 waitUntilelementToBeClickable(locaor);
    	 click(locaor);
    	 try {
    		 waitToUrl();
		} catch (Exception e) {
			// TODO: handle exception
		}   	
    	 takeScreenShot("screenshots\\Search", "checkIfFilterBrand_"+Math.random(), getDriver());
    	 waitUntilvisibilityOfAllElementsLocatedBy(byForTextBrandInOneItem);
    	 lst=findElemnts(byForTextBrandInOneItem);
    	 System.out.println(lst.size());

    	 for (WebElement webElement : lst) {
    		 System.out.println(getText(webElement));
    		 System.out.println(getText(locaor));

			if(!getText(locaor).equals(getText(webElement)))
			{
				 return false;
			}
		}
    	 return true; 
     }
     
     
     private boolean checkIfFilterSale(By locaor)
     {
 		 getDriver().get("https://www.terminalx.com/baby/baby-boys");
 		 waitUntilVisibilityElemntLocated(byForSaleButton);
    	 click(byForSaleButton);
    	 waitUntilelementToBeClickable(locaor);
    	 click(locaor);
    	 waitUntilvisibilityOfAllElementsLocatedBy(byForTextSaleInOneItem);
    	 try {
			waitnumberOfElementsToBeMoreThan(byForTextSaleInOneItem, 20);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	 takeScreenShot("screenshots\\Search", "checkIfFilterSale_"+Math.random(), getDriver());

    	 lst=findElemnts(byForTextSaleInOneItem);
    	 System.out.println(lst.size());

    	 for (WebElement webElement : lst) {
    		 System.out.println(getText(webElement));
    		 System.out.println(getText(byForTextSaleInOneItem));

			if(!getText(locaor).equals(getText(webElement)))
			{
				 return false;
			}
		}
    	 return true; 
     }
    	 
     }


