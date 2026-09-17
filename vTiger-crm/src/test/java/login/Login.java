package login;

import org.openqa.selenium.WebDriver;

import genericUtility.PropertiesFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class Login {
	
	public static void main(String[] args) throws Exception {
		// 1. Read Data from Properties FIle
		PropertiesFileUtility pf = new PropertiesFileUtility();
		String url = pf.readDataFromPropertiesFile("url");
		String browser = pf.readDataFromPropertiesFile("browser");
		String username = pf.readDataFromPropertiesFile("username");
		String password = pf.readDataFromPropertiesFile("password");
		
		// 2. Launch the Browser
		WebDriver driver;
		WebDriverUtility wu = new WebDriverUtility();
		driver = wu.launchBrowser(browser);
		
		// 2.1 maximize
		wu.maximizeBrowser(driver);
		
		// 2.2 implicit wait
		wu.implicitWait(driver, 15);
		

		
		// 3. LOGIN
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(url, username, password);
		
		HomePage hp = new HomePage(driver);
		hp.logoutFrmApp();
		
		wu.closeBrowser(driver);
	}

}
