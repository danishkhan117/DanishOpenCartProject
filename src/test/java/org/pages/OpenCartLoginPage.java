package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCartLoginPage {

	public WebDriver driver;


	@FindBy(xpath="//span[text()='My Account']")
	private WebElement clickOnMyAccount;

	@FindBy(xpath="(//a[text()='Login'])[1]")
	private WebElement clickOnLogin;

	@FindBy(xpath="//h2[text()='Returning Customer']")
	private WebElement returCustText;

	@FindBy(xpath="//label[text()='E-Mail Address']")
	private WebElement emailidtext;

	@FindBy(xpath="//label[text()='Password']")
	private WebElement passwordtext;


	@FindBy(css="#input-email")
	private WebElement enterEmailId;

	@FindBy(css="#input-password")
	private WebElement enterPwd;


	@FindBy(xpath="(//a[text()='Forgotten Password'])[1]")
	private WebElement forgotPwdText;


	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement loginBttn;



	@FindBy(xpath="//a[contains(@class,'group')]")
	private WebElement loginPageList;


	@FindBy(xpath="(//div[@class='well'])[1]")
	private WebElement registerTextBttn;
	
	@FindBy(xpath="(//a[text()='Logout'])[2]")
	private WebElement clickOnLogoutBttn;



	public OpenCartLoginPage(WebDriver driver) {

		PageFactory.initElements(driver,this);

		this.driver=driver;


	}


	public void clickOnMyAccout() {
		clickOnMyAccount.click();		 
	}


	public void clickOnLogin() {
		clickOnLogin.click();		 
	}

	public boolean returnCustNameIsDisplyed() {
		return returCustText.isDisplayed();
	}

	public boolean emailIdTextIsDisplyed() {
		return emailidtext.isDisplayed();
	}

	public boolean passwordTextIsDisplyed() {
		return passwordtext.isDisplayed();
	}

	public void enterEmaiId(String emid ) {
		enterEmailId.sendKeys(emid);
	}


	public void enterPwd(String pwd ) {
		enterPwd.sendKeys(pwd);
	}

	public void clickOnLoginButton() {
		loginBttn.click();;
	}

	public boolean forgotPwdTxtIsDisplayed() {
		return forgotPwdText.isDisplayed();
	}

	public boolean loginButtonisDisplayed() {
		return loginBttn.isDisplayed();
	}

	public boolean loginPageListisDisplayed() {
		return loginPageList.isDisplayed();
	}

	public boolean registerTextisDisplayed() {
		return registerTextBttn.isDisplayed();
	}
	
	public void clickonLogoutBttn() {
		
		clickOnLogoutBttn.click();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getpageUrl() {
		return driver.getCurrentUrl();
	}


	
}
