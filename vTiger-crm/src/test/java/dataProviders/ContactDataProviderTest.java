package dataProviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import objectRepository.ContactsPage;
import objectRepository.CreateContact;
import objectRepository.CreateOrganization;
import objectRepository.HomePage;
import objectRepository.OrganizationsPage;

public class ContactDataProviderTest extends BaseClass{

	@Test(dataProvider = "contactData")
	public void createContactWithOrgTest(String contName, String orgN) throws Exception {
		// Java Utility
		JavaUtility j = new JavaUtility();
		int num = j.posRandomNumber();

		String contactName = contName+num;
		String orgName = orgN+num;

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
		if (cc.getVerifyName().getText().equals(contactName))
			System.out.println(contactName + " -- Contact Name verified ===> PASS");
		else
			System.out.println(contactName + " -- Contact Name Not verified ===> FAIL");

		// verify Organization name
		if (cc.getVerifyOrgName().getText().trim().equals(orgName))
			System.out.println(orgName + " -- Organization Name verified ===> PASS");
		else
			System.out.println(orgName + " -- Organization Name Not verified ===> FAIL");
	}
	
	@DataProvider
	public Object[][] contactData() throws Exception
	{
		ExcelFileUtility e = new ExcelFileUtility();
		int last = e.getRowCount("Contacts");
		Object[][] objArr = new Object[last][2];
		
		for(int i = 0; i<last; i++)
		{
			
			objArr[i][0] = e.readDataFromExcelFile("Contacts", i+1, 0);
			objArr[i][1] = e.readDataFromExcelFile("Contacts", i+1, 1);
		}
		
		return objArr;
		
	}

}
