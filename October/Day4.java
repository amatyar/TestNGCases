package October;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day4 {
	 WebDriver driver;

	 @DataProvider(name = "loginCredentials")
	 public Object[][] provideLoginCredentials() {
	  return new Object[][] {
	        { "standard_user", "secret_sauce" },
	        { "locked_out_user", "secret_sauce" },
	        { "problem_user", "secret_sauce" }, 
	        { "performance_glitch_user", "secret_sauce" } };
	 }
	 @Test(dataProvider="loginCredentials")
	 public void logIn(String username, String password) {
		 System.setProperty("webdriver.chrome.driver", "C://Users//Rabindra//OneDrive//Desktop//chromedriver1//chromedriver.exe");
			driver = new ChromeDriver();
	  driver.get("https://www.saucedemo.com/");
	  driver.findElement(By.cssSelector("#user-name")).sendKeys(username);
	  driver.findElement(By.cssSelector("#password")).sendKeys(password);
	  driver.findElement(By.cssSelector("#login-button")).click();
	  boolean B1 = driver.getCurrentUrl().contains("inventory");
	  Assert.assertTrue(B1);
	 }
}
