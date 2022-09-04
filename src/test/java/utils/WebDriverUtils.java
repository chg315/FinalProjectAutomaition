package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtils {

	static WebDriver createDriverObj(int browserType) {
		WebDriver driver = null;
		switch (browserType) {
		case 1:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case 2:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case 3:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			break;
		}

		return driver;
	}

}
