package October;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_Three {
	WebDriver driver;
	String url = "http://www.webdriveruniversity.com/";
	String path ="C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe";

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("WebDriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void TestCase() {
		driver.get(url);
		WebElement e = driver.findElement(By.cssSelector("#contact-us"));
		e.click();
		System.out.println("case 1");
		
	}
	@Test(priority=3)
	public void TestCase1() {
		driver.get(url);
		WebElement e = driver.findElement(By.cssSelector("#contact-us"));
		String script = "arguments[0].click()";
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript(script, e);
		System.out.println("case 2");
	}
	@Test(priority=3)
	public void TestCase2() {
		driver.get(url);
		System.out.println("case 3");
		WebElement el = driver.findElement(By.cssSelector("#scrolling-around"));
		String script = "arguments[0].scrollIntoView(true)";
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript(script, el);
	}
	@Test(priority=2)
	public void TestCase3() {
		driver.get(url);
		System.out.println("case 4");
		WebElement el = driver.findElement(By.cssSelector("#scrolling-around"));
		String script = "arguments[0].setAttribute('data-cy', 'two')";//???
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript(script, el);
		String attributeVal = el.getAttribute("data-cy");
		Assert.assertEquals(attributeVal, "two");
	}
	@Test(priority=0)
	public void TestCase4() {
		driver.get(url);
		System.out.println("case 5");
		String script = "return document.title";//???
		JavascriptExecutor je = (JavascriptExecutor)driver;
		String actualTitle = (String)je.executeScript(script);
		Assert.assertEquals(actualTitle, "WebDriverUniversity.com");
		
	}
	
	@AfterTest
	public void terminateBrowser()
		{
		 	driver.close();
		}
}
