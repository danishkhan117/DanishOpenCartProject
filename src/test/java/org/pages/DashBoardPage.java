package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

	public WebDriver driver;


	@FindBy(css=".form-control.input-lg")
	private WebElement searchField;

	@FindBy(css=".btn.btn-default.btn-lg")
	private WebElement clickOnSearchBttn;


	public DashBoardPage(WebDriver driver) {

		PageFactory.initElements(driver,this);

		this.driver=driver;
	}

	public void enterProductOnSearchField(String product) {
		searchField.sendKeys(product);

	}

	public void clickOnSearchBttn() {
		clickOnSearchBttn.click();
	}






}
