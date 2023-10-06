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
	public void Testcase1(String un, String pwd) {
		System.out.println("test case one");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys(un);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("login-button")).click();
		boolean avail =driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(avail);
		driver.close();
		
	}
	@Parameters({"username","password"})

	@Test
	
	public void Testcase2(String un, String pwd) {
		System.out.println("test case two");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys(un);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("login-button")).click();
		boolean avail =driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(avail);
		driver.close();
		
	}
	@Parameters({"username","password"})
	
	@Test
	public void Testcase3(String un, String pwd) {
		System.out.println("test case three");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys(un);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("login-button")).click();
		boolean avail =driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(avail);
		driver.close();
		
	}
	@Parameters({"username","password"})
	@Test
	public void Testcase4(String un, String pwd) {
		System.out.println("test case four");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys(un);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("login-button")).click();
		boolean avail =driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(avail);
		driver.close();
		
	}

	
	
}
