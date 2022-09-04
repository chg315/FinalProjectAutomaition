package Suite1_RegistrationAndAuthentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BasePage;

public class pageTerminalXLogoutObjectModel extends BasePage {
	public pageTerminalXLogoutObjectModel(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}
	By byLogoutButton;
	By byMyAccount;

	void InitByes()
	{
		byLogoutButton=By.cssSelector("[class=\"list-item_2A1s logout_3ZNa\"] button");
		byMyAccount=By.cssSelector("[data-test-id=\"qa-header-login-button\"]");
	}
	public boolean checkLogoutButton()
	{
	    InitByes();
	    System.out.println("pom");
	    waitUntilVisibilityElemntLocated(byLogoutButton);
		click(byLogoutButton);
		waitUntilVisibilityElemntLocated(byMyAccount);
		System.out.println(getText(byMyAccount));
		takeScreenShot("screenshots/RegistrationAndAuthentication", "checkLogoutButton", getDriver());
		return getText(byMyAccount).equals("התחברות");
	}
}
