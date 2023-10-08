package October;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_Two {
	WebDriver driver;
	String url = "https://www.saucedemo.com";
	String path ="C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe";

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("WebDriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	@Test (priority = 1)
	public void validateLogin() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		boolean bl = driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(bl);
	}
	@Test (priority = 2)
	public void validateLoginFail() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		boolean bl1 = driver.findElement(By.cssSelector("#inventory_sidebar_link")).isDisplayed();
		Assert.assertTrue(bl1);
	}
	
	@AfterTest
	public void terminateBrowser()
		{
		 	driver.close();
		}
}
