package October;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_One {
WebDriver driver;
String url = "http://www.webdriveruniversity.com/";
String path ="C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe";

@BeforeTest
public void launchBrowser() {
	System.setProperty("WebDriver.chrome.driver", path);
	driver = new ChromeDriver();		
	driver.manage().window().maximize();
}
@Test (priority = 1)
public void validateTitle()
	{
	System.out.println("Title case");
	driver.get(url);
	String actualTitle = driver.getTitle();
	String expectedTitle ="WebDriverUniversity.com";
	Assert.assertEquals(actualTitle, expectedTitle);
	
	}
@Test (priority = 0)
public void validateCurrentUrl() {
	System.out.println("url case");
	driver.get(url);
	String url = driver.getCurrentUrl();
	boolean available = url.contains("driver");
	Assert.assertTrue(available);
	
}

@Test (priority = 2)
public void ValidateTitleOne()
{
	System.out.println("Title case one");
	driver.get(url);
	String ExpectedTitle = "WebDriverUniversity.com";
	String ActualTitle = driver.getTitle();
	if(ActualTitle.equals(ExpectedTitle)) {
		System.out.println("Test case pass for ValidateTitleOne");
	}
	else
	{
		System.out.println("Test case fail for ValidateTitleOne");
	}
		
}
@Test (priority = 3)
public void ValidateTitleTwo()
{
	System.out.println("Title case Two");
	driver.get(url);	
	String CurrentUrl = driver.getTitle();
	if(CurrentUrl.contains("driver")) {
		System.out.println("Test case pass for ValidateTitleTwo");
	}
	else
	{
		System.out.println("Test case fail for ValidateTitleTwo");
	}
}

@AfterTest
public void terminateBrowser()
	{
	 	driver.close();
	}

}
