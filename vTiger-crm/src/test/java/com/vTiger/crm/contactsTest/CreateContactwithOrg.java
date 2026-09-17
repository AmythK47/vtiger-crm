package com.vTiger.crm.contactsTest;

import org.openqa.selenium.WebDriver;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertiesFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.ContactsPage;
import objectRepository.CreateContact;
import objectRepository.CreateOrganization;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationsPage;

public class CreateContactwithOrg {
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
		
		// 2.3 navigate to Application
		driver.get(url);
		
		LoginPage lp = new LoginPage(driver);
		
		// 3. LOGIN
		lp.loginToApp(url,username, password);
		
		//Java Utility
		JavaUtility j = new JavaUtility();
		
		//Read Excel Data
		ExcelFileUtility e = new ExcelFileUtility();
		String contactName = e.readDataFromExcelFile("Contacts", 1, 0)+j.posRandomNumber();
		String orgName = e.readDataFromExcelFile("Contacts", 1, 1)+j.posRandomNumber();
		
		
		// 4. Create Organization
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLnk().click();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrgBtn().click();
		CreateOrganization co = new CreateOrganization(driver);
		co.getOrgNameTF().sendKeys(orgName);
		co.getSaveBtn().click();
		
		// 5. Create Contact
		wu.waitTillVisibilityOfElement(driver, co.getVerifyOrgname(), 10);
		
		hp.getContactsLnk().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactBtn().click();
		
		CreateContact cc = new CreateContact(driver);
		cc.getContNameTF().sendKeys(contactName);
		cc.orgNameselect(orgName);
		cc.getSaveBtn().click();
		
		
		System.out.println("Contact Name : " + contactName);
		
		//verify Contact name
		if(cc.getVerifyName().getText().equals(contactName))
			System.out.println(contactName + " -- Contact Name verified ===> PASS");
		else
			System.out.println(contactName + " -- Contact Name Not verified ===> FAIL");
		
		//verify Organization name
		if(cc.getVerifyOrgName().getText().trim().equals(orgName))
			System.out.println(orgName + " -- Organization Name verified ===> PASS");
		else
			System.out.println(orgName + " -- Organization Name Not verified ===> FAIL");
		
		hp.logoutFrmApp();
		
		wu.closeBrowser(driver);
		
	}

}
