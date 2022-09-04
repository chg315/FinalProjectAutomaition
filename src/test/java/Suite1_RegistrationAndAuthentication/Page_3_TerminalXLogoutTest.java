package Suite1_RegistrationAndAuthentication;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import utils.SingletonWD;

public class Page_3_TerminalXLogoutTest {
	WebDriver driver;
	WebDriverWait wait;
	pageTerminalXLogoutObjectModel pomLogout;
	
	@BeforeClass
	public void setUp()
	{
	driver=SingletonWD.getTheDriver(2);
	wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	pomLogout=new pageTerminalXLogoutObjectModel(driver, wait);
	}
    @Description("checkLogoutButton")
	@Test
	public void testcase1()
	{
		Assert.assertEquals(pomLogout.checkLogoutButton(),true);
	}


}