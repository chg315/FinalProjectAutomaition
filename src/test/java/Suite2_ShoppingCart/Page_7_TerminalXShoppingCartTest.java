package Suite2_ShoppingCart;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import utils.SingletonWD;

public class Page_7_TerminalXShoppingCartTest {
	WebDriver driver;
	WebDriverWait wait;
	pageTerminalXShoppingCartObjectModel cartPom;
	
	@BeforeClass
	public void setUp()
	{
		driver=SingletonWD.getTheDriver(2);
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		cartPom=new pageTerminalXShoppingCartObjectModel(driver, wait);
		
	}
	@Description("testTheProductAddedToCartIsInTheCart")
	@Test(priority =1)
	void tastcase1()
	{
		Assert.assertEquals(cartPom.testTheProductAddedToCartIsInTheCart(),true); 
	}
	@Description("CheckingSumAllPricesEqualsTheAmountPayable")
	@Test(priority =2)
	void tastcase2()
	{
		Assert.assertEquals(cartPom.CheckingSumAllPricesEqualsTheAmountPayable(),true); 
	}
	@Description("checkIfTheNumberOfItemInTheCartMathToNumberOnTheIcon")
	@Test(priority =3)
	void tastcase3()
	{
		Assert.assertEquals(cartPom.checkIfTheNumberOfItemInTheCartMathToNumberOnTheIcon(),true); 
	}
	@Description("checkIfRemoveItemFromACartWork")
	@Test(priority =4)
	void tastcase4()
	{
		Assert.assertEquals(cartPom.checkIfRemoveItemFromACartWork(),true); 
	}
	@Description("CheckingSumAllPricesEqualsTheAmountPayableAfterRemoveOneItem")
	@Test(priority =5)
	void tastcase5()
	{
		Assert.assertEquals(cartPom.CheckingSumAllPricesEqualsTheAmountPayableAfterRemoveOneItem(),true); 
	}
}
