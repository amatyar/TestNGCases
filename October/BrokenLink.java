package October;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenLink {
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
	public void TestCases() 
	{
		driver.get(url);
		 List<WebElement> list = driver.findElements(By.tagName("a"));
		    
		    for(int i = 0;i< list.size();i++) 
		    {
		      String text = list.get(i).getText();
		      if(!text.isEmpty()) 
		      {
		        System.out.println(i+ " : "+text);
		      }
		}
	}
	
	@AfterTest
	public void terminateBrowser()
	{
		if(driver != null) 
		{
	 	driver.close();
		}
	}
}


