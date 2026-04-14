package ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {

	WebDriver driver;
	public homePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	public void organizationClick() {
		organizationLink.click();
	}

	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	public void contactClick() {
		contactLink.click();
	}
	
	@FindBy(xpath="(//a[text()='Leads'])[1]")
	private WebElement leadsLink;
	
	public void leadClick() {
		leadsLink.click();
	}
	
	@FindBy(xpath="(//a[text()='Opportunities'])[1]")
	private WebElement opportunitiesLink;
	
	public void opportunitiesClick() {
		opportunitiesLink.click();
	}
	
	@FindBy(xpath="(//a[text()='Products'])[1]")
	private WebElement productsLink;
	
	public void productsClick() {
		productsLink.click();
	}
	
	@FindBy(xpath="(//a[text()='Documents'])[1]")
	private WebElement documentsLink;
	
	public void documentsClick() {
		documentsLink.click();
	}
	
	@FindBy(xpath="(//a[text()='Trouble Tickets'])[1]")
	private WebElement troubleTicketsLink;
	
	public void troubleTicketsClick() {
		troubleTicketsLink.click();
	}
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreLink;
	
	public void moreClick() {
		moreLink.click();
	}
	
	@FindBy(name="Campaigns")
	private WebElement createCampaigns;
	
	public void campaignsClick() {
		createCampaigns.click();
	}
	
	@FindBy(name="Invoice")
	private WebElement invoiceClick;
	
	public void invoiceClick() {
		invoiceClick.click();
	}
	

	public WebElement getInvoiceClick() {
		return invoiceClick;
	}

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorIcon;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOut;
	

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}
	
	public WebElement getLeadsLink() {
		return leadsLink;
	}
	
	public WebElement getProductsLink() {
		return productsLink;
	}
	
	public WebElement getDocumentsLink() {
		return documentsLink;
	}

	
	public WebElement getTroubleTicketsLink() {
		return troubleTicketsLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}
	
	public WebElement getCreateCampaigns() {
		return createCampaigns;
	}
	
	public WebElement getAdministratorIcon() {
		return administratorIcon;
	}
	
	public WebElement getSignOut() {
		return signOut;
	}
	
	public void logout() {
		Actions action=new Actions(driver);
		action.moveToElement(administratorIcon).perform();
		signOut.click();
	}
	
	
}
