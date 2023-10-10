package October;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SaveScreenshot {
// how many total links on the page and how many broken links their on page selenium
	
	
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
	public void TestcaseOne() {
		driver.get(url);
		driver.findElement(By.id("contact-us")).click();
		  Set <String > handles = driver.getWindowHandles();
		  boolean windowFound  = false;
		  for( String wd:handles) {
		   System.out.println(wd);
		   driver.switchTo().window(wd);
		   if(driver.getCurrentUrl().contains("Contact-Us")){
		    windowFound = true;
		   }
		  }
		  
		  Assert.assertTrue(windowFound);
		  
		  TakesScreenshot screenshot = (TakesScreenshot)driver;
		  
		  File src = screenshot.getScreenshotAs(OutputType.FILE);
		  String pathA = "C:\\Users\\Rabindra\\eclipse-workspace\\TestNg\\img.png";
		  File destination = new File(pathA);
		  try 
		  {
		   FileUtils.copyFile(src,destination);
		  } 
		  catch (IOException e) 
		  {		 
		   e.printStackTrace();
		  }
	}
	
	
	@AfterTest
	public void terminateBrowser()
	{
	 	driver.close();
	}
}
