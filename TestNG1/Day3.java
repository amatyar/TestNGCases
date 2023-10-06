package TestNG1;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class Day3 {
	WebDriver driver;
	
	@BeforeMethod
	public void OpenBrowser() {
		System.setProperty("webdeiver.chrome.deriver", 
				"C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.webdriveruniversity.com/index.html");
	}
	
	@Test (priority = 1 , description = "login functionality")
	public void testOne(){
		String actualTitle = driver.getTitle();
		String expectedTitle = "WebDriverUniversity.com";
		
		AssertJUnit.assertEquals(actualTitle, expectedTitle);
		
	}
	
	@Test(priority = 2 , description = "validate the home page url")
	public void testTwo(){
		String currentUrl = driver.getCurrentUrl();
		boolean expected = currentUrl.contains("webdriveruniversity");
		AssertJUnit.assertEquals(expected, true);
		
	}
	
	@AfterMethod 
	public void CloseBroswe() {
		driver.close();
		//driver.quit();
	}

}
