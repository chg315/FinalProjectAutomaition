package Suite3_Search;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BasePage;

public class pageTerminalXSearchObjectModel extends BasePage {

	public pageTerminalXSearchObjectModel(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}

	List<WebElement> lst;
	List<WebElement> lstToCheck = new ArrayList<WebElement>();

	By byforSearchButton;
	By byforSearchInput;
	By byforListElments;
	By byForSelecSortField;
	By byForPriceItem;
	By byForOneItem;

	void initByes() {
		byforSearchButton = By.cssSelector("[data-test-id=\"qa-header-search-button\"]");
		byforSearchInput = By.cssSelector("[data-test-id=\"qa-search-box-input\"]");
		byforListElments = By.cssSelector("[class=\"title_3ZxJ tx-link_29YD underline-hover_3GkV\"]");
		byForSelecSortField = By.cssSelector("[name=\"sortField\"]");
		byForPriceItem = By.cssSelector("[class=\"row_2tcG bold_2wBM final-price_8CiX\"]");
		
	}

	public void setUp() {
		getDriver().get("https://www.terminalx.com/");
		initByes();
	}

	public boolean checkIfAllTheResultsContainTheTermSearch(String termSearch) {

		List<WebElement> lst;
		click(byforSearchButton);
		typeInto(termSearch + "\n", byforSearchInput);
		waitUntilvisibilityOfAllElementsLocatedBy(byforListElments);
		lst = findElemnts(byforListElments);
		System.out.println(lst.size());
		int sum = 0;
		for (WebElement elem : lst) {
			System.out.println(getText(elem));
			String s = getText(elem);
			if (!s.contains(termSearch))
				sum++;

		}
		if (sum == 0 || lst.size() - sum >= lst.size() * 0.80)
			return true;
		return false;
	}

	public boolean ChekLowestToHighesPricesButton() {
		WebElement element = findElemnt(byForSelecSortField);
		Select s = new Select(element);
		s.selectByIndex(3);
		waitUntilvisibilityOfAllElementsLocatedBy(byForPriceItem);
		 try {
				waitnumberOfElementsToBeMoreThan(byForPriceItem, 20);
			} catch (Exception e) {
				// TODO: handle exception
			}
		lst = findElemnts(byForPriceItem);
		System.out.println(lst.size());
		double temp = numberFromString(getText(lst.get(lst.size() - 1)));
		System.out.println("temp:" + temp);	
		for (WebElement webElement : lst) {
			if (temp < numberFromString(getText(webElement)))
			   return false;
		}
		return true;
	}
	public boolean ChekHighesToLowestPricesButton() {
		WebElement element = findElemnt(byForSelecSortField);
		Select s = new Select(element);
		s.selectByIndex(4);
		waitUntilvisibilityOfAllElementsLocatedBy(byForPriceItem);
		 try {
				waitnumberOfElementsToBeMoreThan(byForPriceItem, 20);
			} catch (Exception e) {
				// TODO: handle exception
			}
		lst = findElemnts(byForPriceItem);
		System.out.println(lst.size());
		double temp = numberFromString(getText(lst.get(lst.size() - 1)));
		System.out.println("temp:" + temp);	
		for (WebElement webElement : lst) {
			if (temp > numberFromString(getText(webElement)))
			   return false;
		}
		return true;
	}

}
