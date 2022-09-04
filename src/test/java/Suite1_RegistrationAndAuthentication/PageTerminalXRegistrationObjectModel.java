package Suite1_RegistrationAndAuthentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Data.RegistrationData;
import utils.BasePage;

public class PageTerminalXRegistrationObjectModel extends BasePage {

	public PageTerminalXRegistrationObjectModel(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	private By byForFirstName;
	private By byForlastName;
	private By byForEmail;
	private By byForPhone;
	private By byForPassword;
	private By byForConfirmPassword;
	private By byForFirstNameErr;
	private By byForlastNameErr;
	private By byForEmailErr;
	private By byForPhoneErr;
	private By byForPasswordErr;
	private By byForConfirmPasswordErr;
	private By byForRegistrationButton;
	private By byForcheckBox;
	private By byForNewAccunt;

	
	public void initBys()
	{
		byForFirstName=By.cssSelector("[name=\"firstname\"]");
		byForlastName=By.cssSelector("[name=\"lastname\"]");
		byForNewAccunt =By.cssSelector("[data-test-id=\"qa-header-profile-button\"]");
		byForPhone=By.cssSelector("[name=\"telephone\"]");
		byForEmail=By.cssSelector("[title=\"Email\"] [name=\"email\"]");
		byForPassword=By.cssSelector("[name=\"password\"]");
		byForConfirmPassword=By.cssSelector("[name=\"new_password_confirmation\"]");
		byForFirstNameErr=By.cssSelector("[title=\"שם פרטי \"] [class=\"tx-input-error_3aAS rtl_1fsK\"]");
		byForlastNameErr=By.cssSelector("[title=\"שם משפחה \"] [class=\"tx-input-error_3aAS rtl_1fsK\"]");
		byForEmailErr=By.cssSelector("[title=\"Email\"] [class=\"tx-input-error_3aAS rtl_1fsK\"]");
		byForPhoneErr=By.cssSelector("[title=\"טלפון\"] [class=\"tx-input-error_3aAS rtl_1fsK\"]");
		byForPasswordErr=By.cssSelector("[title=\"סיסמה\"] [class=\"tx-input-error_3aAS rtl_1fsK\"]");
		byForConfirmPasswordErr=By.cssSelector("[title=\"אימות סיסמה\"] [class=\"tx-input-error_3aAS rtl_1fsK\"]");
		byForcheckBox=By.cssSelector("[title=\"מאשר/ת את תנאי השימוש האתר\"] [name=\"agreements\"]");
		byForRegistrationButton=By.cssSelector("[class=\"submit_3yFi tx-link_29YD btn_1UzJ btn-yellow_2tf3\"]");
	}
	
	
	public void goToPage()
	{
		getDriver().get("https://www.terminalx.com/customer/account/create");
		initBys();
	}
	
	void enterInputsInRegistrationPage(RegistrationData registrationData)
	{
		waitUntilVisibilityElemntLocated(byForFirstName);
	    typeInto(registrationData.getFirstName(),byForFirstName);
	    typeInto(registrationData.getLastName(),byForlastName);
	    typeInto(registrationData.getPhone(),byForPhone);
	    typeInto(registrationData.getEmail(),byForEmail);
	    typeInto(registrationData.getPassword(),byForPassword);
	    typeInto(registrationData.getConfirmPassword(),byForConfirmPassword);
	    click(byForcheckBox);
	    click(byForRegistrationButton);
	}


	public boolean checkInputFirstName_IfEmpty(RegistrationData registrationData)
	{
		enterInputsInRegistrationPage(registrationData);
		waitUntilVisibilityElemntLocated(byForFirstNameErr);
		takeScreenShot("screenshots/RegistrationAndAuthentication", "RegisP_checkInputFirstName_IfEmpty", getDriver());
		return registrationData.getStringErr().equals(getText(byForFirstNameErr));
	}
	public boolean checkInputLasttName_IfEmpty(RegistrationData registrationData)
	{
		refresh();
		enterInputsInRegistrationPage(registrationData);
		waitUntilVisibilityElemntLocated(byForlastNameErr);
		takeScreenShot("screenshots/RegistrationAndAuthentication", "RegisP_checkInputLasttName_IfEmpty", getDriver());
		return registrationData.getStringErr().equals(getText(byForlastNameErr));
	}	
	public boolean checkInputNumberPhone_IfNotCorect(RegistrationData registrationData)
	{
		refresh();
		enterInputsInRegistrationPage(registrationData);
		waitUntilVisibilityElemntLocated(byForPhoneErr);
		takeScreenShot("screenshots/RegistrationAndAuthentication", "checkInputNumberPhone_IfNotCorect", getDriver());
		return registrationData.getStringErr().equals(getText(byForPhoneErr));
	}
	
	public boolean checkInputNumberPhone_IfEmpty(RegistrationData registrationData)
	{
		refresh();
		enterInputsInRegistrationPage(registrationData);
		waitUntilVisibilityElemntLocated(byForPhoneErr);
		takeScreenShot("screenshots/RegistrationAndAuthentication", "RegisP_checkInputNumberPhone_IfEmpty", getDriver());
		return registrationData.getStringErr().equals(getText(byForPhoneErr));
	}
	public boolean checkInputEmail_IfNotCorect(RegistrationData registrationData)
	{
		refresh();
		enterInputsInRegistrationPage(registrationData);
		waitUntilVisibilityElemntLocated(byForEmailErr);
	    takeScreenShot("screenshots/RegistrationAndAuthentication", "RegisP_checkInputEmail_IfNotCorect", getDriver());
		return registrationData.getStringErr().equals(getText(byForEmailErr));
	}
	public boolean checkInputEmail_IfEmpty(RegistrationData registrationData)
	{
		refresh();
		enterInputsInRegistrationPage(registrationData);
		waitUntilVisibilityElemntLocated(byForEmailErr);
		takeScreenShot("screenshots/RegistrationAndAuthentication", "RegisP_checkInputEmail_IfEmpty", getDriver());
		return registrationData.getStringErr().equals(getText(byForEmailErr));
	}
	public boolean checkInputPassword_IfEmpty(RegistrationData registrationData)
	{
		refresh();
		enterInputsInRegistrationPage(registrationData);
		waitUntilVisibilityElemntLocated(byForPasswordErr);
		takeScreenShot("screenshots/RegistrationAndAuthentication", "RegisP_checkInputPassword_IfEmpty", getDriver());
		return registrationData.getStringErr().equals(getText(byForPasswordErr));
	}
	public boolean checkInputConfirmPassword_IfEmpty(RegistrationData registrationData)
	{
		refresh();
		enterInputsInRegistrationPage(registrationData);
		waitUntilVisibilityElemntLocated(byForConfirmPasswordErr);
	    takeScreenShot("screenshots/RegistrationAndAuthentication", "RegisP_checkInputConfirmPassword_IfEmpty", getDriver());
		return registrationData.getStringErr().equals(getText(byForConfirmPasswordErr));
	}
	public boolean checkInputPassword_unless8letters(RegistrationData registrationData)
	{
		refresh();
		enterInputsInRegistrationPage(registrationData);
		waitUntilVisibilityElemntLocated(byForPasswordErr);
		takeScreenShot("screenshots/RegistrationAndAuthentication", "RegisP_checkInputPassword_unless8letters", getDriver());
		return registrationData.getStringErr().equals(getText(byForPasswordErr));
	}
	
	
	public boolean checkInputPassword_withoutLowerCaseLetter(RegistrationData registrationData)
	{
		refresh();
		enterInputsInRegistrationPage(registrationData);
		waitUntilVisibilityElemntLocated(byForPasswordErr);
		takeScreenShot("screenshots/RegistrationAndAuthentication", "RegisP_checkInputPassword_withoutLowerCaseLetter", getDriver());
		return registrationData.getStringErr().equals(getText(byForPasswordErr));
	}
	
	public boolean checkInputPassword_withoutCapitalLetter(RegistrationData registrationData)
	{
		refresh();
		enterInputsInRegistrationPage(registrationData);
		waitUntilVisibilityElemntLocated(byForPasswordErr);
		takeScreenShot("screenshots/RegistrationAndAuthentication", "RegisP_checkInputPassword_withoutCapitalLetter", getDriver());
		return registrationData.getStringErr().equals(getText(byForPasswordErr));
	}
	
	public boolean checkInputPassword_withoutspecialChar(RegistrationData registrationData)
	{
		refresh();
		enterInputsInRegistrationPage(registrationData);
		waitUntilVisibilityElemntLocated(byForPasswordErr);
		takeScreenShot("screenshots/RegistrationAndAuthentication", "RegisP_checkInputPassword_withoutspecialChar", getDriver());
		return registrationData.getStringErr().equals(getText(byForPasswordErr));
	}
	public boolean checkAllCorrect(RegistrationData registrationData)
	{
		refresh();
		enterInputsInRegistrationPage(registrationData);
		waitUntilVisibilityElemntLocated(byForNewAccunt);
		takeScreenShot("screenshots/RegistrationAndAuthentication", "RegisP_checkAllCorrect", getDriver());
		return getText(byForNewAccunt).contains(registrationData.getFirstName());
			
	
	
	}
	

}
