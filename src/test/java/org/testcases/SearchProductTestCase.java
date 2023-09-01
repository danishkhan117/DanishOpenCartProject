package org.testcases;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.pages.DashBoardPage;
import org.pages.OpenCartLoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.utilities.BaseUtility;
import org.utilities.ConfigReader;

public class SearchProductTestCase extends BaseClass {



	@BeforeSuite
	public void init_Prop() {

		ConfigReader cr = new ConfigReader();

		prop = cr.init_Prop();
		
		driver= bu.StartUp(prop.getProperty("browserName"),prop.getProperty("url"));
		
		OpenCartLoginPage opencart  = new OpenCartLoginPage(driver);


		opencart.enterEmaiId(prop.getProperty("uName"));
		opencart.enterPwd(prop.getProperty("pwd"));
		opencart.clickOnLoginButton();

	}

   @Test(priority=2)
	public void searchProductTc() {

		DashBoardPage searchproduct = new DashBoardPage(driver);

		searchproduct.enterProductOnSearchField(prop.getProperty("product"));
		searchproduct.clickOnSearchBttn();
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();

	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
		prop.clear();


	}
	
	//latest code


}

