package Suite1_RegistrationAndAuthentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Data.LoginData;
import utils.BasePage;


public class PageTerminalXLoginObjectModel extends BasePage {

	public PageTerminalXLoginObjectModel(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}
	
   
	By byForIntputMail;
	By byForIntputPassword;
	By byForSubmitButton;
	By byForInputMailErr;
	By byForIntputPasswordErr;
	By byForTextErr;
	By byForDetails;
	
	void initBys()
	{
		byForInputMailErr=By.cssSelector("[data-test-id=\"qa-login-email-error\"]");
		byForIntputMail=By.cssSelector("[class=\"login-input-wrapper_2hYV\"] [name=\"email\"]");
		byForIntputPassword=By.cssSelector("[class=\"login-input_6Yxm\"] [name=\"password\"]");
		byForIntputPasswordErr=By.cssSelector("[class=\"tx-input-error_3aAS rtl_1fsK\"]");
		byForSubmitButton=By.cssSelector("[data-test-id=\"qa-login-submit\"]");
		byForDetails=By.cssSelector("[class=\"title_21Ju\"]");
	}
	
	public void goToPage()
	{

		getDriver().get("https://www.terminalx.com/customer/account/login?r=%2Fcustomer%2Faccount");
		try {
			waitToUrl();
		} catch (Exception e) {
			// TODO: handle exception
		}
		initBys();
	}
	public void enterInputs(LoginData loginData )
	{
		waitUntilVisibilityElemntLocated(byForIntputMail);
		typeInto(loginData.getEmail(), byForIntputMail);
		typeInto(loginData.getPassword(), byForIntputPassword);
		click(byForSubmitButton);
	}
	
	public boolean checkInputPassword_withoutPassword(LoginData loginData)
	{
		refresh();
		enterInputs(loginData);
		takeScreenShot("screenshots/RegistrationAndAuthentication", "loginP_checkInputPassword_withoutPassword", getDriver());
		return loginData.getStringErr().equals(getText(byForIntputPasswordErr));
	}
	public boolean checkInputPassword_passwordNotCorrect(LoginData loginData)
	{
		refresh();
		enterInputs(loginData);
		takeScreenShot("screenshots/RegistrationAndAuthentication", "loginP_checkInputPassword_passwordNotCorrect", getDriver());
		return getText(byForIntputPassword).equals("")&&getText(byForIntputMail).equals("");

	
	}
	public boolean checkInputMail_withoutMail(LoginData loginData)
	{
		refresh();
		enterInputs(loginData);
		takeScreenShot("screenshots/RegistrationAndAuthentication", "loginP_checkInputMail_withoutMail", getDriver());
		return loginData.getStringErr().equals(getText(byForInputMailErr));
	
	}
	public boolean checkInputMail_mailNotcorrect(LoginData loginData)
	{
		refresh();
		enterInputs(loginData);
		takeScreenShot("screenshots/RegistrationAndAuthentication", "loginP_checkInputMail_mailNotcorrect", getDriver());
		return loginData.getStringErr().equals(getText(byForInputMailErr));
	}
	
	public boolean checkInputMail_mailIncorrect2(LoginData loginData)
	{
		refresh();
		enterInputs(loginData);
		takeScreenShot("screenshots/RegistrationAndAuthentication", "loginP_checkInputMail_mailIncorrect2", getDriver());
		return getText(byForIntputPassword).equals("")&&getText(byForIntputMail).equals("");
	}
	
	public boolean allCorrect(LoginData loginData)
	{
		refresh();
		enterInputs(loginData);
		waitUntilVisibilityElemntLocated(byForDetails);
		takeScreenShot("screenshots/RegistrationAndAuthentication", "loginP_allCorrect", getDriver());
		return getText(byForDetails).equals(loginData.getStringErr());
	}

}
