package October;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
	String Nurl="https://www.webdriveruniversity.com/Autocomplete-TextField/autocomplete-textfield.html";
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
		Assert.assertEquals(e.getText(),"Well done! keep holding that click now.....");
	}
	@Test
	public void TestCase3() {
		WebElement el= driver.findElement(By.cssSelector("#div-hover > div.dropdown.hover > button"));
		ac.moveToElement(el).build().perform();
		boolean visible = driver.findElement(By.cssSelector("#div-hover > div.dropdown.hover > div > a")).isDisplayed();
		Assert.assertTrue(visible);
		
	}
	@Test
	public void TestCase4() {
		WebElement el = driver.findElement(By.cssSelector("#double-click"));
		ac.contextClick(el).build().perform();
	}
	@Test
	public void TestCase5() {
		driver.get(Nurl);
		WebElement input = driver.findElement(By.id("myInput"));
		input.sendKeys("p");
		List<WebElement> inputs = driver.findElements(By.cssSelector("#myInputautocomplete-list > div"));
		for(int i =0; i <inputs.size(); i++) {
			//System.out.println(i);
			String opt = inputs.get(i).getText();
			System.out.println(opt);
			if(opt.equals("Pancakes")) {
				inputs.get(i).click();
				break;
			}
		}
		driver.findElement(By.cssSelector("#submit-button")).click();
		String urlText = driver.getCurrentUrl();
		boolean av = urlText.contains("Pancakes");
		Assert.assertTrue(av);
	}
	@Test
	public void TestCase6() {
		driver.get(Nurl);
		WebElement input = driver.findElement(By.id("myInput"));
		input.sendKeys("p");
		input.sendKeys(Keys.ARROW_DOWN);
		input.sendKeys(Keys.ENTER);
		driver.findElement(By.cssSelector("#submit-button")).click();
		String urlText = driver.getCurrentUrl();
		boolean av = urlText.contains("Pizza");
		Assert.assertTrue(av);
	}
	
	@AfterTest
	public void terminateBrowser()
		{
		 	driver.close();
		}
}
