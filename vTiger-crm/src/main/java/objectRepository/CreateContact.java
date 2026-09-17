package objectRepository;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericUtility.WebDriverUtility;

public class CreateContact {
	
	public WebDriver driver;
	
	public CreateContact(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement contNameTF;
	

	@FindBy(xpath = "//input[@name='account_id']/../img")
	private WebElement orgNameSelector;
	
	@FindBy(xpath = "//input[@name='support_end_date']")
	private WebElement endDate;
	
	@FindBy(id = "search_txt")
	private WebElement searchOrgTF;
	
	@FindBy(xpath = "//input[@name = 'search']")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//a[@id='1']")
	private WebElement orgSelectLnk;
	
	@FindBy(xpath = "//input[contains(@title,'Save')]")
	private WebElement saveBtn;
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement verifyName;
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement verifyOrgName;
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement verifyEndDate;
	
	public WebElement getContNameTF() {
		return contNameTF;
	}

	public WebElement getOrgNameSelector() {
		return orgNameSelector;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	public WebElement getSearchOrgTF() {
		return searchOrgTF;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getOrgSelectLnk() {
		return orgSelectLnk;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getVerifyName() {
		return verifyName;
	}

	public WebElement getVerifyOrgName() {
		return verifyOrgName;
	}

	public WebElement getVerifyEndDate() {
		return verifyEndDate;
	}
	
	public void orgNameselect(String orgName) throws Exception
	{
		orgNameSelector.click();
		WebDriverUtility wu = new WebDriverUtility();
		wu.switchToWindow(driver, "http://49.249.29.4:8888/index.php?module=Accounts&action=Popup");
		searchOrgTF.sendKeys(orgName);
		searchBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(orgSelectLnk, orgName));
		orgSelectLnk.click();
		
		wu.switchToWindow(driver, "ACOE Fireflink - Contacts - vtiger CRM 5 - Commercial Open Source CRM");
		
		
	}
}
