package baseTest;

/*
 * NOTE : 
 * 1. Add @Parameters before @BeforeClass to pass the STring BROWSER  and pass that string as argument to enable Cross browser testing
 * 2. Instead of SOPLN we are using Reporter class to log the report
 * 3. Report Configuration and backup is done in Listener implementation class not here in Base Class
 */


import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;

import genericUtility.DatabaseUtility;
import genericUtility.PropertiesFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import threadLocalClass.ThreadLocalClass;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	//public DatabaseUtility db = new DatabaseUtility();
	public WebDriverUtility wu = new WebDriverUtility();
	public PropertiesFileUtility pf = new PropertiesFileUtility();

	
	@BeforeSuite(groups = {"Smoke","Regression"})
	public void configBS()
	{
		Reporter.log("=====DataBase Connection Open=======",true);
		//db.connectToDatabase(null, null, null);
		
	}

	// @Parameters("BROWSER")  Pass String BROWSER as argument to method
	@BeforeClass(groups = {"Smoke","Regression"})
	public void configBC() throws Exception   //Pass String BROWSER as argument to method
	{
		Reporter.log("=====BROWSER LAUNCH=======",true);
		String browser = pf.readDataFromPropertiesFile("browser"); // This is for other Normal testing
		//String browser = BROWSER; // this is for cross browser testing
		driver = wu.launchBrowser(browser);
		sdriver=driver; 	//this is the static variable that is used in listener ontestFailure for capturing ss
		ThreadLocalClass.setDriver(driver);
		wu.maximizeBrowser(driver);
		wu.implicitWait(driver, 15);
		
	}

	@BeforeMethod(groups = {"Smoke","Regression"})
	public void configBM() throws Exception
	{
		Reporter.log("=====LOGIN=======",true);
		String url = pf.readDataFromPropertiesFile("url");
		String username = pf.readDataFromPropertiesFile("username");
		String password = pf.readDataFromPropertiesFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(url, username, password);
	}

	@AfterMethod(groups = {"Smoke","Regression"})
	public void configAM()
	{
		Reporter.log("=====LOGOUT=======",true);
		HomePage hp = new HomePage(driver);
		hp.logoutFrmApp();
		ThreadLocalClass.getTest().log(Status.INFO, "Logout Done");
		
	}

	@AfterClass(groups = {"Smoke","Regression"})
	public void configAC()
	{
		Reporter.log("=====CLOSE BROWSER=======",true);
		wu.closeBrowser(driver);
		ThreadLocalClass.getTest().log(Status.INFO, "Browser Closed");
	}

	@AfterSuite(groups = {"Smoke","Regression"})
	public void configAS()
	{
		Reporter.log("=====DataBase Connection Closed=======",true);
		ThreadLocalClass.getTest().log(Status.INFO, "Dastabase Connection Closed");
	}

}
