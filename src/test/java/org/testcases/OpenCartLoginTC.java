package org.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.pages.OpenCartLoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.utilities.BaseUtility;
import org.utilities.ConfigReader;

public class OpenCartLoginTC {

	private WebDriver driver;

	private BaseUtility bu = new BaseUtility();

	private Properties prop;


	@BeforeSuite
	public void init_Prop() {

		ConfigReader cr = new ConfigReader();

		prop = cr.init_Prop();

	}

	@BeforeMethod
	public void initBrowser() {

		driver= bu.StartUp(prop.getProperty("browserName"),prop.getProperty("url"));


	}

	@Test(priority=0)

	public void verifyLoginPageFields() {

		OpenCartLoginPage opencart  = new OpenCartLoginPage(driver);

		SoftAssert sa = new SoftAssert();

		sa.assertEquals(opencart.getPageTitle(),"Account Login");

		sa.assertEquals(opencart.getpageUrl(), prop.getProperty("url"));

		sa.assertTrue(opencart.returnCustNameIsDisplyed());

		sa.assertTrue(opencart.emailIdTextIsDisplyed());

		sa.assertTrue(opencart.passwordTextIsDisplyed());

		sa.assertTrue(opencart.forgotPwdTxtIsDisplayed());

		sa.assertTrue(opencart.loginButtonisDisplayed());

		sa.assertTrue(opencart.loginPageListisDisplayed());

		sa.assertTrue(opencart.registerTextisDisplayed());

		sa.assertAll();

	}


	@Test(priority=1)
	public void loginTestCase() {

		OpenCartLoginPage opencart  = new OpenCartLoginPage(driver);


		opencart.enterEmaiId(prop.getProperty("uName"));
		opencart.enterPwd(prop.getProperty("pwd"));
		opencart.clickOnLoginButton();
	//	opencart.clickonLogoutBttn();
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






}

