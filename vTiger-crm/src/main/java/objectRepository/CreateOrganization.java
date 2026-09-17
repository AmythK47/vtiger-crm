package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganization {
	
	WebDriver driver;
	
	public CreateOrganization(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement OrgNameTF;
	
	@FindBy(xpath ="//select[@name='industry']")
	private WebElement industryDD;
	
	@FindBy(id = "phone")
	private WebElement phoneNumberTF;
	
	@FindBy(xpath = "//input[contains(@title,'Save')]")
	private WebElement saveBtn;

	@FindBy (id = "dtlview_Organization Name")
	private WebElement verifyOrgname;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement verifyPhone;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement verifyIndustry;
	
	public WebElement getVerifyOrgname() {
		return verifyOrgname;
	}

	public WebElement getVerifyPhone() {
		return verifyPhone;
	}

	public WebElement getVerifyIndustry() {
		return verifyIndustry;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOrgNameTF() {
		return OrgNameTF;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getPhoneNumberTF() {
		return phoneNumberTF;
	}
	
	
	
}
