package TestNG1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day5 {
	String url = "http://www.webdriveruniversity.com/";
	String url1 ="http://www.webdriveruniversity.com/Actions/index.html";
	String path ="C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe";
	WebDriver driver;
	
	//asserts in test NG
	//softassertion nad hard
	
	@BeforeMethod
	public void BeforeMethod() {
		System.setProperty("WebDriver.chrome.driver", path);
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
	}
	
	@Test
	public void TestOne() {
			//assertEquals(expected, actual)
			//assertNotEquals(expected, actual)
			//assertTrue(condition)
			//assertFalse(condition)
			//assertNull(object)
			//assertNotNull(object)
		driver.get(url);
		String ActualTitle = driver.getTitle();
		String expectedTitle = "WebDriverUniversity.com";
		assertEquals(expectedTitle, ActualTitle);
		
			// WebDriver | Contact Us
				WebElement contactus = driver.findElement(By.cssSelector("#contact-us"));
				JavascriptExecutor je = (JavascriptExecutor) driver;
				je.executeScript("arguments[0].removeAttribute('target')", contactus);
				contactus.click();
				ActualTitle  = driver.getTitle();
				assertNotEquals(ActualTitle,expectedTitle);
		
	}
	@Test
	public void TestcaseTwo() {
		// webdriver university
		String currentUrl = driver.getCurrentUrl();
		boolean avail = currentUrl.contains("university");
		assertTrue(avail);
		// google 
		driver.get("https://www.google.com");
		avail = driver.getCurrentUrl().contains("university");
		assertFalse(avail);
		
	}
	
	@AfterMethod
	public void AfterMethod() {
		
			driver.close();
		
	}
	
	

}
