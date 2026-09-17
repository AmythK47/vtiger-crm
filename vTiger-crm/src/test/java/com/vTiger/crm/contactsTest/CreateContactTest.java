package com.vTiger.crm.contactsTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseTest.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import objectRepository.ContactsPage;
import objectRepository.CreateContact;
import objectRepository.CreateOrganization;
import objectRepository.HomePage;
import objectRepository.OrganizationsPage;

/*
 *  NOTE : 
 *  1.Change the Browser Setting in Base Class to change to normal launch or Cross Browser testing using @Parameters
 */

@Listeners(listenerUtil.ListenerImplementation.class)
public class CreateContactTest extends BaseClass{

	@Test(groups = "Smoke")
	public void createContactTest() throws Exception {
		// Java Utility
		JavaUtility j = new JavaUtility();

		// Read Excel Data
		ExcelFileUtility e = new ExcelFileUtility();
		String contactName = e.readDataFromExcelFile("Contacts", 1, 0) + j.posRandomNumber();

		// 4. Create Contact
		HomePage hp = new HomePage(driver);
		hp.getContactsLnk().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactBtn().click();

		CreateContact cc = new CreateContact(driver);
		cc.getContNameTF().sendKeys(contactName);
		cc.getSaveBtn().click();

		System.out.println("Contact Name : " + contactName);

		// verify Contact name
		String actName = cc.getVerifyName().getText();
		Assert.assertEquals(actName, contactName);
	}

	@Test(groups="Regression")
	public void createContactWithEndDateTest() throws Exception {
		// Java Utility
		JavaUtility j = new JavaUtility();
		String reqDate = j.getReqData(30);

		// Read Excel Data
		ExcelFileUtility e = new ExcelFileUtility();
		String contactName = e.readDataFromExcelFile("Contacts", 1, 0) + j.posRandomNumber();

		// 4. Create Contact
		HomePage hp = new HomePage(driver);
		hp.getContactsLnk().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactBtn().click();

		CreateContact cc = new CreateContact(driver);
		cc.getContNameTF().sendKeys(contactName);
		cc.getEndDate().clear();
		cc.getEndDate().sendKeys(reqDate);
	
		cc.getSaveBtn().click();

		// verify Contact name
		String actName = cc.getVerifyName().getText();
		String actDate = cc.getVerifyEndDate().getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actName, contactName);
		sa.assertEquals(actDate, reqDate);
		sa.assertAll();
		
		
	}

	@Test(groups="Regression")
	public void createContactWithOrgTest() throws Exception {
		// Java Utility
		JavaUtility j = new JavaUtility();

		// Read Excel Data
		ExcelFileUtility e = new ExcelFileUtility();
		String contactName = e.readDataFromExcelFile("Contacts", 1, 0) + j.posRandomNumber();
		String orgName = e.readDataFromExcelFile("Contacts", 1, 1) + j.posRandomNumber();

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

		// verify Contact name		
		String actName = cc.getVerifyName().getText();
		String actOrgName = cc.getVerifyOrgName().getText().trim();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actName, contactName);
		sa.assertEquals(actOrgName, orgName);
		sa.assertAll("All Verifications are Passed");
		
		
	}

}
