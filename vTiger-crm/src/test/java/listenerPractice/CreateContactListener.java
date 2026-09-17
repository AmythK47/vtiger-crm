package listenerPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import baseTest.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import objectRepository.CreateOrganization;
import objectRepository.HomePage;
import objectRepository.OrganizationsPage;
import threadLocalClass.ThreadLocalClass;

@Listeners(listenerUtil.ListenerImplementation.class)

public class CreateContactListener extends BaseClass {
	
		@Test(retryAnalyzer = listenerUtil.RetryListenerImplementation.class)
		public void createOrgTest() throws Exception {
			// Java Utility
			JavaUtility j = new JavaUtility();

			// Read Excel Data
			ExcelFileUtility e = new ExcelFileUtility();
			String orgName = e.readDataFromExcelFile("Organization", 1, 0) + j.posRandomNumber();
			ThreadLocalClass.getTest().log(Status.INFO, "Read Data from Excel");

			// 4. Create Organization
			HomePage hp = new HomePage(driver);
			hp.getOrganizationsLnk().click();
			ThreadLocalClass.getTest().log(Status.INFO, "Click on organization link");

			OrganizationsPage op = new OrganizationsPage(driver);
			op.getCreateOrgBtn().click();
			ThreadLocalClass.getTest().log(Status.INFO, "Clicked on Create Organization button");

			CreateOrganization co = new CreateOrganization(driver);
			co.getOrgNameTF().sendKeys(orgName);
			co.getSaveBtn().click();
			ThreadLocalClass.getTest().log(Status.INFO, "Created Organization");
			Reporter.log("This is from TestNG");

			// verify Organization name
			WebElement headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
			wu.waitTillVisibilityOfElement(driver, headerInfo, 15);
			String actOrgName = co.getVerifyOrgname().getText();
			Assert.assertEquals(actOrgName, orgName);
			ThreadLocalClass.getTest().log(Status.INFO, "Organization Name Verified");

		}

}
