package TestNG1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Days8 
{
	@Parameters({"browser", "username","password"})
	@Test
	public void TestCase_one(String bw, String un, String pwd) {
		System.out.println("Test case one is passed");
		System.out.println(bw + un + pwd);		
	}
	
	@Test
	public void TestCase_two() {
		System.out.println("Test case two is passed");
		
	}
	
	@Test
	public void TestCase_three() {
		System.out.println("Test case three is passed");
		
	}


}
