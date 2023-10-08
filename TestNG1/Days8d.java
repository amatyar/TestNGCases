package TestNG1;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

//@Ignore
public class Days8d {
	
	@Test(priority = 1)
	public void TestCase_Eleven() {
		System.out.println("Test case Eleven pass");
	}
	
	@Ignore
	@Test(priority = 2)
	public void TestCase_Twelve() {
		System.out.println("Test case Twelve pass");
	}
	@Test(priority = 3)
	public void TestCase_Thirteen() {
		System.out.println("Test case Thirteen pass");
	}
}
