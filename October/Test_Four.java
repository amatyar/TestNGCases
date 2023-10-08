package October;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_Four {
	WebDriver driver;
	Actions ac;
	String url = "http://www.webdriveruniversity.com/Actions/index.html";
	String path ="C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe";

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("WebDriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		ac = new Actions(driver);
	}
	
	@Test
	public void TestCase0() {
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		ac.dragAndDrop(drag, drop).build().perform();
		Assert.assertEquals(drop.getText(), "Dropped!");
		
	}
	@Test
	public void TestCase1() {
		WebElement e = driver.findElement(By.id("double-click"));
		ac.doubleClick(e).build().perform();
		String expected = e.getAttribute("class");
		Assert.assertEquals(expected, "div-double-click double");
	}
	@Test
	public void TestCase2() {
		WebElement e = driver.findElement(By.id("click-box"));
		ac.clickAndHold(e).build().perform();
		Assert.assertEquals(null, false);
	}
	@Test
	public void TestCase3() {
		
	}
	@Test
	public void TestCase4() {
		
	}
	
	
	@AfterTest
	public void terminateBrowser()
		{
		 	//driver.close();
		}
}
