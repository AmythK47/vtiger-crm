package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[contains(@title,'Create Contact')]")
	private WebElement createContactBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Search in Contacts')]")
	private WebElement searchInContactBtn;
	
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
	
	@FindBy(xpath = "//img[contains(@title,'Import Contacts')]")
	private WebElement importContactsBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Export Contacts')]")
	private WebElement exportContactsBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Find Duplicates')]")
	private WebElement findDuplicateBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Contacts Settings')]")
	private WebElement contactSettingsBtn;
	
	@FindBy(xpath = "//input[@class='txtBox']")
	private WebElement searchForTF;
	
	@FindBy(id= "bas_searchfield")
	private WebElement searchInDD;
	
	@FindBy(xpath = "//div[@id='searchAcc']/descendant::input[@name='submit']")
	private WebElement searchNowBtn;

	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}

	public WebElement getSearchInContactBtn() {
		return searchInContactBtn;
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

	public WebElement getImportContactsBtn() {
		return importContactsBtn;
	}

	public WebElement getExportContactsBtn() {
		return exportContactsBtn;
	}

	public WebElement getFindDuplicateBtn() {
		return findDuplicateBtn;
	}

	public WebElement getContactSettingsBtn() {
		return contactSettingsBtn;
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
