package Suite1_RegistrationAndAuthentication;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hpsf.Array;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Data.ReadExel;
import Data.RegistrationData;
import io.qameta.allure.Description;
import utils.SingletonWD;

public class Page_1_TerminalXRegistrationTest { 
	
	WebDriver driver;
	WebDriverWait wait;
	PageTerminalXRegistrationObjectModel pomRegisEbay;
	ReadExel readExel;
	List<RegistrationData> lst=new ArrayList<RegistrationData>();
	
	@BeforeClass
	public void setUp()
	{
		driver=SingletonWD.getTheDriver(2);
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		pomRegisEbay=new PageTerminalXRegistrationObjectModel(driver, wait);	
		readExel=new ReadExel();
		readExel.readExcelFile(lst,"data_Regisration.xlsx");
		pomRegisEbay.goToPage();
	}
    @Description("checkInputFirstName_IfEmpty")
	@Test(priority=1 ,description="checkInputFirstName_IfEmpty")
	public void testcase1(){
		Assert.assertEquals(pomRegisEbay.checkInputFirstName_IfEmpty(lst.get(0)),true);
	}
    
    @Description("checkInputLasttName_IfEmpty")
	@Test(priority=2 ,description="checkInputLasttName_IfEmpty")
	public void testcase2(){
		Assert.assertEquals(pomRegisEbay.checkInputLasttName_IfEmpty(lst.get(1)),true);
	}
    
    @Description("checkInputNumberPhone_IfNotCorect")
	@Test(priority=3 ,description="checkInputNumberPhone_IfNotCorect")
	public void testcase3(){
		Assert.assertEquals(pomRegisEbay.checkInputNumberPhone_IfNotCorect(lst.get(2)),true);
	}
	
    @Description("checkInputNumberPhone_IfEmpty")
	@Test(priority=4 ,description="checkInputNumberPhone_IfEmpty")
	public void testcase4()
	{
		Assert.assertEquals(pomRegisEbay.checkInputNumberPhone_IfEmpty(lst.get(3)),true);
	}
    
    @Description("checkInputEmail_IfNotCorect")
	@Test(priority=5 ,description="checkInputEmail_IfNotCorect")
	public void testcase5(){
    	Assert.assertEquals(pomRegisEbay.checkInputEmail_IfNotCorect(lst.get(4)),true);
	}
    
    @Description("checkInputEmail_IfEmpty")
	@Test(priority=6 ,description="checkInputEmail_IfEmpty")
	public void testcase6(){
		Assert.assertEquals(pomRegisEbay.checkInputEmail_IfEmpty(lst.get(5)),true);
	}
    
    @Description("checkInputPassword_IfEmpty")
	@Test(priority=7 ,description="checkInputPassword_IfEmpty")
	public void testcase7(){
		Assert.assertEquals(pomRegisEbay.checkInputPassword_IfEmpty(lst.get(6)),true);
	}
    
    @Description("checkInputConfirmPassword_IfEmpty")
	@Test(priority=8 ,description="checkInputConfirmPassword_IfEmpty")
    void testcase8(){
		Assert.assertEquals(pomRegisEbay.checkInputConfirmPassword_IfEmpty(lst.get(7)),true);
	}
    
    @Description("checkInputConfirmPassword_IfEmpty")
	@Test(priority=9 ,description="checkInputConfirmPassword_IfEmpty")
	public void testcase9(){
		Assert.assertEquals(pomRegisEbay.checkInputConfirmPassword_IfEmpty(lst.get(8)),true);
	}
    
    @Description("checkInputPassword_unless8letters")
	@Test(priority=10 ,description="checkInputPassword_unless8letters")
	public void testcase10(){
		Assert.assertEquals(pomRegisEbay.checkInputPassword_unless8letters(lst.get(9)),true);
	}
	
	
    @Description("checkInputPassword_withoutLowerCaseLetter")
	@Test(priority=11 ,description="checkInputPassword_withoutLowerCaseLetter")
	public void testcase11(){
		Assert.assertEquals(pomRegisEbay.checkInputPassword_withoutLowerCaseLetter(lst.get(10)),true);
	}
	
    @Description("checkInputPassword_withoutCapitalLetter")
	@Test(priority=12 ,description="checkInputPassword_withoutCapitalLetter")
	public void testcase12(){
		Assert.assertEquals(pomRegisEbay.checkInputPassword_withoutCapitalLetter(lst.get(11)),true);
	}
	
    @Description("checkInputPassword_withoutspecialChar")
	@Test(priority=13 ,description="checkInputPassword_withoutspecialChar")
	public void testcase13(){
		Assert.assertEquals(pomRegisEbay.checkInputPassword_withoutspecialChar(lst.get(12)),true);
	}
    
    @Description("checkAllCorrect")
	@Test(priority=14 ,description="checkAllCorrect")
	public void testcase14(){
		pomRegisEbay.checkAllCorrect(lst.get(13));
	}
} 
