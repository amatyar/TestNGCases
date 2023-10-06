package TestNG1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day7 {

WebDriver driver;
	
	@Test
	public void AutoSuggestiveDropDown() {
		driver = new ChromeDriver();
		driver.get("http://www.webdriveruniversity.com/Autocomplete-TextField/autocomplete-textfield.html");
		driver.findElement(By.id("myInput")).sendKeys("p");
		List<WebElement> list = driver.findElements(By.cssSelector("#myInputautocomplete-list > div"));
		for(int i=0; i<list.size();i++) {
			System.out.println(i);
			//String text = list.get(i).getText();
			//System.out.println(text);
			if(list.get(i).getText().contains("Pancakes")) {
				list.get(i).click();
				break;
			}
		}
		driver.findElement(By.id("submit-button")).click();
		String cl = driver.getCurrentUrl();
		boolean avail =cl.contains("Pancakes");
		Assert.assertTrue(avail);
		driver.close();
		
	}
	
	@Test
	public void AutoSuggestiveDropDownTwo() {
		driver = new ChromeDriver();
		driver.get("http://www.webdriveruniversity.com/Autocomplete-TextField/autocomplete-textfield.html");
		WebElement inputE =driver.findElement(By.id("myInput"));
		inputE.sendKeys("p");
		inputE.sendKeys(Keys.ARROW_DOWN);
		inputE.sendKeys(Keys.ENTER);
		driver.findElement(By.id("submit-button")).click();
		String cl = driver.getCurrentUrl();
		boolean avail =cl.contains("Pizza");
		Assert.assertTrue(avail);
		driver.close();
		
		
	}
	
}
