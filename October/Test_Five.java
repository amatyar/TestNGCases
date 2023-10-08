package October;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_Five {

	WebDriver driver;
	String url = "http://www.webdriveruniversity.com/";
	String url1 = "http://www.webdriveruniversity.com/Actions/index.html";
	String path ="C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe";

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("WebDriver.chrome.driver", path);
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
	}
	
	@Test
	public void TestCaseOne()
	{
		driver.get(url);
		WebElement el = driver.findElement(By.id("contact-us"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].click()", el);
		
	}
	@Test
	public void TestCaseTwo()
	{
		driver.get(url);
		WebElement el = driver.findElement(By.id("scrolling-around"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].click()", el);
		
	}
	@Test
	public void TestCaseThree()
	{
		driver.get(url);
		WebElement el = driver.findElement(By.id("scrolling-around"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].setAttribute('data-cy','Two')", el);
		String value = el.getAttribute("data-cy");
		System.out.println(value);
		
	}
	@Test
	public void TestCaseFour()
	{
		driver.get(url);
		driver.findElement(By.id("scrolling-around"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		String title = (String)je.executeScript("return document.title");
		Assert.assertEquals(title,"WebDriverUniversity.com");
		
	}
	@Test
	public void TestCaseFive()
	{
		driver.get(url1);
		Actions ac = new Actions(driver);
		WebElement el = driver.findElement(By.id("double-click"));
		ac.doubleClick(el).build().perform();
		String cName = el.getAttribute("class");
		Assert.assertEquals(cName, "div-double-click double");
		
	
		
	}
	@Test
	public void TestCaseSix()
	{
		driver.get(url);
		WebElement el = driver.findElement(By.id("scrolling-around"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].click()", el);
		
	}@Test
	public void TestCaseSeven()
	{
		driver.get("http://www.webdriveruniversity.com/Actions/index.html");
		Actions ac = new Actions(driver);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		ac.dragAndDrop(drag, drop).build().perform();
		Assert.assertEquals(drop.getText(), "Dropped!");
		Assert.assertEquals(drag.getText(), "DRAG ME TO MY TARGET!");
		
	}@Test
	public void TestCaseEight() throws InterruptedException
	{
		driver.get("http://www.webdriveruniversity.com/Actions/index.html");
		Actions ac = new Actions(driver);
		WebElement el = driver.findElement(By.id("double-click"));
		ac.contextClick(el).build().perform();
		Thread.sleep(2000);
		
	}@Test
	public void TestCaseNine()
	{
		driver.get("http://www.webdriveruniversity.com/Actions/index.html");
		Actions ac = new Actions(driver);
		WebElement el = driver.findElement(By.cssSelector("#div-hover > div.dropdown.hover > button"));
		ac.moveToElement(el).build().perform();
		WebElement ele = driver.findElement(By.cssSelector("#div-hover > div.dropdown.hover > div > a"));
		Assert.assertEquals(true, ele.isDisplayed());
		
	}
	@AfterTest
	public void terminateBrowser()
	{
	 	driver.close();
	}
	
}
