package com.vTiger.crm.organizationTest;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseTest.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import objectRepository.CreateOrganization;
import objectRepository.HomePage;
import objectRepository.OrganizationsPage;

/*
 *  NOTE : 
 *  1.Change the Browser Setting in Base Class to change to normal launch or Cross Browser testing using @Parameters
 */
@Listeners(listenerUtil.ListenerImplementation.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "Smoke")
	public void createOrgTest() throws Exception {
		// Java Utility
		JavaUtility j = new JavaUtility();

		// Read Excel Data
		ExcelFileUtility e = new ExcelFileUtility();
		String orgName = e.readDataFromExcelFile("Organization", 1, 0) + j.posRandomNumber();

		// 4. Create Organization
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLnk().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrgBtn().click();

		CreateOrganization co = new CreateOrganization(driver);
		co.getOrgNameTF().sendKeys(orgName);
		co.getSaveBtn().click();

		// verify Organization name
		WebElement headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		wu.waitTillVisibilityOfElement(driver, headerInfo, 15);
		String actOrgName = co.getVerifyOrgname().getText();
		Assert.assertEquals(actOrgName, orgName);

	}

	@Test(groups = "Regression")
	public void createOrgWithIndustryTest() throws Exception {
		// Java Utility
		JavaUtility j = new JavaUtility();

		// Read Excel Data
		ExcelFileUtility e = new ExcelFileUtility();
		String orgName = e.readDataFromExcelFile("Organization", 2, 0) + j.posRandomNumber();
		String orgIndustry = e.readDataFromExcelFile("Organization", 2, 1);

		// 4. Create Organization
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLnk().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrgBtn().click();

		CreateOrganization co = new CreateOrganization(driver);
		co.getOrgNameTF().sendKeys(orgName);
		wu.selectDropdownByvalue(co.getIndustryDD(), orgIndustry);
		co.getSaveBtn().click();
		
		//Verify Org and Industry Name
		String actOrgName = co.getVerifyOrgname().getText();
		String actIndName = co.getVerifyIndustry().getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actOrgName, orgName);
		sa.assertEquals(actIndName, orgIndustry);
		
		sa.assertAll("All Verifications are Passed");
		

	}

	@Test(groups = "Regression")
	public void createOrgWithPhoneTest() throws Exception {
		// Java Utility
		JavaUtility j = new JavaUtility();

		// Read Excel Data
		ExcelFileUtility e = new ExcelFileUtility();
		String orgName = e.readDataFromExcelFile("Organization", 2, 0) + j.posRandomNumber();
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
		
		//verify Org name and Phone nNumber
		String actOrgName = co.getVerifyOrgname().getText();
		String actPhone = co.getVerifyPhone().getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actOrgName, orgName);
		sa.assertEquals(actPhone, orgPhone);
		
		sa.assertAll();
		
	}

}
