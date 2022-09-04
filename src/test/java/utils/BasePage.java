package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public BasePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		driver.manage().window().maximize();
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}
	public void takeScreenShot(String filePathStr, String nameForTheImageFile, WebDriver driver)
	{
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {

			FileUtils.copyFile(file, new File(filePathStr + "/" + nameForTheImageFile + "_1" + ".png"));

		} catch (IOException e1) {

			// TODO Auto-generated catch block

			e1.printStackTrace();

		}
	}
	
	public void waitUntilVisibilityElemntLocated(By locator)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void waitUntilvisibilityOfAllElementsLocatedBy(By locator)
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	public void waitUntilelementToBeClickable(By locator)
	{
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	public void waitNumberOfElementsToBeLessThan(By locator,int nunber)
	{
		wait.until(ExpectedConditions.numberOfElementsToBeLessThan(locator,nunber));
	}
	public void waitnumberOfElementsToBeMoreThan(By locator,int nunber)
	{
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator,nunber));
	}
	public void waitTextToBe(By locator,String s)
	{
		wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator,s)));
	}
	public void waitToUrl()
	{
		wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(driver.getCurrentUrl())));

	}
	public double numberFromString(String str)
	{
		String theDigits = str.replaceAll("[^0-9?!\\.]", "");
		//System.out.println(theDigits);
		return Double.parseDouble(theDigits);
	} 
	public WebElement findElemnt(By locator)
	{
		return driver.findElement(locator);
	}
	
	public List<WebElement> findElemnts(By locator)
	{
		return driver.findElements(locator);
	}
	
	public String getText(WebElement elemnt)
	{
		return elemnt.getText();
	}
	
	public String getText(By locator)
	{
		return driver.findElement(locator).getText();
	}
	
	public String getAttribute(By locator,String att)
	{
		return driver.findElement(locator).getAttribute(att);
	}
	public void typeInto(String inputText,By locator)
	{
		System.out.println(inputText);
		findElemnt(locator).sendKeys(inputText);
		//return findElemnt(locator);
	}
	
	public void click(By locator)
	{
		findElemnt(locator).click();
		//System.out.println("base");
	}
	public void refresh()
	{
		driver.navigate().refresh();
	}
	

	
	public boolean isDisplayed(By locator)
	{
		try {
			return driver.findElement(locator).isDisplayed();
		}
		catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public void selectFromDropDownListByValue(By locator, String value)
	{
		Select select = new Select(driver.findElement(locator));
		select.selectByValue(value);
	}
	
	public void selectFromDropDownListByVisableText(By locator, String text)
	{
		Select select = new Select(driver.findElement(locator));
		select.selectByVisibleText(text);
	}
	
	public void selectFromDropDownListByIndex(By locator, int index)
	{
		Select select = new Select(driver.findElement(locator));
		select.selectByIndex(index);
	}

	public void visit(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	}
}
