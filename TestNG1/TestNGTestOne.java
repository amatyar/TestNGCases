package TestNG1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGTestOne {
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Starting the browser session");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("Closing the browser session");
	}
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Starting the Suite session");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("Closing the Suite session");
	}
	
	@Test
	public void Testcase()
	{
		System.setProperty("webdeiver.chrome.deriver", 
				"C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://www.google.com";
    	  driver.get(url);
    	  //Capturing the title and validating if expected is equal to actual
    	  String expectedTitle = "Google";
    	  String actualTitle = driver.getTitle();
    	  Assert.assertEquals(actualTitle, expectedTitle);
        
	}
	@Test
	public void Testcase2()
	{
		System.setProperty("webdeiver.chrome.deriver", 
				"C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        String baseUrl = "https://www.toolsqa.com/";
	      
        
        System.out.println("Launching Google Chrome browser"); 
     
        driver.get(baseUrl);
        String testTitle = "Free QA Automation Tools For Everyone";
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle, testTitle);
        
	}
}
