package TestNG1;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day1 {
	@Test
	public void Test() {
		System.out.println("hello");
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver\\chromedriver.exe");		
		WebDriver dr = new ChromeDriver(); 
		String url ="https://the-internet.herokuapp.com/javascript_alerts";
		dr.get(url);
		dr.manage().window().maximize();
		WebElement ele = dr.findElement(By.id("result"));
		dr.findElement(By.cssSelector("#content > div > ul > li:nth-child(2) > button")).click();
		String text = dr.switchTo().alert().getText();
		if(text.equals("I am a JS Confirm")) 
		{
			System.out.println("Test case for text pass");
			dr.switchTo().alert().accept();
		   System.out.println(ele.getText());
		   if(ele.getText().equals("You clicked: Ok")) 
		   {
		    System.out.println("Test case for element text pass");   
		    }
		}
	}

}
