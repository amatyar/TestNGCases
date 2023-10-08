package October;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test_Six {
	WebDriver driver;
	String url = "https://www.browserstack.com/";	
	String path ="C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe";

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("WebDriver.chrome.driver", path);
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
	}
	// assertEquals
	@Test
	public void TestCaseOne() {
		driver.get(url);
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Most Reliable App & Cross Browser Testing Platform | BrowserStack";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	}
	//Not equal
	@Test
	public void TestCaseTwo() {
		driver.get(url);
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Most Reliable App & Cross Browser Testing Platform | browserStack";
		Assert.assertNotEquals(ActualTitle,ExpectedTitle);
	}
	//assertTrue()
	@Test
	public void TestCaseThree() {
		driver.get(url);
		String ExpectedTitle = "Most Reliable App & Cross Browser Testing Platform | BrowserStack";
		boolean verifyTitle = driver.getTitle().equalsIgnoreCase(ExpectedTitle);
		Assert.assertTrue(verifyTitle);
	}
	//AssertFalse
	@Test
	public void TestCaseFour() {
		driver.get(url);
		boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Most Reliable App & Cross Browser Testing Platform ");
		Assert.assertFalse(verifyTitle);
	}
	//Assert null
	@Test
	public void TestCaseFive() {
		driver.get(url);
		String verifyNull = null;		
		Assert.assertNull(verifyNull);
	}
	//Assert Not Null
	@Test
	public void TestCaseSix() {
		driver.get(url);		
		boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Most Reliable App & Cross Browser Testing Platform ");
		Assert.assertNotNull(verifyTitle);
	}
	// Hard Assert 
	@Test
	public void TestCaseSeven() {
		driver.get(url);
		String ActualTitle = driver.getTitle();
		String verifyAssertNull = null;
		String ExpectedTitle = "Most Reliable App & Cross Browser Testing Platform | BrowserStack";
		boolean verifyIsPresent = driver.getTitle().equalsIgnoreCase("Most Reliable App & Cross Browser Testing Platform | BrowserStack");
		boolean verifyIsChanged = driver.getTitle().equalsIgnoreCase("Testing Platform | BrowserStack");
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		Assert.assertNotEquals(ExpectedTitle, "browerstack");
		Assert.assertTrue(verifyIsPresent);
		Assert.assertFalse(verifyIsChanged);
		Assert.assertNotNull(verifyIsPresent);
		Assert.assertNull(verifyAssertNull);
	}
	//Soft Assert . assertAll()
	
	@Test
	public void TestCaseEight() {
		driver.get(url);
		SoftAssert softAssert = new SoftAssert();
		String ActualTitle = driver.getTitle();
		
		String verifyAssertNull = null;
		String ExpectedTitle = "Most Reliable App & Cross Browser Testing Platform | BrowserStack";		
		boolean verifyIsPresent = driver.getTitle().equalsIgnoreCase(ExpectedTitle);		
		softAssert.assertEquals(ExpectedTitle, ActualTitle);		
		softAssert.assertNotEquals(ActualTitle, "browerstack");
		
		softAssert.assertTrue(verifyIsPresent);
		softAssert.assertFalse("BrowserStack".equals("Browserstack"), "First soft assert failed");
		softAssert.assertNotNull(verifyIsPresent);
		softAssert.assertNull(verifyAssertNull);
		softAssert.assertAll();
	}
	
	@AfterTest
	public void terminateBrowser()
	{
	 	driver.close();
	}
}
