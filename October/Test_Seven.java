package October;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test_Seven {
	WebDriver driver;
	String url = "https://www.saucedemo.com/";	
	String path ="C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe";
	
	@DataProvider(name = "Credential")
	public Object[][] data(){
		return new Object[][] {
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"}
		};
	}

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("WebDriver.chrome.driver", path);
		driver = new ChromeDriver();		
		driver.manage().window().maximize();				
	}
		
	
	
	@Test(dataProvider = "Credential")
	public void Login(String un, String pd) {		
		driver.get(url);
		driver.findElement(By.id("user-name")).sendKeys(un);
		driver.findElement(By.id("password")).sendKeys(pd);
		driver.findElement(By.id("login-button")).click();
		
		boolean avi = driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(avi);
	}
	
	@AfterTest
	public void terminateBrowser()
	{
	 	driver.close();
	}

}
