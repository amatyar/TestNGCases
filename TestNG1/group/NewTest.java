package TestNG1.group;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
String baseUrl = "http://demo.guru99.com/test/newtours/";
String driverPath ="C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe";
WebDriver driver;


@BeforeTest
public void launchBrowser() {
	System.setProperty("WebDriver.chrome.driver", driverPath);
	driver = new ChromeDriver();
	driver.get(baseUrl);
	driver.manage().window().maximize();
}
@BeforeMethod
public void verifyTitle() {
	String ExpectedTitle="Welcome: Mercury Tours";
	String actualTitle = driver.getTitle();
	Assert.assertEquals(actualTitle, ExpectedTitle);
}



@Test(priority =0)
public void register() {
	driver.findElement(By.linkText("REGISTER")).click();
	String expected ="Register: Mercury Tours";
	String actual = driver.getTitle();
	Assert.assertEquals(actual, expected);
}
@Test(priority = 1)
public void support() {
	driver.findElement(By.linkText("SUPPORT")).click();
	String expected ="Under Construction: Mercury Tours";
	String actual = driver.getTitle();
	Assert.assertEquals(actual, expected);
}

@AfterMethod
public void goBackToHomepage() {
	driver.findElement(By.linkText("Home")).click();
}
	@AfterTest
	public void terminateBrowser()
	{
		driver.close();
	}
}



