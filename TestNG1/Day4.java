package TestNG1;

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

public class Day4 {
	String url = "http://www.webdriveruniversity.com/";
	String url1 ="http://www.webdriveruniversity.com/Actions/index.html";
	String path ="C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe";
	WebDriver driver;
	@BeforeTest
	public void launchBrowser() {
		System.setProperty("WebDriver.chrome.driver", path);
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
	}
	@Test
	public void Test_Case1() {
		//JavaScript executor to click on element		
		driver.get(url);
		
		WebElement contact_us = driver.findElement(By.id("contact-us"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click", contact_us);		
		
	}
	
	@Test
	public void Test_Case2() throws InterruptedException {
		//JavaScript executor to click on element		
		driver.get(url);
		
		WebElement Scoll_Elem = driver.findElement(By.id("scrolling-around"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", Scoll_Elem);	
		Thread.sleep(2000);
		
	}
	@Test
	public void Test_Case3() {
		//JavaScript executor to click on element	
		driver.get(url);
		
		WebElement Scoll_Elem = driver.findElement(By.id("scrolling-around"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].setAttribute('data-cy', 'two')", Scoll_Elem);	
		String attributeValue = Scoll_Elem.getAttribute("data-cy"); // two
		System.out.println(attributeValue);
		
	}
	@Test
	public void Test_Case4() {
		//JavaScript executor to click on element		
		driver.get(url);
		
		JavascriptExecutor je = (JavascriptExecutor) driver;		
		String Title = (String) je.executeScript("return document.title;");
		Assert.assertEquals(Title,"WebDriverUniversity.com");
	
	}
	@Test
	public void Test_Case5() {	
	
		driver.get(url1);
		Actions ac = new Actions(driver);
		WebElement el = driver.findElement(By.id("double-click"));
		ac.doubleClick(el).build().perform();
		String className = el.getAttribute("class");
		Assert.assertEquals(className, "div-double-click double");		
		
	}
	@Test
	public void Test_Case6() {
	
		driver.get(url1);
		Actions ac = new Actions(driver);
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		ac.dragAndDrop(draggable, droppable).build().perform();
		Assert.assertEquals(droppable.getText(),"Dropped!");
		
	}
	@Test
	public void Test_Case7() {
		
		driver.get(url1);
		Actions ac = new Actions(driver);
		WebElement clickable = driver.findElement(By.id("click-box"));
		
		ac.clickAndHold(clickable).build().perform();
		Assert.assertEquals(clickable.getText(),"Well done! keep holding that click now.....");
		
	}
	@Test
	public void Test_Case8() throws InterruptedException {
		
		
		driver.get(url1);
		Actions ac = new Actions(driver);
		WebElement e = driver.findElement(By.cssSelector("#double-click"));		
		ac.contextClick(e).build().perform();
		Thread.sleep(3000);
	
	}
	@Test
	public void Test_Case9() {
		
		
		driver.get(url1);
		Actions ac = new Actions(driver);		
		WebElement e = driver.findElement(By.cssSelector("#div-hover > div.dropdown.hover > button"));
		ac.moveToElement(e).build().perform();
		WebElement e2 = driver.findElement(By.cssSelector("#div-hover > div.dropdown.hover > div > a"));
		Assert.assertEquals(true,e2.isDisplayed());	
		
		
	}
	@AfterTest
	public void terminateBrowser()
	{
		driver.close();
	}
}
