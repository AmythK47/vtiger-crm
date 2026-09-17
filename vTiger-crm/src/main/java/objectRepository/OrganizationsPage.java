package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[contains(@title,'Create Organization')]")
	private WebElement createOrgBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Search in Organizations')]")
	private WebElement searchInOrgBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Open Calendar')]")
	private WebElement openCalBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Show World Clock')]")
	private WebElement shwWrldClckBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Open Calculator')]")
	private WebElement openCalciBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Chat')]")
	private WebElement chatBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Last Viewed')]")
	private WebElement lastViewdBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Import Organizations')]")
	private WebElement importOrgBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Export Organizations')]")
	private WebElement exportOrgBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Find Duplicates')]")
	private WebElement findDuplicateBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Organizations Settings')]")
	private WebElement orgSettingsBtn;
	
	@FindBy(xpath = "//input[@class='txtBox']")
	private WebElement searchForTF;
	
	@FindBy(id= "bas_searchfield")
	private WebElement searchInDD;
	
	@FindBy(xpath = "//div[@id='searchAcc']/descendant::input[@name='submit']")
	private WebElement searchNowBtn;

	public WebElement getCreateOrgBtn() {
		return createOrgBtn;
	}

	public WebElement getSearchInOrgBtn() {
		return searchInOrgBtn;
	}

	public WebElement getOpenCalBtn() {
		return openCalBtn;
	}

	public WebElement getShwWrldClckBtn() {
		return shwWrldClckBtn;
	}

	public WebElement getOpenCalciBtn() {
		return openCalciBtn;
	}

	public WebElement getChatBtn() {
		return chatBtn;
	}

	public WebElement getLastViewdBtn() {
		return lastViewdBtn;
	}

	public WebElement getImportOrgBtn() {
		return importOrgBtn;
	}

	public WebElement getExportOrgBtn() {
		return exportOrgBtn;
	}

	public WebElement getFindDuplicateBtn() {
		return findDuplicateBtn;
	}

	public WebElement getOrgSettingsBtn() {
		return orgSettingsBtn;
	}

	public WebElement getSearchForTF() {
		return searchForTF;
	}

	public WebElement getSearchInDD() {
		return searchInDD;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	

}
