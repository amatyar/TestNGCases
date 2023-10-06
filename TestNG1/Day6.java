package TestNG1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day6 {
	WebDriver driver;
	@Parameters({"username","password"})
	@Test
	public void TestCase1(String un , String pwd) {
		System.out.println("Test case one");
		System.setProperty("webdeiver.chrome.deriver", 
				"C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys(un);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("login-button")).click();
		boolean avail = driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(avail);
		driver.close();	
	}

	@Parameters({"username","password"})
	@Test
	public void TestCase2(String un , String pwd) {
		System.out.println("Test case two");
		System.setProperty("webdeiver.chrome.deriver", 
				"C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys(un);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("login-button")).click();
		boolean avail = driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(avail);
		driver.close();
	}

	
	@Parameters({"username","password"})
	@Test
	public void TestCase3(String un , String pwd) {
		System.out.println("Test case two");
		System.setProperty("webdeiver.chrome.deriver", 
				"C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys(un);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("login-button")).click();
		boolean avail = driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(avail);
		driver.close();
	}
	
	@Parameters({"username","password"})
	@Test
	public void TestCase4(String un , String pwd) {
		System.out.println("Test case two");
		System.setProperty("webdeiver.chrome.deriver", 
				"C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys(un);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("login-button")).click();
		boolean avail = driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(avail);
		driver.close();
	}

	
	
}
