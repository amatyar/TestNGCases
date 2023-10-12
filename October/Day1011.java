package October;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day1011 {
	WebDriver driver;		
	String url = "https://www.webdriveruniversity.com/Datepicker/index.html";	
	String path ="C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver1\\chromedriver.exe";

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("WebDriver.chrome.driver", path);		
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
	}
	@Test
	public void pickDateTest() throws InterruptedException {
		
		String month = "January";
		  String year = "2024";
		  String date = "1";
		 driver.get(url);
		  driver.findElement(By.id("datepicker")).click();
		  selectDate(driver ,date,month,year);
	}
	public static void selectDate(WebDriver driver ,String date ,String month , String year) throws InterruptedException {
		  
		  String text = driver.findElement(By.className("datepicker-switch")).getText();
		  //System.out.println(text);
		  String actualMonth = text.split(" ")[0];
		  String actualYear = text.split(" ")[1];
		  System.out.println(actualMonth);
		  System.out.println(actualYear);
		  System.out.println(actualMonth.equals(month)&& actualYear.equals(year));
		  
		  while(!(actualMonth.equals(month)&& actualYear.equals(year))) {
	
		   driver.findElement(By.className("next")).click();		   
		   text = driver.findElement(By.className("datepicker-switch")).getText();
		   actualMonth = text.split(" ")[0];
		   actualYear = text.split(" ")[1];
		   //Display month and year
		   System.out.println(actualMonth);
		   System.out.println(actualYear);
		  }
		  //get list of days
		  List <WebElement>  ele = driver.findElements(By.className("day"));
		  for(int i = 0 ; i < ele.size() ;i++ ) {
		   if(ele.get(i).getText().equals(date)) {
		    ele.get(i).click();
		    break;
		   }
		  }
	}
}
