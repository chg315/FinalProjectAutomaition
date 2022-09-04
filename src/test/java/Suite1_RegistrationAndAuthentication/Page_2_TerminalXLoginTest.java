package Suite1_RegistrationAndAuthentication;

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
import Data.RegistrationData;
import io.qameta.allure.Description;
import utils.SingletonWD;

public class Page_2_TerminalXLoginTest {
	WebDriver driver;
	WebDriverWait wait;
	PageTerminalXLoginObjectModel pomLogin;
	ReadExel readExel;
	List<LoginData> lst=new ArrayList<LoginData>();
	
	@BeforeClass
	public void setUp()
	{
		driver=SingletonWD.getTheDriver(2);
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		pomLogin=new PageTerminalXLoginObjectModel(driver, wait);
		readExel=new ReadExel();
		readExel.readExcelFile1(lst,"data_Regisration.xlsx");
		pomLogin.goToPage();
	}
    @Description("checkInputPassword_withoutPassword")
	@Test
	public void testcase1()
	{
		Assert.assertEquals(pomLogin.checkInputPassword_withoutPassword(lst.get(0)),true);
		
	}
    @Description("checkInputPassword_passwordNotCorrect")
	@Test
	public void testcase2()
	{
		Assert.assertEquals(pomLogin.checkInputPassword_passwordNotCorrect(lst.get(1)),true);
	}
    @Description("checkInputMail_withoutMail")
	@Test
	public void testcase3()
	{
		Assert.assertEquals(pomLogin.checkInputMail_withoutMail(lst.get(2)),true);
	}
    @Description("checkInputMail_mailNotcorrect")
	@Test
	public void testcase4()
	{
		Assert.assertEquals(pomLogin.checkInputMail_mailNotcorrect(lst.get(3)),true);

	}
    @Description("checkInputMail_mailIncorrect2")
	@Test
	public void testcase5()
	{
		Assert.assertEquals(pomLogin.checkInputMail_mailIncorrect2(lst.get(4)),true);

	}
    @Description("allCorrect")
	@Test
	public void testcase6()
	{
		Assert.assertEquals(pomLogin.allCorrect(lst.get(5)),true);

	}
}
