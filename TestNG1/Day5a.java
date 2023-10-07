package TestNG1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day5a {
	
	
	String path ="C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe";
	WebDriver driver;
	
	//asserts in test NG
	//soft assertion and hard assertion
	
	@BeforeMethod
	public void BeforeMethod() {
		System.setProperty("WebDriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get("http://www.webdriveruniversity.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void TestOne() {
		//Assert Hard
		driver = new ChromeDriver();
		driver.get("http://www.webdriveruniversity.com/");
		//SoftAssert assertVar = new SoftAssert();
		
		String actualtitle = driver.getTitle();
		Assert.assertEquals(actualtitle, "WebDriverUniversity.com");
		
		// verify url
		boolean avail = driver.getCurrentUrl().contains("more");
		Assert.assertTrue(avail);
		// verify element displayed
		boolean avail2 = driver.findElement(By.cssSelector("#contact-us")).isDisplayed();
		Assert.assertTrue(avail2);
		
		driver.close();
	}
	@Test
	public void  testCaseTwo() {
		// Soft assertion		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe");
		driver = new ChromeDriver();
	
		driver.get("http://www.webdriveruniversity.com");
		
		SoftAssert  ss  = new SoftAssert ();
		// verify title 
		String actualtitle = driver.getTitle();
		ss.assertEquals(actualtitle, "WebDriverUniversity.com");
		// verify url
		boolean avail = driver.getCurrentUrl().contains("more");
		ss.assertTrue(avail);
		// verify element displayed
		boolean avail2 = driver.findElement(By.cssSelector("#contact-us")).isDisplayed();
		ss.assertTrue(avail2);
		
		driver.close();
		
		ss.assertAll(); 
		
		// fail - any assertion is fail
		// pass - if any assertion is pass
		
	}
	
	
	
	
	
//	@AfterMethod
//	public void AfterMethod() {
//		
//			//driver.close();
//		
//	}
	
	
}
