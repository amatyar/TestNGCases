package October;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class TestListener implements ITestListener {
	
	@Test
	public void loginFB() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("rabindra.amatya@gmail.com");
        driver.findElement(By.id("wronglocator")).sendKeys("dont-tell");
        driver.findElement(By.id("loginbutton")).click();
		
		
		
	}
	
	
	
	@Override
    public void onFinish(ITestContext arg0) {
                
    }

 

     @Override
    public void onStart(ITestContext arg0) {
        
       
    }

     @Override
     public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
         // TODO Auto-generated method stub
        
     }

  @Override
    public void onTestFailure(ITestResult arg0) {
        

    }
	
  @Override
  public void onTestSkipped(ITestResult arg0) {
      // TODO Auto-generated method stub
     
     
  }

  @Override
  public void onTestStart(ITestResult arg0) {
      // TODO Auto-generated method stub
      System.out.println("TestCase started====" +arg0.toString());
     
  }

  @Override
  public void onTestSuccess(ITestResult arg0) {
      // TODO Auto-generated method stub
     
      System.out.println("Congrates Testcase has been passed===="+ arg0.toString());
     
  }
}
