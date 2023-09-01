package org.utilities;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUtility {


	public WebDriver StartUp(String bName , String url) {

		WebDriver driver = null;

		if(bName.equalsIgnoreCase("ch") || bName.equalsIgnoreCase("chrome")) {

			//System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

			//WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();     

		}

		else if(bName.equalsIgnoreCase("edge")) {

			//System.setProperty("webdriver.edge.driver","./drivers/msedgedriver.exe");

			driver  = new EdgeDriver();          

		}

		else if(bName.equalsIgnoreCase("firefox")||bName.equalsIgnoreCase("ff")) {

			//System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");

			driver  = new FirefoxDriver ();      

		} else {
			System.out.println("Invalid browser name");
		}
		
		driver.manage().window().maximize();

		driver.get(url);
		return driver;
	}
	
	//genric method for explicit wait
	public void WaitForVisibilityOfElementByLocated(WebDriver driver,int time,String type ,String locator) {
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(time));

		switch(type) {
		case "id" : wt.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		break;

		case "css" : wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
		break;

		case "xpath" : wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		break;    	   


		case "classname" : wt.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
		break;   


		case "linkText" : wt.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
		break;



		case "partialLinkText" : wt.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator)));
		break;


		case "tagName" : wt.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locator)));
		break;


		case "name" : wt.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
		break;

		}

	}

}




