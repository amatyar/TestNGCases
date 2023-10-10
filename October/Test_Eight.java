package October;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test_Eight {
	WebDriver driver;
	String url = "https://www.saucedemo.com/";	
	String path ="C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe";
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("WebDriver.chrome.driver", path);
		driver = new ChromeDriver();		
		driver.manage().window().maximize();				
	}
	@Parameters({"username","password"})
	@Test
	public void TestCase_one(String un, String pw) {
		System.out.println("Test case 1");
		driver.get(url);
		driver.findElement(By.id("user-name")).sendKeys(un);		
		driver.findElement(By.id("password")).sendKeys(pw);
		driver.findElement(By.id("login-button")).click();
		
		boolean bl = driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(bl);
	}
	@Parameters({"username","password"})
	@Test
	public void TestCase_two(String un, String pw) {
		System.out.println("Test case 2");
		driver.get(url);
		driver.findElement(By.id("user-name")).sendKeys(un);		
		driver.findElement(By.id("password")).sendKeys(pw);
		driver.findElement(By.id("login-button")).click();
		
		boolean bl = driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(bl);
	}
	@Parameters({"username","password"})
	@Test
	public void TestCase_three(String un, String pw) {
		System.out.println("Test case 3");
		driver.get(url);
		driver.findElement(By.id("user-name")).sendKeys(un);		
		driver.findElement(By.id("password")).sendKeys(pw);
		driver.findElement(By.id("login-button")).click();
		boolean bl = driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(bl);
	}
	@Parameters({"username","password"})
	@Test
	public void TestCase_four(String un, String pw) {
		System.out.println("Test case 4");
		driver.get(url);
		driver.findElement(By.id("user-name")).sendKeys(un);		
		driver.findElement(By.id("password")).sendKeys(pw);
		driver.findElement(By.id("login-button")).click();
		boolean bl = driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(bl);
	}
	
	@AfterTest
	public void terminateBrowser()
	{
	 	driver.close();
	}
}
