package Suite3_Search;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Data.LoginData;
import Data.ReadExel;
import Suite1_RegistrationAndAuthentication.PageTerminalXLoginObjectModel;
import io.qameta.allure.Description;
import utils.SingletonWD;

public class Page_6_TerminalXSearchTest {
	
	WebDriver driver;
	WebDriverWait wait;
	pageTerminalXSearchObjectModel pomSearch;
	ReadExel readExel;
	List<String> lst=new ArrayList<String>();
	
	@BeforeClass
	public void setUp()
	{
		driver=SingletonWD.getTheDriver(2);
		wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		pomSearch=new pageTerminalXSearchObjectModel(driver,wait);
		pomSearch.setUp();
		readExel=new ReadExel();
		readExel.readExcelFile2(lst, "data_Regisration.xlsx");
	}
	@Description("checkIfAllTheResultsContainTheTermSearch")
	@Test(description="checkIfAllTheResultsContainTheTermSearch")
	public void testcase1()
	{
		Assert.assertEquals(pomSearch.checkIfAllTheResultsContainTheTermSearch("React Infinity Run"),true);
	}
	@Description("ChekLowestToHighesPricesButton")
	@Test(description="ChekLowestToHighesPricesButton")
	public void testcase2()
	{
		Assert.assertEquals(pomSearch.ChekLowestToHighesPricesButton(),true);

	}
	@Description("ChekHighesToLowestPricesButton")
	@Test(description="ChekHighesToLowestPricesButton")
	public void testcase3()
	{
		Assert.assertEquals(pomSearch.ChekHighesToLowestPricesButton(),true);
    }
}
