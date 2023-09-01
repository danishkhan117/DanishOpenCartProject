package org.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.pages.DashBoardPage;
import org.pages.OpenCartLoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.utilities.BaseUtility;

public class BaseClass {
	
	public WebDriver driver;

	public BaseUtility bu = new BaseUtility();

	public Properties prop;
	
	public OpenCartLoginPage opencart  = new OpenCartLoginPage(driver);
	
	public DashBoardPage searchproduct = new DashBoardPage(driver);
	
	
	


}
