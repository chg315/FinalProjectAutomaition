package Suite3_Search;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Data.ReadExel;
import io.qameta.allure.Description;
import utils.SingletonWD;

public class Page_5_TerminalXFilterTest {
	WebDriver driver;
	WebDriverWait wait;
	pageTerminalXFilterObjectModel pomFilter;

	
	@BeforeClass
	public void setUp()
	{
		driver=SingletonWD.getTheDriver(2);
		wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		pomFilter=new pageTerminalXFilterObjectModel(driver,wait);
		pomFilter.setUp();
		
	}
	@Description("checkIfFilterSale_TenPercent")
	@Test()
	public void testcase1()
	{
		Assert.assertEquals(pomFilter.checkIfFilterSale_FiftyPercent(),true);
	}
	@Description("checkIfFilterSale_TwoIinAhundredt")
	@Test
	public void testcase2()
	{
		Assert.assertEquals(pomFilter.checkIfFilterSale_TwoIinAhundredt(),true);
	}
	@Description("checkIfFilterSale_TenPercent")
	@Test
	public void testcase3()
	{
		Assert.assertEquals(pomFilter.checkIfFilterSale_TenPercent(),true);
	}
	@Description("checkIfFilterBrand_ADIDAS")
	@Test
	public void testcase4()
	{
		Assert.assertEquals(pomFilter.checkIfFilterBrand_ADIDAS(),true);
	}
	@Description("checkIfFilterBrand_byForFox")
	@Test
	public void testcase5()
	{
		Assert.assertEquals(pomFilter.checkIfFilterBrand_byForFox(),true);
	}
	@Description("checkIfFilterBrand_byForGap")
	@Test
	public void testcase6()
	{
		Assert.assertEquals(pomFilter.checkIfFilterBrand_byForGap(),true);
	}
	
	
}
