package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;



public class HomePage {
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//add Home btn
	
	@FindBy(linkText = "Calendar")
	private WebElement calenderLnk;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;
	
	@FindBy(linkText = "Documents")
	private WebElement documentsLnk;
	
	@FindBy(linkText = "Email")
	private WebElement emailLnk;
	
	@FindBy(partialLinkText = "Trouble Tickets")
	private WebElement troubleTcktsLnk;
	
	@FindBy(linkText = "Dashboard")
	private WebElement dashboardLnk;
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLnk;
	
	@FindBy(linkText = "More")
	private WebElement moreLnk;
	
	@FindBy(id = "qccombo")
	private WebElement qckCreateDD;
	
	//the links under 'more' should be added under HomePage itself?
	//what about search TF

	//logout section
	@FindBy(xpath = "//img[contains(@src,'user.PNG')]")
	private WebElement userIcon;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement logoutLnk;
	

	
	
	public WebElement getUserIcon() {
		return userIcon;
	}

	public WebElement getLogoutLnk() {
		return logoutLnk;
	}

	public WebElement getCalenderLnk() {
		return calenderLnk;
	}

	public WebElement getOrganizationsLnk() {
		return organizationsLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getDocumentsLnk() {
		return documentsLnk;
	}

	public WebElement getEmailLnk() {
		return emailLnk;
	}

	public WebElement getTroubleTcktsLnk() {
		return troubleTcktsLnk;
	}

	public WebElement getDashboardLnk() {
		return dashboardLnk;
	}

	public WebElement getLeadsLnk() {
		return leadsLnk;
	}

	public WebElement getMoreLnk() {
		return moreLnk;
	}

	public WebElement getQckCreateDD() {
		return qckCreateDD;
	}
	
	public void logoutFrmApp()
	{
		WebDriverUtility wu = new WebDriverUtility();
		wu.moveToElement(driver, userIcon);	
		logoutLnk.click();	
	}
	
	
	
}
