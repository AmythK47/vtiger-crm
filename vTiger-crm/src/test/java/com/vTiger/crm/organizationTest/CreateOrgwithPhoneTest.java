package com.vTiger.crm.organizationTest;

import org.openqa.selenium.WebDriver;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertiesFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.CreateOrganization;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationsPage;

public class CreateOrgwithPhoneTest {
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
		
		
		LoginPage lp = new LoginPage(driver);
		
		// 3. LOGIN
		lp.loginToApp(url,username, password);
		
		//Java Utility
		JavaUtility j = new JavaUtility();
		
		//Read Excel Data
		ExcelFileUtility e = new ExcelFileUtility();
		String orgName = e.readDataFromExcelFile("Organization", 2, 0)+j.posRandomNumber();
		String orgPhone = e.readDataFromExcelFile("Organization", 2, 2);
		
		// 4. Create Organization
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLnk().click();
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrgBtn().click();
		
		CreateOrganization co = new CreateOrganization(driver);
		co.getOrgNameTF().sendKeys(orgName);
		co.getPhoneNumberTF().sendKeys(orgPhone);
		co.getSaveBtn().click();
		
		System.out.println("Organization Name : " + orgName);
		
		//verify Organization name
		if(co.getVerifyOrgname().getText().equals(orgName))
			System.out.println(orgName + " Organization Name verified ===> PASS");
		else
			System.out.println(orgName + " Organization Name Not verified ===> FAIL");
		
		
		//verify Industry name
		System.out.println("Phone Number : " + orgPhone);
		
		if(co.getVerifyPhone().getText().equals(orgPhone))
			System.out.println(orgPhone + " Phone Number verified ===> PASS");
		else
			System.out.println(orgPhone + " Phone Number Not verified ===> FAIL");
		
		
		hp.logoutFrmApp();
		wu.closeBrowser(driver);
			
	}

}
