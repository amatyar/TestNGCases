package TestNG1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day3 {
	WebDriver driver;
	
	@BeforeMethod
	public void OpenBrowser() {
		System.setProperty("webdeiver.chrome.deriver", 
				"C://Users//Rabindra//OneDrive//Desktop//chromedriver//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.webdriveruniversity.com/");
	}
	@Test(priority = 1 , description = "login functionality")
	public void testOne(){
		String title = driver.getTitle();
		String expectedTitle = "WebDriverUniversity.com";
		
		Assert.assertEquals(title, expectedTitle);
		
	}
	
	@Test(priority = 2 , description = "validate the home page url")
	public void testTwo(){
		String url = driver.getCurrentUrl();
		boolean expected = url.contains("webdriveruniversity");
		Assert.assertEquals(expected, true);
		
	}
	
	@AfterMethod 
	public void CloseBroswe() {
		driver.close();
		//driver.quit();
	}

}
