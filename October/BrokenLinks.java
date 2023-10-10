package October;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenLinks {
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
	public void TestCases() {
		driver.get(url);
		int Count = 0;
		List<WebElement> lists = driver.findElements(By.tagName("a"));
		for(WebElement el:lists) {
			String link = el.getAttribute("href");
			if(link != null && !link.isEmpty()) {
				if(isLinkBroken(link)) {
					System.out.println(link);
					Count++;
				}
			}
		}
		
	}
	
	private boolean isLinkBroken(String link) {
		try {
			HttpURLConnection con =(HttpURLConnection)(new URL(link).openConnection());
			con.setRequestMethod("HEAD");
			con.connect();
			int responseCode = con.getResponseCode();
			return (responseCode >= 400);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		return true;
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
