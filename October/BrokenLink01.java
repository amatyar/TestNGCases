package October;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenLink01 {
	WebDriver driver;		
	String url = "http://www.webdriveruniversity.com/";	
	String path ="C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe";

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("WebDriver.chrome.driver", path);		
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
	}
	@Test
public void testcase() 
	{

	// Navigate to web drive university Website
	driver.get(url);


	// Finding all the available links on webpage
	List<WebElement> links = driver.findElements(By.tagName("a"));


	// Iterating each link and checking the response status
		for (WebElement link : links) 
		{
		
			String url = link.getAttribute("href");
		
			verifyLink(url);
		}
	
	}


	public static void verifyLink(String url) {
	try 
	{
		URL link = new URL(url);
		HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
		httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
		httpURLConnection.connect();
	
	
		if (httpURLConnection.getResponseCode() == 200) {
		System.out.println(url + " - " + httpURLConnection.getResponseMessage());
	}
		
		else 
		{
	System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is Broken links");
		}
		
	} 
	catch (Exception e) 
		{
		System.out.println(url + " - " + "is Broken links");
		}
	}
	
	@AfterTest
	public void terminateBrowser()
	{
		if(driver != null) 
		{
	 	driver.quit();
		}
	}
}
