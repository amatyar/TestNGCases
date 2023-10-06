package TestNG1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day5aa {
WebDriver driver;
/*
 * Data-driven testing is a test automation technique in which the test data and the test logic are kept separated. 
 * The test data drives the testing by getting iteratively loaded to the test script. Hence, instead of having hard-coded 
 * input, we have new data each time the script loads the data from the test data source.
 */
	@DataProvider(name = "loginData")
	public Object[][]  provideLoginData(){
		return new Object [][] {
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"}
		};
		
	}
	
	@Test(dataProvider = "loginData")
	public  void Login(String username , String pass) {
		System.setProperty("webdriver.chrome.driver", "C://Users//Rabindra//OneDrive//Desktop//chromedriver1//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("login-button")).click();
		boolean avail = driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(avail);
		driver.close();
		
	}


}
